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
    func loadNewConcernList(tableView: UITableView, finished:@escaping (_ concerns: [YMConcern]) -> ()) {
        
        let url = "http://lf.snssdk.com/concern/v1/concern/list/"
        let params = ["iid": 5034850950,
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
                            var concerns = [YMConcern]()
                            for dict in concern_list {
                                let concern = YMConcern(dict: dict as! [String: AnyObject])
                                concerns.append(concern)
                            }
                            finished(concerns)
                        }
                    }
            }
        })
        tableView.mj_header.isAutomaticallyChangeAlpha = true //根据拖拽比例自动切换透明度
        tableView.mj_header.beginRefreshing()
    }
    
    /// 获取更多 关心数据列表
    func loadMoreConcernList(tableView: UITableView, outOffset: Int, finished:@escaping (_ inOffset: Int, _ concerns: [YMConcern]) -> ()) {
        let url = "http://lf.snssdk.com/concern/v1/concern/list/"
        let params = ["iid": 5034850950,
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
                            var concerns = [YMConcern]()
                            for dict in concern_list {
                                let concern = YMConcern(dict: dict as! [String: AnyObject])
                                concerns.append(concern)
                            }
                            finished(inOffset, concerns)
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
}
