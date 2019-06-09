//
//  SQLiteManager.swift
//  MyTodayNews
//
//  Created by 林小興 on 2019/05/20.
//  Copyright © 2019 林小興. All rights reserved.
//

import Foundation
import SQLite

struct SQLiteManager {
    // 数据库链接
    var database: Connection!
    
    init() {
        do {
            let path = NSHomeDirectory() + "/Documents/news.sqlite3"
            database = try Connection(path)
        } catch { print(error) }
    }
}
