//
//  YMMineCellModel.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/17.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

class YMMineCellModel: NSObject {
    
    var title: String?
    var subtitle: String?
    var isHiddenLine: Bool?
    var isHiddenSubtitle: Bool?
    
    init(dict: [String: AnyObject]) {
        super.init()
        title = dict["title"] as? String
        subtitle = dict["subtitle"] as? String
        isHiddenLine = dict["isHiddenLine"] as? Bool
        isHiddenSubtitle = dict["isHiddenSubtitle"] as? Bool
    }
}
