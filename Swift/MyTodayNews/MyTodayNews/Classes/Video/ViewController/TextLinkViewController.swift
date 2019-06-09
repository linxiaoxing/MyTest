//
//  TextLinkViewController.swift
//  MyTodayNews
//
//  Created by 林小興 on 2019/05/26.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit
import WebKit

class TextLinkViewController: UIViewController {
    
    var url = ""

    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        navigationController?.setNavigationBarHidden(false, animated: animated)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        navigationController?.setNavigationBarHidden(true, animated: animated)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let webView = WKWebView(frame: view.bounds, configuration: WKWebViewConfiguration())
        webView.load(URLRequest(url: URL(string: url)!))
        view.addSubview(webView)
    }
}
