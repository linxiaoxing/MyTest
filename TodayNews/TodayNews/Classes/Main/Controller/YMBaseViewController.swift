//
//  YMBaseViewController.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/16.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit
import SVProgressHUD

class YMBaseViewController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        view.backgroundColor = YMGlobalColor()
        view.backgroundColor = YMGlobalColor()
        SVProgressHUD.setDefaultStyle(SVProgressHUDStyle.custom)
        SVProgressHUD.setMinimumDismissTimeInterval(1.0)
        SVProgressHUD.setBackgroundColor(UIColor(red: 0, green: 0, blue: 0, alpha: 0.5))
        SVProgressHUD.setForegroundColor(UIColor.white)
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
}

