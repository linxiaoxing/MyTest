//
//  ViewController.swift
//  RxMvvmDriver
//
//  Created by 林小興 on 2019/05/26.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit
import RxCocoa
import RxSwift

class ViewController: UIViewController {

    //显示资源列表的tableView
    var tableView:UITableView!
    
    //搜索栏
    var searchBar:UISearchBar!
    
    let disposeBag = DisposeBag()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
         //创建表视图
        self.tableView = UITableView(frame:self.view.frame, style:.plain)
        //创建一个重用的单元格
        self.tableView!.register(UITableViewCell.self, forCellReuseIdentifier: "Cell")
        self.view.addSubview(self.tableView!)
        
        //创建表头的搜索栏
        self.searchBar = UISearchBar(frame: CGRect(x: 0, y: 0,
                                     width: self.view.bounds.size.width, height: 56))
        
         self.tableView.tableHeaderView =  self.searchBar
        
         //查询条件输入
         let searchAction = searchBar.rx.text.orEmpty.asDriver()
             .throttle(0.5)
             .distinctUntilChanged()
        
        //初始化ViewModel
        let viewModel = ViewModel(searchAction: searchAction)
        
        //绑定导航栏标题数据
        viewModel.navigationTitle.drive(self.navigationItem.rx.title).disposed(by: disposeBag)
        
        //将数据绑定到表格
        viewModel.repositories.drive(tableView.rx.items) { (tableView, row, element) in
            let cell = UITableViewCell(style: .subtitle, reuseIdentifier: "Cell")
            cell.textLabel?.text = element.name
            cell.detailTextLabel?.text = element.htmlUrl
            return cell
            }.disposed(by: disposeBag)
        
        //单元格点击
        tableView.rx.modelSelected(GitHubRepository.self)
            .subscribe(onNext: {[weak self] item in
                //显示资源信息（完整名称和描述信息）
                self?.showAlert(title: item.fullName, message: item.description)
            }).disposed(by: disposeBag)
    }

    //显示消息
    func showAlert(title:String, message:String){
        let alertController = UIAlertController(title: title,
                                                message: message, preferredStyle: .alert)
        let cancelAction = UIAlertAction(title: "确定", style: .cancel, handler: nil)
        alertController.addAction(cancelAction)
        self.present(alertController, animated: true, completion: nil)
    }

}

