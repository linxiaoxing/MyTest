//
//  GitHubApi.swift
//  RxMoya
//
//  Created by 林小興 on 2019/05/26.
//  Copyright © 2019 林小興. All rights reserved.
//

import Moya

extension String {
    var urlEscaped: String {
        return addingPercentEncoding(withAllowedCharacters: .urlHostAllowed)!
    }
}

enum GitHub {
    case userProfile(String)
}

extension GitHub: TargetType {
    
    var baseURL: URL { return URL(string: "https://api.github.com")! }
    
    var path: String {
        switch self {
        case .userProfile(let name):
            return "/users/\(name.urlEscaped)"
        }
    }
    
    var method: Moya.Method {
        return .get
    }
    
    var sampleData: Data {
        let path = Bundle.main.path(forResource: "samples", ofType: "json")!
        return FileHandle(forReadingAtPath: path)!.readDataToEndOfFile()
    }
    
    var task: Task {
        switch self {
        case .userProfile(_):
            return .requestPlain
        }
    }
    
    var headers: [String : String]? { return nil }
}
