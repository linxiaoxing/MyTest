//
//  YMConst.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/17.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

enum YMTopicType: Int {
    /// 精选
    case Selection = 4
    /// 美食
    case Food = 14
    /// 家居
    case Household = 16
    /// 数码
    case Digital = 17
    /// 美物
    case GoodThing = 13
    /// 杂货
    case Grocery = 22
}


enum YMShareButtonType: Int {
    /// 微信朋友圈
    case WeChatTimeline = 0
    /// 微信好友
    case WeChatSession = 1
    /// 微博
    case Weibo = 2
    /// QQ 空间
    case QZone = 3
    /// QQ 好友
    case QQFriends = 4
    /// 复制链接
    case CopyLink = 5
}

enum YMOtherLoginButtonType: Int {
    /// 微博
    case weiboLogin = 100
    /// 微信
    case weChatLogin = 101
    /// QQ
    case QQLogin = 102
}

/// 服务器地址
let BASE_URL = "https://www.toutiao.com/"

/// 第一次启动
let YMFirstLaunch = "firstLaunch"
/// 是否登录
let isLogin = "isLogin"

/// code 码 200 操作成功
let RETURN_OK = 200
/// 间距
let kMargin: CGFloat = 10.0
/// 圆角
let kCornerRadius: CGFloat = 5.0
/// 线宽
let klineWidth: CGFloat = 1.0
/// 首页顶部标签指示条的高度
let kIndicatorViewH: CGFloat = 2.0
/// 新特性界面图片数量
let kNewFeatureCount = 4
/// 顶部标题的高度
let kTitlesViewH: CGFloat = 35
/// 顶部标题的y
let kTitlesViewY: CGFloat = 64
/// 动画时长
let kAnimationDuration = 0.25
/// 屏幕的宽
let SCREENW = UIScreen.main.bounds.size.width
/// 屏幕的高
let SCREENH = UIScreen.main.bounds.size.height
/// 我的界面头部图像的高度
let kYMMineHeaderImageHeight: CGFloat = 210
//  个人界面 cell 高度
let kMineCellH: CGFloat = 50

/// RGBA的颜色设置
func YMColor(_ r: CGFloat, g: CGFloat, b: CGFloat, a: CGFloat) -> UIColor {
    return UIColor(red: r / 255.0, green: g / 255.0, blue: b / 255.0, alpha: a)
}

/// 背景灰色
func YMGlobalColor() -> UIColor {
    return YMColor(242, g: 247, b: 248, a: 1)
}


/// 红色
func YMGlobalRedColor() -> UIColor {
    return YMColor(245, g: 80, b: 83, a: 1.0)
}

/// iPhone 5
let isIPhone5 = SCREENH == 568 ? true : false
/// iPhone 6
let isIPhone6 = SCREENH == 667 ? true : false
/// iPhone 6P
let isIPhone6P = SCREENH == 736 ? true : false

/// iid 未登录用户 id，我觉得只要安装了今日头条就会生成一个 iid
/// 可以在自己的手机上安装一个今日头条，然后通过 charles 抓取一下这个 iid，
/// 替换成自己的，再进行测试
let IID = 5034850950
