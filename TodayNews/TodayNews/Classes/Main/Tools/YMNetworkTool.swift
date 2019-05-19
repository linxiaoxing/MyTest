//
//  YMNetworkTool.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/19.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit
import Alamofire
import SVProgressHUD
import SwiftyJSON
import MJRefresh

class YMNetworkTool: NSObject {
    
    /// 单例
    static let shareNetworkTool = YMNetworkTool()
    
    /// 关心
    /// 获取新的 关心数据列表
    func loadNewConcernList(tableView: UITableView, finished:@escaping (_ topConcerns: [YMConcern], _ bottomConcerns: [YMConcern]) -> ()) {
        
        let url = "http://lf.snssdk.com/concern/v1/concern/list/"
        let params = ["iid": IID,
                      "count": 20,
                      "offset": 0,
                      "type": "manage"] as [String : Any]
        tableView.mj_header = MJRefreshNormalHeader(refreshingBlock: {
            Alamofire
                .request(url, method: .post, parameters: params)
                .responseJSON { (response) in
                    tableView.mj_header.endRefreshing()
                    guard response.result.isSuccess else {
                        SVProgressHUD.showError(withStatus: "加载失败...")
                        return
                    }
                    if let value = response.result.value {
                        let json = JSON(value)
                        if let concern_list = json["concern_list"].arrayObject {
                            var topConcerns = [YMConcern]()
                            var bottomConcerns = [YMConcern]()
                            for dict in concern_list {
                                let concern = YMConcern(dict: dict as! [String: AnyObject])
                                if concern.newly == 1 {
                                    topConcerns.append(concern)
                                } else {
                                    bottomConcerns.append(concern)
                                }
                            }
                            finished(topConcerns, bottomConcerns)
                        }
                    }
            }
        })
        tableView.mj_header.isAutomaticallyChangeAlpha = true //根据拖拽比例自动切换透明度
        tableView.mj_header.beginRefreshing()
    }
    
    /// 获取更多 关心数据列表
    func loadMoreConcernList(tableView: UITableView, outOffset: Int, finished:@escaping (_ inOffset: Int, _ topConcerns: [YMConcern], _ bottomConcerns: [YMConcern]) -> ()) {
        let url = "http://lf.snssdk.com/concern/v1/concern/list/"
        let params = ["iid": IID,
                      "count": 20,
                      "offset": outOffset,
                      "type": "recommend"] as [String : Any]
        tableView.mj_footer = MJRefreshAutoNormalFooter(refreshingBlock: {
            Alamofire
                .request(url, method: .post, parameters: params as? [String : AnyObject])
                .responseJSON { (response) in
                    tableView.mj_footer.endRefreshing()
                    guard response.result.isSuccess else {
                        SVProgressHUD.showError(withStatus: "加载失败...")
                        return
                    }
                    if let value = response.result.value {
                        let json = JSON(value)
                        let inOffset = json["offset"].int!
                        print(inOffset)
                        if let concern_list = json["concern_list"].arrayObject {
                            var topConcerns = [YMConcern]()
                            var bottomConcerns = [YMConcern]()
                            for dict in concern_list {
                                let concern = YMConcern(dict: dict as! [String: AnyObject])
                                if concern.newly == 1 {
                                    topConcerns.append(concern)
                                } else {
                                    bottomConcerns.append(concern)
                                }
                            }
                            finished(inOffset, topConcerns, bottomConcerns)
                        }
                    }
            }
        })
    }
    
     /// 关心界面 -> 搜索关心类别和内容
    func loadSearchResult(keyword: String, finished: @escaping(_ keywords: [YMKeyword]) -> ()) {
        let url = BASE_URL + "2/article/search_sug/?keyword=\(keyword)"
        Alamofire
            .request(url, method: .get)
            .responseJSON { (response) in
                guard response.result.isSuccess else {
                    SVProgressHUD.showError(withStatus: "加载失败...")
                    return
                }
                if let value = response.result.value {
                    let json = JSON(value)
                    if let datas = json["data"].arrayObject {
                        var keywords = [YMKeyword]()
                        for data in datas {
                            let keyword = YMKeyword(dict: data  as! [String: AnyObject])
                            keywords.append(keyword)
                        }
                        finished(keywords)
                    }
                }
        }
    }
    
    /// 关心界面 -> 底部 cell 的『关心』按钮 点击
    func bottomCellDidClickedCareButton(concernID: String, tableView: UITableView, finish:@escaping (_ topConcerns: [YMConcern], _ bottomConcerns: [YMConcern])->()) {
        let url = BASE_URL + "concern/v1/commit/care/"
        let params = ["iid": IID, "concern_id": concernID] as [String : Any]
        Alamofire
            .request(url, method:.post, parameters: params as? [String : AnyObject])
            .responseJSON { (response) in
                guard response.result.isSuccess else {
                    SVProgressHUD.showError(withStatus: "加载失败...")
                    return
                }
                YMNetworkTool.shareNetworkTool.loadNewConcernList(tableView: tableView, finished: { (topConcerns, bottomConcerns) in
                    finish(topConcerns, bottomConcerns)
                })
        }
    }
    
    /// 首页
    /// 获取首页顶部标题内容
    func loadHomeTitlesData(finished:@escaping(_ topTitles: [YMVideoTopTitle])->()) {
        let url = BASE_URL + "article/category/get_subscribed/v1/?iid=\(IID)"
        Alamofire
            .request(url, method: .get)
            .responseJSON { (response) in
                guard response.result.isSuccess else {
                    SVProgressHUD.showError(withStatus: "加载失败...")
                    return
                }
                if let value = response.result.value {
                    let json = JSON(value)
                    let dataDict = json["data"].dictionary
                    if let data = dataDict!["data"]!.arrayObject {
                        var titles = [YMVideoTopTitle]()
                        for dict in data {
                            let title = YMVideoTopTitle(dict: dict as! [String: AnyObject])
                            titles.append(title)
                            print(title.name)
                        }
                        finished(titles)
                    }
                }
        }
    }
    
    /// 视频
    /// 获取视频顶部标题内容
    func loadVideoTitlesData(finished: @escaping([YMVideoTopTitle]) -> ()) {
         let url = BASE_URL + "video_api/get_category/v1/"
        Alamofire
            .request(url, method: .get)
            .responseJSON { (response) in
                guard response.result.isSuccess else {
                    SVProgressHUD.showError(withStatus: "加载失败...")
                    return
                }
                if let value = response.result.value {
                    let json = JSON(value)
                    if let data = json["data"].arrayObject {
                        var titles = [YMVideoTopTitle]()
                        for dict in data {
                            let title = YMVideoTopTitle(dict: dict as! [String: AnyObject])
                        }
                        finished(topTitles: titles)
                    }
                }
        }
    }
}
