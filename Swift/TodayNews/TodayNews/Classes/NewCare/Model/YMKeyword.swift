//
//  YMKeyword.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/19.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

class YMKeyword: NSObject {
    var keyword: String?
    
    init(dict: [String: AnyObject]) {
        super.init()
        keyword = dict["keyword"] as? String
    }
}
