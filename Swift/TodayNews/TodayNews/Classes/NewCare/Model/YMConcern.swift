//
//  YMConcern.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/19.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

class YMConcern: NSObject {
    
    var sub_title: String?
    
    var newly: Int = 0
    
    var concern_time: Int = 0
    
    var managing: Int = 0
    
    var concern_count: Int = 0
    
    var concern_id: String?
    
    var new_thread_count: Int = 0
    
    var discuss_count: Int = 0
    
    var open_url: String?
    
    var name: String?
    
    var avatar_url: String?

    init(dict: [String: AnyObject]) {
        super.init()
        sub_title = dict["sub_title"] as? String
        newly = dict["newly"] as! Int
        concern_time = dict["concern_time"] as! Int
        managing = dict["managing"] as! Int
        concern_count = dict["concern_count"] as! Int
        concern_id = dict["concern_id"] as? String
        new_thread_count = dict["new_thread_count"] as! Int
        discuss_count = dict["discuss_count"] as! Int
        open_url = dict["open_url"] as? String
        name = dict["name"] as? String
        avatar_url = dict["avatar_url"] as? String
    }
}
