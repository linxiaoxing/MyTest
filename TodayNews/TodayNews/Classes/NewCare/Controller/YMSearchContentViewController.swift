//
//  YMSearchContentViewController.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/19.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

protocol YMSearchContentViewControllerDelegate: NSObjectProtocol {
    func cancelButtonClickedPopViewcontroller()
}

let searchContentCellID = "YMsearchCell"

class YMSearchContentViewController: YMBaseViewController {
    
     var keywords = [YMKeyword]()
    
     weak var tableView: UITableView?
    
     weak var delegate: YMSearchContentViewControllerDelegate?
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        searchBar.becomeFirstResponder()
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        setupUI()
    }
    
    // 设置 UI
    private func setupUI() {
        navigationItem.rightBarButtonItem = UIBarButtonItem(title: "取消", style: .plain, target: self, action: #selector(cancelBBItemClick))
        navigationItem.titleView = searchBar
        navigationItem.rightBarButtonItem?.tintColor = YMColor(37, g: 142, b: 240, a: 1.0)
        let tableView = UITableView(frame: view.bounds)
        tableView.tableFooterView = UIView()
        tableView.rowHeight = 44
        tableView.delegate = self
        tableView.dataSource = self
        tableView.separatorStyle = .none
        tableView.sectionFooterHeight = kMargin
        let nib = UINib(nibName: "YMsearchCell", bundle: nil)
        tableView.register(nib, forCellReuseIdentifier: searchContentCellID)
        view.addSubview(tableView)
        self.tableView = tableView
    }
    
    private lazy var searchBar: UISearchBar = {
        let searchBar = UISearchBar()
        searchBar.delegate = self
        searchBar.placeholder = "请输入关键字"
        return searchBar
    }()
    
    @objc func cancelBBItemClick() {
        searchBar.resignFirstResponder()
        weak var weakSelf = self
        dismiss(animated: false) {
            weakSelf!.delegate?.cancelButtonClickedPopViewcontroller()
        }
    }
}

extension YMSearchContentViewController: UISearchBarDelegate, UITableViewDelegate, UITableViewDataSource {
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: searchContentCellID) as! YMsearchCell
        cell.keyword = keywords[indexPath.row]
        return cell
    }
    
    
    // MARK: - UITableViewDataSource
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return keywords.count
    }
    
    private func tableView(tableView: UITableView, didSelectRowAt indexPath: NSIndexPath) {
        tableView.deselectRow(at: indexPath as IndexPath, animated: true)
        searchBar.resignFirstResponder()
        
    }
    
    // MARK: - UISearchBarDelegate
    func searchBar(_ searchBar: UISearchBar, textDidChange searchText: String) {
        let searchText = searchBar.text
        YMNetworkTool.shareNetworkTool.loadSearchResult(keyword: searchText!) { (keywords) in
            self.keywords = keywords
            self.tableView?.reloadData()
        }
    }
    
    func searchBarSearchButtonClicked(_ searchBar: UISearchBar) {
        let searchText = searchBar.text
        YMNetworkTool.shareNetworkTool.loadSearchResult(keyword: searchText!) { (keywords) in
            self.keywords = keywords
            self.tableView?.reloadData()
        }
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        searchBar.resignFirstResponder()
    }
}
