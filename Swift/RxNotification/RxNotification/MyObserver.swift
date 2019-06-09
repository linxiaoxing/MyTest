//
//  MyObserver.swift
//  RxNotification
//
//  Created by 林小興 on 2019/05/29.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit
import RxSwift
import RxCocoa

class MyObserver: NSObject {
    
     var name:String = ""
    
    init(name:String){
        super.init()
        
        self.name = name
        
        // 接收通知：
        let notificationName = Notification.Name(rawValue: "DownloadImageNotification")
        _ = NotificationCenter.default.rx.notification(notificationName)
            .takeUntil(self.rx.deallocated)
            .subscribe(onNext: { notification in
                //获取通知数据
                let userInfo = notification.userInfo as! [String: AnyObject]
                let value1 = userInfo["value1"] as! String
                let value2 = userInfo["value2"] as! Int
                print("\(name) 获取到通知，用户数据是［\(value1),\(value2)］")
                //等待3秒
                sleep(3)
                print("\(name) 执行完毕")
            })
    }
}
