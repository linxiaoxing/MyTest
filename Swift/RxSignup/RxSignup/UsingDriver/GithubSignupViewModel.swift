//
//  GithubSignupViewModel1.swift
//  RxSignup
//
//  Created by 林小興 on 2019/05/27.
//  Copyright © 2019 林小興. All rights reserved.
//

import RxSwift
import RxCocoa
import UIKit
import Foundation

class GithubSignupViewModel {
    //用户名验证结果
    let validatedUsername: Driver<ValidationResult>
    
    //密码验证结果
    let validatedPassword: Driver<ValidationResult>
    
    //再次输入密码验证结果
    let validatedPasswordRepeated: Driver<ValidationResult>
    
    //注册按钮是否可用
    let signupEnabled: Driver<Bool>
    
    //注册结果
    let signupResult: Driver<Bool>
    
    //ViewModel初始化（根据输入实现对应的输出）
    init(
        input: (
        username: Driver<String>,
        password: Driver<String>,
        repeatedPassword: Driver<String>,
        loginTaps: Signal<Void>
        ),
        dependency: (
        networkService: GitHubNetworkService,
        signupService: GitHubSignupService
        )) {
        
        //用户名验证
        validatedUsername = input.username
            .flatMapLatest { username in
                return dependency.signupService.validateUsername(username)
                    .asDriver(onErrorJustReturn: .failed(message: "服务器发生错误!"))
        }
        
        //用户名密码验证
        validatedPassword = input.password
            .map { password in
                return dependency.signupService.validatePassword(password)
        }
        
        //重复输入密码验证
        validatedPasswordRepeated = Driver.combineLatest(
            input.password,
            input.repeatedPassword,
            resultSelector: dependency.signupService.validateRepeatedPassword)
        
        //注册按钮是否可用
        signupEnabled = Driver.combineLatest(
            validatedUsername,
            validatedPassword,
            validatedPasswordRepeated
        ) { username, password, repeatPassword in
            username.isValid && password.isValid && repeatPassword.isValid
            }
            .distinctUntilChanged()
        
        //获取最新的用户名和密码
        let usernameAndPassword = Driver.combineLatest(input.username, input.password) {
            (username: $0, password: $1) }
        
        //注册按钮点击结果
        signupResult = input.loginTaps.withLatestFrom(usernameAndPassword)
            .flatMapLatest { pair in  //也可考虑改用flatMapFirst
                return dependency.networkService.signup(pair.username,
                                                        password: pair.password)
                    .asDriver(onErrorJustReturn: false)
        }
    }}
