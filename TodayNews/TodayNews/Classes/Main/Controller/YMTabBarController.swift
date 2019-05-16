//
//  YMTabBarController.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/16.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

class YMTabBarController: UITabBarController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // NavigationBar
        UINavigationBar.appearance().tintColor = UIColor.purple
        // BarButtonItem
        UITabBar.appearance().tintColor = UIColor.yellow
        
        // add childViewController
        addChildViewControllers()
    }
    
    /**
     # 添加子控制器
     */
    private func addChildViewControllers() {
        addChildViewController(YMHomeViewController(), title: "我的", imageName: "home_tabbar_22x22_", selectedImageName: "home_tabbar_press_22x22_")
        addChildViewController(YMVideoViewController(), title: "视频", imageName: "video_tabbar_22x22_", selectedImageName: "video_tabbar_press_22x22_")
        addChildViewController(YMNewCareViewController(), title: "关心", imageName: "newcare_tabbar_22x22_", selectedImageName: "newcare_tabbar_press_22x22_")
        addChildViewController(YMMineViewController(), title: "我的", imageName: "mine_tabbar_22x22_", selectedImageName: "mine_tabbar_press_22x22_")
    }
    
    func addChildViewController(_ childController: UIViewController, title: String, imageName: String, selectedImageName: String) {
        childController.tabBarItem.image = UIImage(named: imageName)
        childController.tabBarItem.selectedImage = UIImage(named: selectedImageName)
        childController.title = title
        let nav = YMNavigationController(rootViewController: childController)
        addChild(nav)
    }
}
