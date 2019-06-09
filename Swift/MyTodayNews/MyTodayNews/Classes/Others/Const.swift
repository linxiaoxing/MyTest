//
//  Const.swift
//  MyTodayNews
//
//  Created by 林小興 on 2019/05/21.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit
/// 屏幕的宽度
let screenWidth = UIScreen.main.bounds.width
/// 屏幕的高度
let screenHeight = UIScreen.main.bounds.height
/// emoji 宽度

let isNight = "isNight"
let newsTitleHeight: CGFloat = 40

/// 服务器地址
//let BASE_URL = "http://lf.snssdk.com"
//let BASE_URL = "http://ib.snssdk.com"
let BASE_URL = "https://is.snssdk.com"

let device_id: Int = 6096495334
let iid: Int = 5034850950

/// 动态图片的宽高
// 图片的宽高
// 1        screenWidth * 0.5
// 2        (screenWidth - 35) / 2
// 3,4,5-9    (screenWidth - 40) / 3
let image1Width: CGFloat = screenWidth * 0.5
let image2Width: CGFloat = (screenWidth - 35) * 0.5
let image3Width: CGFloat = (screenWidth - 40) / 3

let isIPhoneX: Bool = screenHeight == 812 ? true : false

/// 从哪里进入头条
enum TTFrom: String {
    case pull = "pull"
    case loadMore = "load_more"
    case auto = "auto"
    case enterAuto = "enter_auto"
    case preLoadMoreDraw = "pre_load_more_draw"
}
