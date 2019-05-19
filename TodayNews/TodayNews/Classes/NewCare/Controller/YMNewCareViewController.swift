//
//  YMNewCareViewController.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/16.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

let newCareTopCellID = "YMNewCareNoLoginCell"
let newCareBottomCellID = "YMNewCareBottomCell"

class YMNewCareViewController: YMBaseViewController {
    
    var tableView: UITableView?
    
    var concerns = [YMConcern]()
    
    var offset: Int = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // 设置 UI
        setupUI()
        
        // 上拉和下拉加载数据
        setupRefresh()
    }
    
    /// 上拉和下拉加载数据
    private func setupRefresh() {
        YMNetworkTool.shareNetworkTool.loadNewConcernList(tableView: tableView!) { (concerns) in
            self.concerns = concerns
            self.tableView!.reloadData()
        }
        
        YMNetworkTool.shareNetworkTool.loadMoreConcernList(tableView: tableView!, outOffset: offset) { (inOffset, concerns) in
            self.concerns += concerns
            self.offset = inOffset
            self.tableView!.reloadData()
        }
    }
    
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
 
}

extension YMNewCareViewController {
    
    // 设置 UI
    private func setupUI() {
        navigationItem.rightBarButtonItem = UIBarButtonItem(image: UIImage(named: "search_topic_24x24_"), style: .plain, target: self, action: #selector(searchBBItemClick))
        let tableView = UITableView(frame: view.bounds, style: .grouped)
        let topNib = UINib(nibName: "YMNewCareNoLoginCell", bundle: nil)
        tableView.register(topNib, forCellReuseIdentifier: newCareTopCellID)
        let bottomNib = UINib(nibName: "YMNewCareBottomCell", bundle: nil)
        tableView.register(bottomNib, forCellReuseIdentifier: newCareBottomCellID)
        tableView.tableFooterView = UIView()
        tableView.rowHeight = 67
        tableView.delegate = self
        tableView.dataSource = self
        tableView.separatorStyle = .none
        tableView.contentInset = UIEdgeInsets(top: -35, left: 0, bottom: 0, right: 0)
        tableView.sectionFooterHeight = kMargin
        view.addSubview(tableView)
        self.tableView = tableView
    }
    
    @objc func searchBBItemClick() {
        let searchVC = YMNewCareSearchController()
        navigationController?.pushViewController(searchVC, animated: true)
    }
}

extension YMNewCareViewController: UITableViewDelegate, UITableViewDataSource {

    /*
     * セクションの数を指定します．
     */
    func numberOfSections(in tableView: UITableView) -> Int {
        return 2
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        if section == 0 {
            return 1
        } else {
            return concerns.count ?? 0
        }
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        if indexPath.section == 0 {
            let cell = tableView.dequeueReusableCell(withIdentifier: newCareTopCellID) as! YMNewCareNoLoginCell
            return cell
        } else {
            let cell = tableView.dequeueReusableCell(withIdentifier: newCareBottomCellID) as! YMNewCareBottomCell
            cell.concern = concerns[indexPath.row]
            return cell
        }
    }
    
    func tableView(tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        let headerView = YMCareheaderView()
        if section == 0 {
            headerView.title = "正在关心"
            return headerView
        } else {
            headerView.title = "可能关心"
            return headerView
        }
    }
    
    func tableView(tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return 28
    }
    
    func tableView(tableView: UITableView, didSelectRowAtIndexPath indexPath: NSIndexPath) {
        tableView.deselectRow(at: indexPath as IndexPath, animated: true)
    }
}
