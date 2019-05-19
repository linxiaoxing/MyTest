//
//  YMAddTopicViewController.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/20.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

class YMAddTopicViewController: UIViewController {
    
    /// 我的频道
    var myTopics = [YMTopic]()
    /// 推荐频道
    var recomendTopics = [YMTopic]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupUI()
    }
    
    private func setupUI() {
        view.backgroundColor = UIColor.white
        navigationItem.rightBarButtonItem = UIBarButtonItem(title: "X", style: .plain, target: self, action: #selector(closeBBItemClick))
        // 去除 navigationBar 底部的黑线
        navigationController?.navigationBar.shadowImage = UIImage()
        navigationController?.navigationBar.setBackgroundImage(UIImage(), for: .default)
    }
    
    @objc func closeBBItemClick() {
        dismiss(animated: false, completion: nil)
    }
}
