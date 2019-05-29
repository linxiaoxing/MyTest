//
//  ViewController.swift
//  RxNotification
//
//  Created by 林小興 on 2019/05/29.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit
import RxSwift
import RxCocoa

class ViewController: UIViewController {

    let disposeBag = DisposeBag()
    
    let observers = [MyObserver(name: "观察器1"),MyObserver(name: "观察器2")]
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        noticEnterBack()
        
        // 监听键盘的通知
        noticKeyboard()
        
        noticCustom()
    }

    // 监听应用进入后台的通知
    private func noticEnterBack() {
        // 监听应用进入后台通知
        _ = NotificationCenter.default.rx
            .notification(UIApplication.didEnterBackgroundNotification)
            .takeUntil(self.rx.deallocated)
            .subscribe(onNext: { _ in
                print("程序进入到后台了")
            })
    }
    
    private func noticKeyboard() {
        let textField = UITextField(frame: CGRect(x:20, y:100, width:200, height:30))
        textField.borderStyle = .roundedRect
        textField.returnKeyType = .done
        self.view.addSubview(textField)
        
        //点击键盘上的完成按钮后，收起键盘
        textField.rx.controlEvent(.editingDidEndOnExit)
            .subscribe(onNext: { _ in
                //收起键盘
                textField.resignFirstResponder()
            }).disposed(by: disposeBag)
        
        //监听键盘弹出通知
        _ = NotificationCenter.default.rx
            .notification(UIResponder.keyboardWillShowNotification)
            .takeUntil(self.rx.deallocated)
            .subscribe(onNext: { _ in
                print("键盘出现了")
            })
        
        //监听键盘隐藏通知
        _ = NotificationCenter.default.rx
            .notification(UIResponder.keyboardWillHideNotification)
            .takeUntil(self.rx.deallocated) //页面销毁自动移除通知监听
            .subscribe(onNext: { _ in
                print("键盘消失了")
            })
    }
    
    private func noticCustom() {
        print("发送通知")
        let notificationName = Notification.Name(rawValue: "DownloadImageNotification")
        NotificationCenter.default.post(name: notificationName, object: self,
                                        userInfo: ["value1":"hangge.com", "value2" : 12345])
        print("通知完毕")
    }
    
}

