//
//  YMNewCareViewController.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/16.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

//let newCareTopCellID = "YMNewCareNoLoginCell"
let newCareNoLoginCellID = "YMNewCareNoLoginCell"
let newCareTopCellID = "YMNewCareTopCell"
let newCareBottomCellID = "YMNewCareBottomCell"

class YMNewCareViewController: YMBaseViewController {
    
    var tableView: UITableView?
    
    var topConcerns = [YMConcern]()

    var bottomConcerns = [YMConcern]()
    
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
        YMNetworkTool.shareNetworkTool.loadNewConcernList(tableView: tableView!) { (topConcerns, bottomConcerns) in
            self.topConcerns = topConcerns
            self.bottomConcerns = bottomConcerns
            self.tableView!.reloadData()
        }
        
        YMNetworkTool.shareNetworkTool.loadMoreConcernList(tableView: tableView!, outOffset: offset) { (inOffset, topConcerns, bottomConcerns) in
            self.topConcerns += topConcerns
            self.bottomConcerns += bottomConcerns
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
        // 注册没有登录的 cell
        let noLoginNib = UINib(nibName: "YMNewCareNoLoginCell", bundle: nil)
        tableView.register(noLoginNib, forCellReuseIdentifier: newCareNoLoginCellID)
        // 注册顶部的 cell
        let topNib = UINib(nibName: "YMNewCareTopCell", bundle: nil)
        tableView.register(topNib, forCellReuseIdentifier: newCareTopCellID)
        // 注册底部的 cell
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
        let searchVC = YMNewCareSearchViewController()
        navigationController?.pushViewController(searchVC, animated: true)
    }
}

extension YMNewCareViewController: UITableViewDelegate, UITableViewDataSource, YMNewCareBottomCellDelegate {

    /*
     * セクションの数を指定します．
     */
    func numberOfSections(in tableView: UITableView) -> Int {
        return 2
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return section == 0 ? (topConcerns.count == 0 ? 1 : topConcerns.count) : bottomConcerns.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        if indexPath.section == 0 {
            if topConcerns.count == 0 {
                let cell = tableView.dequeueReusableCell(withIdentifier: newCareNoLoginCellID) as! YMNewCareNoLoginCell
                return cell
            } else {
                let cell = tableView.dequeueReusableCell(withIdentifier: newCareTopCellID) as! YMNewCareTopCell
                cell.concern = topConcerns[indexPath.row]
                return cell
            }
        } else {
            let cell = tableView.dequeueReusableCell(withIdentifier: newCareBottomCellID) as! YMNewCareBottomCell
            cell.concern = bottomConcerns[indexPath.row]
            cell.delegate = self
            return cell
        }
    }
    
    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        let headerView = YMCareheaderView()
        section == 0 ? (headerView.title = "正在关心") : (headerView.title = "可能关心")
        return headerView
    }
    
    func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return 28
    }
    
     func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath){
        tableView.deselectRow(at: indexPath as IndexPath, animated: true)
        
        if indexPath.section == 0 {
            if topConcerns.count != 0 {
                let concernDetailVC = YMConcernDetailController()
                navigationController?.pushViewController(concernDetailVC, animated: true)
                let cell = tableView.dequeueReusableCell(withIdentifier: newCareTopCellID) as! YMNewCareTopCell
                cell.newButton.isHidden = true
            } else {
                let concernDetailVC = YMConcernDetailController()
                navigationController?.pushViewController(concernDetailVC, animated: true)
            }
        }
    }
    
    // MARK: - YMNewCareBottomCellDelegate
    func bottomCell(_ bottomCell: YMNewCareBottomCell, careButton: UIButton) {
        let concern = bottomCell.concern
        YMNetworkTool.shareNetworkTool.bottomCellDidClickedCareButton(concernID: concern!.concern_id!, tableView: tableView!) { (topConcerns, bottomConcerns) in
            self.topConcerns = topConcerns
            self.bottomConcerns = bottomConcerns
            self.tableView!.reloadData()
        }
    }
}
