//
//  YMHomeViewController.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/16.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

class YMHomeViewController: YMBaseViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        setupUI()
    }
    
    private func setupUI() {
        view.backgroundColor = YMGlobalColor()
        navigationItem.titleView = titleView
        navigationController?.navigationBar.barStyle = .black
        navigationController?.navigationBar.barTintColor = YMColor(210, g: 63, b: 66, a: 1.0)
    }
    
    private lazy var titleView: YMTitleView = {
        let titleView = YMTitleView.titleView()
        titleView.delegate = self
        //titleView.imageName = "search_topic_24x24_"
         return titleView
    }()
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
}

extension YMHomeViewController: YMTitleViewDelegate {
    
    
    
    // MARK: - YMTitleViewDelegate
    func titleView(_: YMTitleView, titleSearchButton button: UIButton) {
        let addTopicVC = YMAddTopicViewController()
        let nav = YMNavigationController(rootViewController: addTopicVC)
        present(nav, animated: false, completion: nil)
    }
}
