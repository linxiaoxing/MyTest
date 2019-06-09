//
//  YMMineHeaderView.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/17.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit
import SnapKit

protocol YMMineHeaderViewDelegae: NSObjectProtocol {
    func headerView(_ headerView: YMMineHeaderView, headPhotoBbutton: YMMineHeaderIconButton)
}

class YMMineHeaderView: UIView {
    
    weak var delegate: YMMineHeaderViewDelegae?
    
    class func headerView() -> YMMineHeaderView {
        let frame = CGRect(x: 0, y: 0, width: SCREENW, height: 278)
        return YMMineHeaderView(frame: frame)
    }
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        // 设置 UI
        setupUI()
        
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    /// 设置 UI
    private func setupUI() {
        // 添加背景图片
        addSubview(bgImageView)
        // 添加头像按钮
        addSubview(headPhotoButton)
        // 添加背景图片
        addSubview(bottomView)
        
        // 设置约束
        bgImageView.snp_makeConstraints { (make) in
            make.left.right.equalTo(self)
            make.top.equalTo(self).offset(-2 * kMargin)
            make.height.equalTo(kYMMineHeaderImageHeight)
        }
        
        headPhotoButton.snp_makeConstraints { (make) in
            make.centerX.equalTo(snp.centerX)
            make.size.equalTo(CGSize(width: 70, height: 70))
            make.top.equalTo(bgImageView.snp_top).offset(64)
        }
        
        bottomView.snp_makeConstraints { (make) in
            make.left.bottom.right.equalTo(self)
            make.top.equalTo(bgImageView.snp_bottom)
        }
    }
    
    /// 懒加载，创建背景图片
    lazy var bgImageView: UIImageView = {
        let bgImageView = UIImageView()
        bgImageView.contentMode = .scaleAspectFill
        bgImageView.image = UIImage(named: "hrscy")
        return bgImageView
    }()
    
    /// 懒加载，创建头像按钮
    lazy var headPhotoButton: YMMineHeaderIconButton = {
        let headPhotoButton = YMMineHeaderIconButton()
        headPhotoButton.addTarget(self, action: #selector(headPhotoBtnClick(_:)), for: .touchUpInside)
        headPhotoButton.setTitle("hrscy", for: .normal)
        headPhotoButton.setImage(UIImage(named: "hrscy"), for: .normal)
        return headPhotoButton
    }()
    
    /// 懒加载，创建底部白色 view
    lazy var bottomView: YMMineHeaderBottomView = {
        let bottomView = YMMineHeaderBottomView()
        return bottomView
    }()
    
    /// 头像按钮点击
    @objc func headPhotoBtnClick(_ button: YMMineHeaderIconButton) {
        delegate?.headerView(self, headPhotoBbutton: button)
    }
}
