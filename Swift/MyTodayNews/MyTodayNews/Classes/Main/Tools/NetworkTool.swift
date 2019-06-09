//
//  NetworkTool.swift
//  MyTodayNews
//
//  Created by 林小興 on 2019/05/20.
//  Copyright © 2019 林小興. All rights reserved.
//

import Foundation
import Alamofire
import SwiftyJSON

protocol NetworkToolProtocol {
    
    // MARK: - --------------------------------- 首页 home  ---------------------------------
    // MARK: 首页顶部新闻标题的数据
//    static func loadHomeNewsTitleData(completionHandler: @escaping(_ newsTitles: [HomeNewsTitle]) -> ())
//    
//    // MARK: 点击首页加号按钮，获取频道推荐数据
//    static func loadHomeCategoryRecommend(completionHandler:@escaping (_ titles: [HomeNewsTitle]) -> ())
//    // MARK: 首页顶部导航栏搜索推荐标题内容
//    static func loadHomeSearchSuggestInfo(_ completionHandler: @escaping (_ searchSuggest: String) -> ())
    // MARK: 获取首页、视频、小视频的新闻列表数据
    static func loadApiNewsFeeds(category: NewsTitleCategory, ttFrom: TTFrom, _ completionHandler: @escaping (_ maxBehotTime: TimeInterval, _ news: [NewsModel]) -> ())
    // MARK: 获取首页、视频、小视频的新闻列表数据,加载更多
    static func loadMoreApiNewsFeeds(category: NewsTitleCategory, ttFrom: TTFrom, maxBehotTime: TimeInterval, listCount: Int, _ completionHandler: @escaping (_ news: [NewsModel]) -> ())
//    // MARK: 获取一般新闻详情数据
//    static func loadCommenNewsDetail(articleURL: String, completionHandler:@escaping (_ htmlString: String, _ images: [NewsDetailImage], _ abstracts: [String])->())
//    // MARK: 获取图片新闻详情数据
//    static func loadNewsDetail(articleURL: String, completionHandler:@escaping (_ images: [NewsDetailImage], _ abstracts: [String])->())
//    
    // MARK: - --------------------------------- 视频 video  ---------------------------------
    // MARK: 视频顶部新闻标题的数据
    static func loadVideoApiCategoies(completionHandler: @escaping (_ newsTitles: [HomeNewsTitle]) -> ())
    // MARK: 解析头条的视频真实播放地址
    static func parseVideoRealURL(video_id: String, completionHandler: @escaping (_ realVideo: RealVideo) -> ())
    // MARK: 视频详情数据
    static func loadArticleInformation(from: String, itemId: Int, groupId: Int, completionHandler: @escaping (_ videoDetail: VideoDetail) -> ())
    
//    // MARK: - --------------------------------- 我的 mine  ---------------------------------
//    // MARK: 我的界面 cell 的数据
//    static func loadMyCellData(completionHandler: @escaping (_ sections: [[MyCellModel]]) -> ())
//    // MARK: 我的关注数据
//    static func loadMyConcern(completionHandler: @escaping (_ concerns: [MyConcern]) -> ())
//    // MARK: 获取用户详情数据
//    static func loadUserDetail(userId: Int, completionHandler: @escaping (_ userDetail: UserDetail) -> ())
    // MARK: 已关注用户，取消关注
    static func loadRelationUnfollow(userId: Int, completionHandler: @escaping (_ user: ConcernUser) -> ())
    // MARK: 点击关注按钮，关注用户
    static func loadRelationFollow(userId: Int, completionHandler: @escaping (_ user: ConcernUser) -> ())
//    // MARK: 点击了关注按钮，就会出现相关推荐数据
//    static func loadRelationUserRecommend(userId: Int, completionHandler: @escaping (_ concerns: [UserCard]) -> ())
//    // MARK: 获取用户详情的动态列表数据
//    static func loadUserDetailDongtaiList(userId: Int, maxCursor: Int, completionHandler: @escaping (_ cursor: Int,_ dongtais: [UserDetailDongtai]) -> ())
//    // MARK: 获取用户详情的文章列表数据
//    static func loadUserDetailArticleList(userId: Int, completionHandler: @escaping (_ dongtais: [UserDetailDongtai]) -> ())
//    // MARK: 获取用户详情的问答列表数据
//    static func loadUserDetailWendaList(userId: Int, cursor: String, completionHandler: @escaping (_ cursor: String,_ wendas: [UserDetailWenda]) -> ())
//    // MARK: 获取用户详情的动态详细内容 **暂未使用本方法**
//    static func loadUserDetailDongTaiDetailContent(threadId: String, completionHandler: @escaping (_ detailContent: UserDetailDongtai) -> ())
//    // MARK: 获取用户详情的动态转发或引用内容 **暂未使用本方法**
//    static func loadUserDetailDongTaiDetailCommentOrQuote(commentId: Int, completionHandler: @escaping (_ detailComment: UserDetailDongtai) -> ())
    // MARK: 获取用户详情一般的详情的评论数据
    static func loadUserDetailNormalDongtaiComents(groupId: Int, offset: Int, count: Int, completionHandler: @escaping (_ comments: [DongtaiComment]) -> ())
//    // MARK: 获取用户详情其他类型的详情的评论数据
//    static func loadUserDetailQuoteDongtaiComents(id: Int, offset: Int, completionHandler: @escaping (_ comments: [DongtaiComment]) -> ())
//    // MARK: 获取动态详情的用户点赞列表数据
//    static func loadDongtaiDetailUserDiggList(id: Int, offset: Int, completionHandler: @escaping (_ comments: [DongtaiUserDigg]) -> ())
//    // MARK: 获取问答的列表数据（提出了问题）
//    static func loadProposeQuestionBrow(qid: Int, enterForm: WendaEnterFrom, completionHandler: @escaping (_ wenda: Wenda) -> ())
//    // MARK: 获取问答的列表数据（提出了问题），加载更多
//    static func loadMoreProposeQuestionBrow(qid: Int, offset: Int, enterForm: WendaEnterFrom, completionHandler: @escaping (_ wenda: Wenda) -> ())
//    
//    // MARK: - --------------------------------- 小视频  ---------------------------------
//    // MARK: 小视频导航栏标题的数据
//    static func loadSmallVideoCategories(completionHandler: @escaping (_ newsTitles: [HomeNewsTitle]) -> ())
//    // MARK: - --------------------------------- 新年活动 ---------------------------------
//    // MARK: 获取新年活动数据
//    static func loadNewYearActivities(completionHandler: @escaping (_ newYear: NewYear) -> ())
//    // MARK: 增加抽卡次数
//    static func loadFestivalActivityTasks(completionHandler: @escaping (_ tasks: [NewYearTask]) -> ())
}

