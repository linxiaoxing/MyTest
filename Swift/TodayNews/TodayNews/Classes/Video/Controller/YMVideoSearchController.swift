//
//  YMVideoSearchController.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/19.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

class YMVideoSearchController: YMBaseViewController {
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        searchBar.resignFirstResponder()
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        setupUI()
        
    }
    
    private func setupUI() {
        navigationItem.titleView = searchBar
        searchBar.becomeFirstResponder()
        navigationController?.navigationBar.barTintColor = UIColor.white
        navigationItem.rightBarButtonItem = UIBarButtonItem(title: "取消", style: .plain, target: self, action: #selector(cancelBBItemClick))
    }
    
    @objc func cancelBBItemClick() {
        navigationController?.popViewController(animated: false)
    }
    
    private lazy var searchBar: UISearchBar = {
        let searchBar = UISearchBar()
        searchBar.placeholder = "请输入关键字"
        return searchBar
    }()
}

extension YMVideoSearchController {
    
    override func touchesBegan(_ touches: Set<UITouch>,
                               with event: UIEvent?) {
        searchBar.resignFirstResponder()
    }
}
