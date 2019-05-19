//
//  YMVideoViewController.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/16.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

class YMVideoViewController: YMBaseViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        setupUI()
    }
    
    private func setupUI() {
        navigationItem.title = ""
        titleBGView.addSubview(titleScrollView)
        titleBGView.addSubview(titleSearchButton)
        navigationItem.titleView = titleBGView
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    private lazy var titleSearchButton: UIButton = {
        let titleSearchButton = UIButton()
        titleSearchButton.setBackgroundImage(UIImage(named: "shadow_addolder_titlebar_44x36_"), for: .normal)
        titleSearchButton.backgroundColor = UIColor.red
        titleSearchButton.frame = CGRect(x: SCREENW - 30, y: 0, width: 30, height: 44)
        return titleSearchButton
    }()
    
    private lazy var titleBGView: UIView = {
        let titleBGView = UIView()
        titleBGView.frame = CGRect(x: 0, y: 0, width: SCREENW, height: 44)
        return titleBGView
    }()
    
    private lazy var titleScrollView: UIScrollView = {
        let titleScrollView = UIScrollView()
        titleScrollView.backgroundColor = UIColor.cyan
        titleScrollView.frame = CGRect(x: 0, y: 0, width: SCREENW - 30, height: 44)
        return titleScrollView
    }()
}