extension NetworkToolProtocol {
    
    // MARK: - --------------------------------- 视频 video  ---------------------------------
    /// 视频顶部新闻标题的数据
    /// - parameter completionHandler: 返回标题数据
    /// - parameter newsTitles: 视频标题数组
    static func loadVideoApiCategoies(completionHandler: @escaping(_ newsTitles: [HomeNewsTitle])->()) {
        let url = BASE_URL + "/video_api/get_category/v1/?"
        let params = ["device_id": device_id,
                      "iid": iid]
        Alamofire.request(url, parameters: params).responseJSON { (response) in
            guard response.result.isSuccess else { return }
            if let value = response.result.value {
                let json = JSON(value)
                guard json["message"] == "success" else { return }
                if let datas = json["data"].arrayObject {
                    var titles = [HomeNewsTitle]()
                    titles.append(HomeNewsTitle.deserialize(from: "{\"category\": \"video\", \"name\": \"推荐\"}")!)
                    titles += datas.compactMap({ HomeNewsTitle.deserialize(from: $0 as? Dictionary) })
                    completionHandler(titles)
                }
            }
        }
    }
    
    /// 获取首页、视频、小视频的新闻列表数据
    /// - parameter category: 新闻类别
    /// - parameter ttFrom: 那个界面
    /// - parameter completionHandler: 返回新闻列表数据
    /// - parameter news: 首页新闻数据数组
    static func loadApiNewsFeeds(category: NewsTitleCategory, ttFrom: TTFrom, _
        completionHandler: @escaping (_ maxBehotTime: TimeInterval, _ news: [NewsModel]) -> ()) {
        // 下拉刷新的时间
        let pullTime = Date().timeIntervalSince1970
        let url = BASE_URL
            + "/api/news/feed/v75/?"
        let params = ["device_id": device_id,
                      "count": 20,
                      "list_count": 15,
                      "category": category.rawValue,
                      "min_behot_time": pullTime,
                      "strict": 0,
                      "detail": 1,
                      "refresh_reason": 1,
                      "tt_from": ttFrom,
                      "iid": iid] as [String: Any]
        Alamofire.request(url, parameters: params).responseJSON { (response) in
            // 网络错误的提示信息
            guard response.result.isSuccess else { return }
            if let value = response.result.value {
                let json = JSON(value)
                guard json["message"] == "success" else { return }
                guard let datas = json["data"].array else { return }
                completionHandler(pullTime, datas.compactMap({ NewsModel.deserialize(from: $0["content"].string) }))
            }
        }
    }
    
