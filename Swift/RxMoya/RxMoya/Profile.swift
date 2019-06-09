//
//  Profile.swift
//  RxMoya
//
//  Created by 林小興 on 2019/05/26.
//  Copyright © 2019 林小興. All rights reserved.
//

import Foundation

struct Profile: Codable {
    let login: String
    let url: URL
    let name: String?
    let email: String?
}
