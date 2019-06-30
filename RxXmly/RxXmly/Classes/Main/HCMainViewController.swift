//
//  HCMainViewController.swift
//  RxXmly
//
//  Created by 林小興 on 2019/06/22.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

class HCMainViewController: UITabBarController {
    
    lazy var playView = HCTabbarP
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.delegate = self
        mainViewController = self
        
        
    }
}
