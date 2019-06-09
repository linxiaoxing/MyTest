//
//  ViewController.swift
//  RxMoya
//
//  Created by 林小興 on 2019/05/26.
//  Copyright © 2019 林小興. All rights reserved.
//

import Foundation
import UIKit
import RxSwift
import RxCocoa
import Moya
import RxMoya
import ObjectMapper

class ViewController: UIViewController {

    //显示频道列表的tableView
    var tableView: UITableView!
    
    let disposeBag = DisposeBag()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // 获取数据douban
        getDouBan()
        
        // 获取数据gitHub
        getGitHub()
        
        toTableView()
        
        // toMapObject()
    }
    
    private func getDouBan() {
        DouBanProvider.rx.request(.channels)
            .subscribe(onSuccess: { response in
                //数据处理
                let str = String(data: response.data, encoding: String.Encoding.utf8)
                let json = try? response.mapJSON() as! [String: Any]
                print("返回的数据是：", str ?? "")
                print("返回的数据JSON是：", json ?? "")
            },onError: { error in
                print("数据请求失败!错误原因：", error)
            }).disposed(by: disposeBag)
    }
    
    private func getGitHub() {
        let provider = MoyaProvider<GitHub>()
        provider.rx.request(.userProfile("kouheiszk"))
            .filterSuccessfulStatusCodes()
            .map(Profile.self)
            .subscribe(onSuccess: { (profile) in
                print(profile)
            }) { (error) in
                print(error)
            }
            .disposed(by: disposeBag)
    }

    private func toTableView() {
        self.tableView = UITableView(frame: self.view.frame, style: .plain)
        
        self.tableView!.register(UITableViewCell.self, forCellReuseIdentifier: "Cell")
        self.view.addSubview(self.tableView)
        
        //获取列表数据
        let data = DouBanProvider.rx.request(.channels)
            .mapJSON()
            .map { data -> [[String: Any]] in
                if let json = data as? [String: Any],
                    let channels = json["channels"] as? [[String: Any]] {
                    return channels
                } else {
                    return []
                }
            }.asObservable()
        
        //将数据绑定到表格
        data.bind(to: tableView.rx.items) { (tableView, row, element) in
            let cell = tableView.dequeueReusableCell(withIdentifier: "Cell")!
            cell.textLabel?.text = "\(element["name"]!)"
            cell.accessoryType = .disclosureIndicator
            return cell
        }.disposed(by: disposeBag)
        
        //单元格点击
        tableView.rx.modelSelected([String: Any].self)
            .map { $0["channel_id"] as! String }
            .flatMap { DouBanProvider.rx.request(.playlist($0)) }
            .mapJSON()
            .subscribe(onNext: { [weak self] data in
                // 解析数据，获取歌曲信息
                if let json = data as? [String: Any],
                    let musics = json["song"] as?  [[String: Any]] {
                    let artist = musics[0]["artist"]!
                    let title = musics[0]["title"]!
                    let message = "歌手：\(artist)\n歌曲：\(title)"
                    //将歌曲信息弹出显示
                    self?.showAlert(title: "歌曲信息", message: message)
                }
            }).disposed(by: disposeBag)
    }
    
    private func toMapObject() {
        self.tableView = UITableView(frame: self.view.frame, style: .plain)
        self.tableView!.register(UITableViewCell.self, forCellReuseIdentifier: "Cell")
        self.view.addSubview(self.tableView)
        let data = DouBanProvider.rx.request(.channels)
            .asObservable()
            .mapObject(type: Douban.self)
            .map { $0.channels ?? [] }
        
        //将数据绑定到表格
        data.bind(to: tableView.rx.items) { (tableView, row, element) in
            let cell = tableView.dequeueReusableCell(withIdentifier: "Cell")!
            cell.textLabel?.text = "\(element.name!)"
            cell.accessoryType = .disclosureIndicator
            return cell
        }.disposed(by: disposeBag)
        
        //单元格点击
        tableView.rx.modelSelected(Channel.self)
        .map{ $0.channelId! }
            .flatMap { DouBanProvider.rx.request(.playlist($0)) }
            .mapObject(type: Playlist.self)
            .subscribe(onNext: {[weak self] playlist in
                //解析数据，获取歌曲信息
                if playlist.song.count > 0 {
                    let artist = playlist.song[0].artist!
                    let title = playlist.song[0].title!
                    let message = "歌手：\(artist)\n歌曲：\(title)"
                    //将歌曲信息弹出显示
                    self?.showAlert(title: "歌曲信息", message: message)
                }
            }).disposed(by: disposeBag)
    }
}

extension ViewController {
    
    //显示消息
    func showAlert(title:String, message:String){
        let alertController = UIAlertController(title: title,
                                                message: message, preferredStyle: .alert)
        let cancelAction = UIAlertAction(title: "确定", style: .cancel, handler: nil)
        alertController.addAction(cancelAction)
        self.present(alertController, animated: true, completion: nil)
    }
}


extension Observable {
    func mapObject<T: Mappable>(type: T.Type) -> Observable<T> {
        return self.map { response in
            //if response is a dictionary, then use ObjectMapper to map the dictionary
            //if not throw an error
            guard let dict = response as? [String: Any] else {
                throw NSError(domain: "errorメッセージ", code: -1, userInfo: nil)
            }
            return Mapper<T>().map(JSON: dict)!
        }
    }
    
    func mapArray<T: Mappable>(type: T.Type) -> Observable<[T]> {
        return self.map { response in
            //if response is an array of dictionaries, then use ObjectMapper to map the dictionary
            //if not, throw an error
            guard let array = response as? [[String: Any]] else {
                //throw RxSwiftMoyaError.ParseJSONError
                throw NSError(domain: "errorメッセージ", code: -1, userInfo: nil)
            }
            return Mapper<T>().mapArray(JSONArray: array)
        }
    }
}
