//
//  YMSettingViewController.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/18.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

let settingCellID = "settingCellID"

class YMSettingViewController: UITableViewController {
    
    var settings = [AnyObject]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        loadSettingFromPlist()
        
        setupUI()
    }
    
    private func setupUI() {
        view.backgroundColor = YMGlobalColor()
        let nib = UINib(nibName: "YMSettingCell", bundle: nil)
        tableView.register(nib, forCellReuseIdentifier: settingCellID)
        let footerView = UIView()
        tableView.tableFooterView = footerView
        tableView.rowHeight = 55
        tableView.separatorStyle = .none
    }
    
    // 从 plist 加载数据
    private func loadSettingFromPlist() {
        let path = Bundle.main.path(forResource: "YMSettingPlist", ofType: "plist")
        let cellPlist = NSArray.init(contentsOfFile: path!)
        for arrayDict in cellPlist! {
            let array = arrayDict as! NSArray
            var sections = [AnyObject]()
            for dict in array {
                let cell = YMSettingModel(dict: dict as! [String: AnyObject])
                sections.append(cell)
            }
            settings.append(sections as AnyObject)
        }
    }
}

extension YMSettingViewController {
    
    override func numberOfSections(in tableView: UITableView) -> Int {
        return settings.count ?? 0
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        let setting = settings[section] as! [YMSettingModel]
        return setting.count ?? 0
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: settingCellID) as! YMSettingCell
        let cellArray = settings[indexPath.section] as! [YMSettingModel]
        cell.setting = cellArray[indexPath.row]
        return cell
    }
    
    override func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return kMargin
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableView.deselectRow(at: indexPath, animated: true)
    }
}
