//
//  YMMineViewController.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/16.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

let mineCellID = "YMMineCell"

class YMMineViewController: UITableViewController {
    
    var cells = [AnyObject]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // 从 plist 加载数据
        loadCellFromPlist()
        // 设置 UI
        setupUI()
        
    }
    
    override func viewWillAppear(_ animated: Bool) {
        navigationController?.setNavigationBarHidden(true, animated: false)
    }
    
    private func setupUI() {
        view.backgroundColor = YMGlobalColor()
        let nib = UINib(nibName: "YMMineCell", bundle: nil)
        tableView.register(nib, forCellReuseIdentifier: mineCellID)
        //tableView.tableHeaderView = headerView
        let footerView = UIView()
        footerView.height = kMargin
        tableView.tableFooterView = footerView
        tableView.rowHeight = kMineCellH
        tableView.separatorStyle = .none
        
        if UserDefaults.standard.bool(forKey: isLogin) {
            tableView.tableHeaderView = headerView
        } else {
            tableView.tableHeaderView = noLoginHeaderView
        }
    }
    
    /// 懒加载，创建 未登录 headerView
    private lazy var noLoginHeaderView: YMMineNoLoginHeaderView = {
        let noLoginHeaderView = YMMineNoLoginHeaderView.noLoginHeaderView()
        noLoginHeaderView.frame = CGRect(x: 0, y: 20, width: SCREENW, height: 278)
        return noLoginHeaderView
    }()
    /// 懒加载，创建 headerView
    private lazy var headerView: YMMineHeaderView = {
        let headerView = YMMineHeaderView.headerView()
        headerView.delegate = self
        headerView.bottomView.delegate = self
        return headerView
    }()
}

extension YMMineViewController {
    
    // 从 plist 加载数据
    private func loadCellFromPlist() {
        let path = Bundle.main.path(forResource: "YMMineCellPlist", ofType: "plist")
        guard let file = path else {
            return
        }
        let cellPlist = NSArray.init(contentsOfFile: file)
        guard let plist = cellPlist else {
            return
        }
        for arrayDict in plist {
            let array = arrayDict as! NSArray
            var sections = [AnyObject]()
            for dict in array {
                let cell = YMMineCellModel(dict: dict as! [String: AnyObject])
                sections.append(cell)
            }
            cells.append(sections as AnyObject)
        }
  
    }
}

extension YMMineViewController: YMMineHeaderViewDelegae, YMMineHeaderBottomViewDelegate {
    
    func headerView(_ headerView: YMMineHeaderView, headPhotoBbutton: YMMineHeaderIconButton) {
        print(#function)
    }
    
    func headerBottomView(_ bottomView: YMMineHeaderBottomView, collectionButton: YMVerticalButton) {
        print(#function)
        let collectionVC = YMCollectionViewController()
        collectionVC.title = "收藏"
        navigationController?.pushViewController(collectionVC, animated: true)
    }
    
    func headerBottomView(_ bottomView: YMMineHeaderBottomView, nightButton: YMVerticalButton) {
        print(#function)
    }
    
    func headerBottomView(_ bottomView: YMMineHeaderBottomView, settingButton: YMVerticalButton) {
        let settingVC = YMSettingViewController()
        settingVC.title = "设置"
        navigationController?.pushViewController(settingVC, animated: true)
    }
    
    // MARK: - UITableViewDataSource
    override func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return kMargin
    }
    
    override func numberOfSections(in tableView: UITableView) -> Int {
        return cells.count ?? 0
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        let cellAyyay = cells[section] as! [YMMineCellModel]
        return cellAyyay.count ?? 0
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: mineCellID) as! YMMineCell
        let cellArray = cells[indexPath.section] as! [YMMineCellModel]
        cell.cellModel = cellArray[indexPath.row]
        return cell
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableView.deselectRow(at: indexPath, animated: true)
    }
    
    override func scrollViewDidScroll(_ scrollView: UIScrollView) {
        let offsetY = scrollView.contentOffset.y
        if offsetY < 0 {
            var tempFrame = headerView.bgImageView.frame
            tempFrame.origin.y = offsetY
            tempFrame.size.height = kYMMineHeaderImageHeight - offsetY
            headerView.bgImageView.frame = tempFrame
        }
    }
}
