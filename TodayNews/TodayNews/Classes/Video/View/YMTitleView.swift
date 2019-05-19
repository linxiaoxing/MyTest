//
//  YMTitleView.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/19.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit
import SnapKit

protocol YMTitleViewDelegate: NSObjectProtocol {
    func titleView(_ titleView: YMTitleView, titleSearchButton button: UIButton)
}

class YMTitleView: UIView {
    
    weak var delegate: YMTitleViewDelegate?
    
    class func titleView() -> YMTitleView {
        let frame = CGRect(x: 0, y: 0, width: SCREENW, height: 44)
        return YMTitleView(frame: frame)
    }
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setupUI()
    }
    
    private func setupUI() {
        addSubview(titleScrollView)
        
        addSubview(titleSearchButton)
        
        titleScrollView.snp_makeConstraints { (make) in
            make.left.top.bottom.equalTo(self)
        }
        
        titleSearchButton.snp_makeConstraints { (make) in
            make.left.equalTo(titleScrollView.snp_right)
            make.size.equalTo(CGSize(width: 30, height: 44))
            make.top.right.bottom.equalTo(self)
        }
    }
    
    private lazy var titleSearchButton: UIButton = {
        let titleSearchButton = UIButton()
        //        titleSearchButton.setBackgroundImage(UIImage(named: "shadow_add_titlebar_new_52x44_"), forState: .Normal)
        titleSearchButton.setImage(UIImage(named: "search_topic_24x24_"), for: .normal)
        titleSearchButton.addTarget(self, action: #selector(titleSearchButtonClick(_:)), for: .touchUpInside)
        return titleSearchButton
    }()
    
    private lazy var titleScrollView: UIScrollView = {
        let titleScrollView = UIScrollView()
        return titleScrollView
    }()
    
    @objc func titleSearchButtonClick(_ button: UIButton) {
        delegate?.titleView(self, titleSearchButton: button)
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
}