    /// 获取首页、视频、小视频的新闻列表数据,加载更多
    /// - parameter category: 新闻类别
    /// - parameter ttFrom: 那个界面
    /// - parameter listCount: 数据数量
    /// - parameter completionHandler: 返回新闻列表数据
    /// - parameter news: 首页新闻数据数组
    static func loadMoreApiNewsFeeds(category: NewsTitleCategory, ttFrom: TTFrom, maxBehotTime: TimeInterval, listCount: Int, _ completionHandler: @escaping (_ news: [NewsModel]) -> ()) {
        let url = BASE_URL + "/api/news/feed/v75/?"
        let params = ["device_id": device_id,
                      "count": 20,
                      "list_count": listCount,
                      "category": category.rawValue,
                      "max_behot_time": maxBehotTime,
                      "strict": 0,
                      "detail": 1,
                      "refresh_reason": 1,
                      "tt_from": ttFrom,
                      "iid": iid] as [String: Any]
        Alamofire.request(url, parameters: params).responseJSON { (response) in
            // 网络错误的提示信息
            guard response.result.isSuccess else { return }
            if let value = response.result.value {
                let json = JSON(value)
                guard json["message"] == "success" else { return }
                guard let datas = json["data"].array else { return }
                completionHandler(datas.compactMap({ NewsModel.deserialize(from: $0["content"].string) }))
            }
        }
    }
    
    /// - [可参考这篇博客](http://blog.csdn.net/dianliang01/article/details/73163086)
    /// - parameter video_id: 视频 id
    /// - parameter completionHandler: 返回视频真实播放地址
    /// - parameter newsTitles: 视频真实播放地址
    static func parseVideoRealURL(video_id: String, completionHandler: @escaping(_ realVidel: RealVideo) -> ()) {
        
        let r = arc4random() // 随机数
        let url: NSString = "/video/urls/v/1/toutiao/mp4/\(video_id)?r=\(r)" as NSString
        let data: NSData = url.data(using: String.Encoding.utf8.rawValue)! as NSData
        // 使用 crc32 校验
        var crc32: UInt64 = UInt64(data.getCRC32())
        // crc32 可能为负数，要保证其为正数
        if crc32 < 0 { crc32 += 0x100000000 }
        // 拼接 url
        let realURL = "http://i.snssdk.com/video/urls/v/1/toutiao/mp4/\(video_id)?r=\(r)&s=\(crc32)"
        
        Alamofire.request(realURL).responseJSON { (response) in
            // 网络错误的提示信息
            guard response.result.isSuccess else { return }
            if let value = response.result.value {
                 completionHandler(RealVideo.deserialize(from: JSON(value)["data"].dictionaryObject)!)
            }
        }
    }
    
