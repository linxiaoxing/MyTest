//
//  YMCareheaderView.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/19.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit
import SnapKit

class YMCareheaderView: UIView {
    
    var title: String? {
        didSet {
            titleLabel.text = title
        }
    }
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        
        setupUI()
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    // 底部 view
    private lazy var bgView: UIView = {
        let bgView = UIView()
        bgView.backgroundColor = UIColor.white
        return bgView
    }()
    
    // 红色分割 view
    private lazy var redView: UIView = {
        let redView = UIView()
        redView.layer.cornerRadius = 2
        redView.layer.masksToBounds = true
        redView.backgroundColor = YMColor(241, g: 94, b: 91, a: 1.0)
        return redView
    }()
    
    // 标题
    lazy var titleLabel: UILabel = {
        let titleLabel = UILabel()
        titleLabel.font = UIFont.systemFont(ofSize: 12)
        return titleLabel
    }()
}

extension YMCareheaderView {
    
    func setupUI() {
        // 底部 view
        addSubview(bgView)
        // 红色分割 view
        bgView.addSubview(redView)
        // 标题
        bgView.addSubview(titleLabel)
        bgView.snp_makeConstraints {(make) in
            make.top.equalTo(self)
            make.left.bottom.right.equalTo(self)
        }
        
        redView.snp_makeConstraints { (make) in
            make.left.equalTo(bgView).offset(15)
            make.size.equalTo(CGSize(width: 5, height: 12))
            make.centerY.equalTo(bgView.centerY)
        }
        
        titleLabel.snp_makeConstraints { (make) in
            make.left.equalTo(redView.snp_right).offset(5)
            make.top.equalTo(redView.snp_top)
            make.bottom.equalTo(redView.snp_bottom)
        }
    }
}
