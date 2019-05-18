//
//  YMAccountManageController.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/18.
//  Copyright © 2019 林小興. All rights reserved.
//
import UIKit


class YMAccountManageController: UITableViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        setupUI()
    }
    
    func setupUI() {
        view.backgroundColor = YMGlobalColor()
        navigationItem.rightBarButtonItem = UIBarButtonItem(title: "完成", style: .plain, target: self, action: #selector(finishBBItemClick))
    }
}

extension YMAccountManageController {
    
    @objc func finishBBItemClick() {
        navigationController?.popViewController(animated: true)
    }
    
    // MARK: - Table view data source
    override func numberOfSections(in tableView: UITableView) -> Int {
        return 0
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 0
    }
}
