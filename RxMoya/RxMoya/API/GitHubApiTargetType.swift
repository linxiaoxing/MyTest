//
//  GitHubApiTargetType.swift
//  RxMoya
//
//  Created by 林小興 on 2019/05/26.
//  Copyright © 2019 林小興. All rights reserved.
//

import Moya
import RxSwift

//extension String {
//    var urlEscaped: String {
//        return addingPercentEncoding(withAllowedCharacters: .urlHostAllowed)!
//    }
//}

class Api {
    static let shared = Api()
    private let provider = MoyaProvider<MultiTarget>()
    
    func request<R>(_ request: R) -> Single<R.Response> where R: GitHubApiTargetType {
        let target = MultiTarget(request)
        return provider.rx.request(target)
            .filterSuccessfulStatusCodes()
            .map(R.Response.self)
    }
}

// caseではなくstructでAPIを定義 新たににTargetTypeに準拠するGitHubApiTargetTypeというprotocolを定義します。baseURLなど各APIで共通の項目はextensionで定義しておきましょう。
protocol GitHubApiTargetType: TargetType {
    associatedtype Response: Codable
}

extension GitHubApiTargetType {
    var baseURL: URL { return URL(string: "https://api.github.com")! }
    var headers: [String : String]? { return nil }
    var sampleData: Data {
        let path = Bundle.main.path(forResource: "samples", ofType: "json")!
        return FileHandle(forReadingAtPath: path)!.readDataToEndOfFile()
    }
}

enum GitHub2 {
    struct GetUserProfile: GitHubApiTargetType {
        typealias Response = Profile
        
        var method: Moya.Method { return .get }
        var path: String { return "/users/\(name.urlEscaped)" }
        var task: Task { return .requestPlain }
        let name: String
        
        init(name: String) {
            self.name = name
        }
    }
}

