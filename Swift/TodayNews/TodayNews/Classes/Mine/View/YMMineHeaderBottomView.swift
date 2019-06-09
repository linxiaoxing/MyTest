//
//  YMMineHeaderBottomView.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/17.
//  Copyright © 2019 林小興. All rights reserved.
//
//  我的界面 -> 头部 view -> 底部白色 view(包含三个按钮)
//
import UIKit
import Kingfisher

protocol YMMineHeaderBottomViewDelegate: NSObjectProtocol {
    func headerBottomView(_ bottomView: YMMineHeaderBottomView, collectionButton: YMVerticalButton)
    func headerBottomView(_ bottomView: YMMineHeaderBottomView, nightButton: YMVerticalButton)
    func headerBottomView(_ bottomView: YMMineHeaderBottomView, settingButton: YMVerticalButton)
}

class YMMineHeaderBottomView: UIView {
    
    weak var delegate: YMMineHeaderBottomViewDelegate?
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        backgroundColor = UIColor.white
        // 设置三个按钮
        setupUI()
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
     // 设置三个按钮
    private func setupUI() {
        // 添加收藏按钮
        addSubview(collectionButton)
        // 添加夜间按钮
        addSubview(nightButton)
        // 添加设置按钮
        addSubview(settingButton)
        
        collectionButton.snp_makeConstraints { (make) in
            make.width.equalTo(50)
            make.top.bottom.equalTo(self)
            make.left.equalTo(self).offset(50)
            make.right.lessThanOrEqualTo(nightButton).offset(-kMargin)
        }
        
        nightButton.snp_makeConstraints { (make) in
            make.width.equalTo(50)
            make.top.bottom.equalTo(self)
            make.centerX.equalTo(snp.centerX)
        }
        
        settingButton.snp_makeConstraints { (make) in
            make.width.equalTo(50)
            make.top.bottom.equalTo(self)
            make.right.equalTo(self).offset(-50)
            make.right.greaterThanOrEqualTo(nightButton).offset(kMargin)
        }
    }
    
    /// 懒加载，创建收藏按钮
    private lazy var collectionButton: YMVerticalButton = {
        let collectionButton = YMVerticalButton()
        collectionButton.setTitle("收 藏", for: .normal)
        collectionButton.setTitleColor(UIColor.black, for: .normal)
        collectionButton.addTarget(self, action: #selector(collectionBtnClick(_:)), for: .touchUpInside)
        collectionButton.setImage(UIImage(named: "favoriteicon_profile_24x24_"), for: .normal)
        collectionButton.setImage(UIImage(named: "favoriteicon_profile_press_24x24_"), for: .highlighted)
        collectionButton.titleLabel?.font = UIFont.systemFont(ofSize: 15)
        return collectionButton
    }()
    
     /// 懒加载，创建夜间按钮
    private lazy var nightButton: YMVerticalButton = {
        let nightButton = YMVerticalButton()
        nightButton.setTitle("夜 间", for: .normal)
        nightButton.setTitleColor(UIColor.black, for: .normal)
        nightButton.addTarget(self, action: #selector(nightBtnClick(_:)), for: .touchUpInside)
        nightButton.setImage(UIImage(named: "nighticon_profile_24x24_"), for: .normal)
        
        nightButton.setImage(UIImage(named: "nighticon_profile_press_24x24_"), for: .highlighted)
        nightButton.titleLabel?.font = UIFont.systemFont(ofSize: 15)
        return nightButton
    }()
    
    /// 懒加载，创建设置按钮
    private lazy var settingButton: YMVerticalButton = {
        let settingButton = YMVerticalButton()
        settingButton.setTitle("设 置", for: .normal)
        settingButton.setTitleColor(UIColor.black, for: .normal)
        settingButton.setImage(UIImage(named: "setupicon_profile_24x24_"), for: .normal)
        
        settingButton.setImage(UIImage(named: "setupicon_profile_press_24x24_"), for: .highlighted)
        settingButton.addTarget(self, action: #selector(settingBtnClick(_:)), for: .touchUpInside)
        settingButton.titleLabel?.font = UIFont.systemFont(ofSize: 15)
        return settingButton
    }()
    
    @objc func collectionBtnClick(_ button: YMVerticalButton) {
        delegate?.headerBottomView(self, collectionButton: button)
    }
    
    @objc func nightBtnClick(_ button: YMVerticalButton) {
        delegate?.headerBottomView(self, nightButton: button)
    }
    
    @objc func settingBtnClick(_ button: YMVerticalButton) {
        delegate?.headerBottomView(self, settingButton: button)
    }
}
