//
//  YMNewCareSearchController.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/19.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

let leftCategoryID = "leftCategoryID"
let rightContentID = "rightContentID"

class YMNewCareSearchController: YMBaseViewController {
    
    /// 左侧分类Table
    @IBOutlet weak var leftCategoryTableView: UITableView!
    /// 右侧内容Table
    @IBOutlet weak var rightContentTableView: UITableView!
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        searchBar.resignFirstResponder()
    }
    
    private func setupUI() {
        navigationItem.titleView = searchBar
        let leftNib = UINib(nibName: "YMNewCareCategoryCell", bundle: nil)
        leftCategoryTableView.register(leftNib, forCellReuseIdentifier: leftCategoryID)
        let rightNib = UINib(nibName: "YMNewCareContentCell", bundle: nil)
        rightContentTableView.register(rightNib, forCellReuseIdentifier: rightContentID)
        automaticallyAdjustsScrollViewInsets = false
        leftCategoryTableView.contentInset = UIEdgeInsets(top: 64, left: 0, bottom: 0, right: 0)
        rightContentTableView.contentInset = leftCategoryTableView.contentInset
        leftCategoryTableView.tableFooterView = UIView()
        rightContentTableView.tableFooterView = UIView()
        leftCategoryTableView.rowHeight = 70
        rightContentTableView.rowHeight = 70
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        setupUI()
        
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

extension YMNewCareSearchController: UITableViewDelegate, UITableViewDataSource {
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 10
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        if tableView == leftCategoryTableView {
            let categoryCell = tableView
                .dequeueReusableCell(withIdentifier: leftCategoryID) as! YMNewCareCategoryCell
            categoryCell.textLabel?.text = "iOS"
            return categoryCell
        } else {
            let contentCell = tableView.dequeueReusableCell(withIdentifier: rightContentID) as! YMNewCareContentCell
            
            return contentCell
        }
    }
}
