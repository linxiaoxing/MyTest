//
//  YMAutoPlayVideoController.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/18.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

class YMAutoPlayVideoController: UITableViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        setupUI()
    }
    
    private func setupUI() {
        view.backgroundColor = YMGlobalColor()
        let footerView = UIView()
        tableView.tableFooterView = footerView
        tableView.rowHeight = 55
        tableView.separatorStyle = .none
    }
}

extension YMAutoPlayVideoController {
    
    override func numberOfSections(in tableView: UITableView) -> Int {
        return 3
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
         return 0
    }
}
