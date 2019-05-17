//
//  YMCollectionViewController.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/18.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

class YMCollectionViewController: UITableViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        setupUI()
        
    }
    
    func setupUI() {
        view.backgroundColor = YMGlobalColor()
        navigationItem.rightBarButtonItem = UIBarButtonItem(title: "编辑", style: .plain, target: self, action: #selector(editBBItemClick))
    }
}

extension YMCollectionViewController {
    
    @objc func editBBItemClick() {
        print(#function)
    }
    
}
