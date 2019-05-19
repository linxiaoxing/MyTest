//
//  YMNewCareSearchController.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/19.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

class YMNewCareSearchController: YMBaseViewController {
    
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
        
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    private lazy var searchBar: UISearchBar = {
        let searchBar = UISearchBar()
        searchBar.placeholder = "搜你关心的"
        return searchBar
    }()
    
}

extension YMNewCareSearchController {
    override func touchesBegan(_ touches: Set<UITouch>,
                               with event: UIEvent?) {
         searchBar.resignFirstResponder()
    }
}
