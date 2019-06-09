//
//  RainNextURLViewController.swift
//  MyTodayNews
//
//  Created by 林小興 on 2019/05/28.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit
import WebKit

class RainNextURLViewController: UIViewController {
    
    var url = ""
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        navigationController?.setNavigationBarHidden(true, animated: false)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        let webView = WKWebView(frame: view.bounds, configuration: WKWebViewConfiguration())
        webView.load(URLRequest(url: URL(string: url)!))
        view.addSubview(webView)
        let backButton = UIButton()
        backButton.setImage(UIImage(named: "personal_home_back_white_24x24_"), for: .normal)
        backButton.frame = CGRect(x: 0, y: isIPhoneX ? 44 : 20, width: 40, height: 40)
        backButton.addTarget(self, action: #selector(goBack), for: .touchUpInside)
        view.addSubview(backButton)
    }
    
    @objc private func goBack() {
        navigationController?.popViewController(animated: true)
    }
    
    override var preferredStatusBarStyle: UIStatusBarStyle {
        return .lightContent
    }
}