    /// 已关注用户，取消关注
    /// - parameter userId: 用户id
    /// - parameter completionHandler: 返回用户
    /// - parameter user:  用户信息（暂时不用）
    static func loadRelationUnfollow(userId: Int, completionHandler: @escaping(_ user: ConcernUser) -> ()) {
        let url = BASE_URL + "/2/relation/unfollow/?"
        let params = ["user_id": userId,
                      "device_id": device_id,
                      "iid": iid]
        Alamofire.request(url, parameters: params).responseJSON { (response) in
            // 网络错误的提示信息
            guard response.result.isSuccess else { return }
            if let value = response.result.value {
                let json = JSON(value)
                guard json["message"] == "success" else { return }
                if let data = json["data"].dictionaryObject {
                    completionHandler(ConcernUser.deserialize(from: data["user"] as? Dictionary)!)
                }
            }
        }
    }
    
    /// 点击关注按钮，关注用户
    /// - parameter userId: 用户id
    /// - parameter completionHandler: 返回用户
    /// - parameter user:  用户信息（暂时不用）
    static func loadRelationFollow(userId: Int, completionHandler: @escaping (_ user: ConcernUser) -> ()) {
        
        let url = BASE_URL + "/2/relation/follow/v2/?"
        let params = ["user_id": userId,
                      "device_id": device_id,
                      "iid": iid]
        
        Alamofire.request(url, parameters: params).responseJSON { (response) in
            // 网络错误的提示信息
            guard response.result.isSuccess else { return }
            if let value = response.result.value {
                let json = JSON(value)
                guard json["message"] == "success" else { return }
                if let data = json["data"].dictionaryObject {
                    completionHandler(ConcernUser.deserialize(from: data["user"] as? Dictionary)!)
                }
            }
        }
    }
    
    /// 视频详情数据
    /// - parameter from: 来源（click_video）
    /// - parameter itemId: item_id
    /// - parameter groupId: group_id
    /// - parameter completionHandler: 返回视频详情数据
    /// - parameter videoDetail: 视频详情数据
    static func loadArticleInformation(from: String, itemId: Int, groupId: Int, completionHandler: @escaping (_ videoDetail: VideoDetail) -> ()) {
        let url = BASE_URL + "/2/article/information/v23/?"
        let params = ["device_id": device_id,
                      "iid": iid,
                      "app_name": "news_article",
                      "version_code": "6.5.5",
                      "device_platform": "iphone",
                      "flags": 64,
                      "aid": 13,
                      "aggr_type": 1,
                      "article_page": 1,
                      "from": from,
                      "item_id": itemId,
                      "group_id": groupId] as [String : Any]
        Alamofire.request(url, parameters: params).responseJSON { (response) in
            // 网络错误的提示信息
            guard response.result.isSuccess else { return }
            if let value = response.result.value {
                let json = JSON(value)
                guard json["message"] == "success" else { return }
                completionHandler(VideoDetail.deserialize(from: json["data"].dictionaryObject)!)
            }
        }
    }

    /// 获取用户详情一般的详情的评论数据
    /// item_type: postContent(200),postVideo(150),postVideoOrArticle(151)
    /// - parameter forumId: 用户id
    /// - parameter groupId: thread_id
    /// - parameter offset: 偏移
    /// - parameter completionHandler: 返回评论数据
    /// - parameter comments: 评论数据
    static func loadUserDetailNormalDongtaiComents(groupId: Int, offset: Int, count: Int, completionHandler: @escaping (_ comments: [DongtaiComment]) -> ()) {
        
        let url = BASE_URL + "/article/v2/tab_comments/"
        let params = ["forum_id": "",
                      "group_id": groupId,
                      "count": count,
                      "offset": offset,
                      "device_id": device_id,
                      "iid": iid] as [String : Any]
        
        Alamofire.request(url, method: .post, parameters: params).responseJSON { (response) in
            // 网络错误的提示信息
            guard response.result.isSuccess else { completionHandler([]); return }
            if let value = response.result.value {
                let json = JSON(value)
                guard json["message"] == "success" else { completionHandler([]); return }
                if let datas = json["data"].arrayObject {
                    completionHandler(datas.compactMap({
                        return DongtaiComment.deserialize(from: ($0 as! [String: Any])["comment"] as? Dictionary)
                    }))
                }
            }
        }
    }
}

struct NetworkTool: NetworkToolProtocol {
}
