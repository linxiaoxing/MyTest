//
//  GitHubNetworkService.swift
//  RxMVVM
//
//  Created by 林小興 on 2019/05/26.
//  Copyright © 2019 林小興. All rights reserved.
//

import RxSwift
import RxCocoa
import ObjectMapper

class GitHubNetworkService {
    
    //搜索资源数据
    func searchRepositories(query:String) -> Observable<GitHubRepositories> {
        return GitHubProvider.rx.request(.repositories(query))
            .filterSuccessfulStatusCodes()
            .mapObject(GitHubRepositories.self)
            .asObservable()
            .catchError({ error in
                print("发生错误：",error.localizedDescription)
                return Observable<GitHubRepositories>.empty()
            })
    }
}
