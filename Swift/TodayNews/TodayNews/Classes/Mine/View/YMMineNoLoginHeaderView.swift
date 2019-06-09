//
//  YMMineNoLoginHeaderView.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/18.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit
import SnapKit

protocol YMMineNoLoginHeaderViewDelegate: NSObjectProtocol {
    /// 手机号登录按钮点击
    func noLoginHeaderView(_ headerView: YMMineNoLoginHeaderView, mobileLoginButtonClick: UIButton)
    /// 微信登录按钮点击
    func noLoginHeaderView(_ headerView: YMMineNoLoginHeaderView, wechatLoginButtonClick: UIButton)
    /// QQ 登录按钮点击
    func noLoginHeaderView(_ headerView: YMMineNoLoginHeaderView, qqLoginButtonClick: UIButton)
    /// 微博登录按钮点击
    func noLoginHeaderView(_ headerView: YMMineNoLoginHeaderView, weiboLoginButtonClick: UIButton)
    /// 更多登录方式按钮点击
    func noLoginHeaderView(_ headerView: YMMineNoLoginHeaderView, moreLoginButtonClick: UIButton)
}

class YMMineNoLoginHeaderView: UIView {
    
    weak var delegate: YMMineNoLoginHeaderViewDelegate?
    
    class func noLoginHeaderView() -> YMMineNoLoginHeaderView {
        let frame = CGRect(x: 0, y: 0, width: SCREENW, height: 278)
        return YMMineNoLoginHeaderView(frame: frame)
    }
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        
        setupUI()
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
    }
    
//    class func noLoginHeaderView() -> YMMineNoLoginHeaderView {
//        return Bundle.main.loadNibNamed("YMMineNoLoginHeaderView", owner: nil, options: nil)?.last as! YMMineNoLoginHeaderView
//    }
    
    private func setupUI() {
        // 添加背景图片
        addSubview(bgImageView)
        // 添加四个按钮
        addSubview(mobileLoginButton)
        addSubview(wechatLoginButton)
        addSubview(qqLoginButton)
        addSubview(weiboLoginButton)
        // 添加更多登录按钮
        addSubview(moreLoginButton)
        // 添加底部 view
        addSubview(bottomView)
        
        // 设置约束
        bgImageView.snp_makeConstraints { (make) in
            make.left.right.equalTo(self)
            make.top.equalTo(self).offset(-2 * kMargin)
            make.height.equalTo(kYMMineHeaderImageHeight)
        }
        
        mobileLoginButton.snp_makeConstraints { (make) in
            make.size.equalTo(CGSize(width: 60, height: 60))
            make.top.equalTo(wechatLoginButton.snp_top)
        }
        
        wechatLoginButton.snp_makeConstraints { (make) in
            make.top.equalTo(bgImageView.snp_top).offset(70)
            make.size.equalTo(mobileLoginButton.snp_size)
            make.left.equalTo(mobileLoginButton.snp_right).offset(2 * kMargin)
            make.right.equalTo(self.snp_centerX).offset(-kMargin)
        }
        
        qqLoginButton.snp_makeConstraints { (make) in
            make.size.equalTo(wechatLoginButton.snp_size)
            make.top.equalTo(wechatLoginButton.snp_top)
            make.left.equalTo(self.snp_centerX).offset(kMargin)
        }
        
        weiboLoginButton.snp_makeConstraints { (make) in
            make.size.equalTo(qqLoginButton.snp_size)
            make.left.equalTo(qqLoginButton.snp_right).offset(2 * kMargin)
            make.top.equalTo(qqLoginButton.snp_top)
        }
        
        moreLoginButton.snp_makeConstraints { (make) in
            make.centerX.equalTo(0)
            make.size.equalTo(CGSize(width: 110, height: 24))
            make.top.equalTo(weiboLoginButton.snp_bottom).offset(2 * kMargin)
        }
        
        bottomView.snp_makeConstraints { (make) in
            make.left.bottom.right.equalTo(self)
            make.top.equalTo(bgImageView.snp_bottom)
        }
    }
    
    
    /// 手机号登录按钮
    private lazy var mobileLoginButton: UIButton = {
        let mobileButton = UIButton()
        mobileButton.setImage(UIImage(named: "cellphoneicon_login_profile_78x78_"), for: .normal)
        mobileButton.addTarget(self, action: #selector(moreLoginButtonClick(_:)), for: .touchUpInside)
        return mobileButton
    }()
    
    /// 微信登录按钮
    private lazy var wechatLoginButton: UIButton = {
        let wechatLoginButton = UIButton()
        wechatLoginButton.setImage(UIImage(named: "weixinicon_login_profile_78x78_"), for: .normal)
        wechatLoginButton.addTarget(self, action: #selector(moreLoginButtonClick(_:)), for: .touchUpInside)
        return wechatLoginButton
    }()
    
    /// QQ 登录按钮
    private lazy var qqLoginButton: UIButton = {
        let qqLoginButton = UIButton()
        qqLoginButton.setImage(UIImage(named: "qqicon_login_profile_78x78_"), for: .normal)
        qqLoginButton.addTarget(self, action: #selector(moreLoginButtonClick(_:)), for: .touchUpInside)
        return qqLoginButton
    }()
    
    /// 微博登录按钮
    private lazy var weiboLoginButton: UIButton = {
        let weiboLoginButton = UIButton()
        weiboLoginButton.setImage(UIImage(named: "sinaicon_login_profile_78x78_"), for: .normal)
        weiboLoginButton.addTarget(self, action: #selector(moreLoginButtonClick(_:)), for: .touchUpInside)
        return weiboLoginButton
    }()
    
    /// 懒加载，创建背景图片
    lazy var bgImageView: UIImageView = {
        let bgImageView = UIImageView()
        bgImageView.contentMode = .scaleAspectFill
        bgImageView.image = UIImage(named: "wallpaper_profile")
        return bgImageView
    }()
    
    /// 创建 更多登录方式按钮
    private lazy var moreLoginButton: UIButton = {
        let moreLoginButton = UIButton()
        moreLoginButton.setTitle("更多登录方式 >", for: .normal)
        moreLoginButton.setTitleColor(UIColor.white, for: .normal)
        moreLoginButton.titleLabel?.font = UIFont.systemFont(ofSize: 13)
        moreLoginButton.backgroundColor = UIColor.lightGray
        moreLoginButton.layer.cornerRadius = 13
        moreLoginButton.layer.masksToBounds = true
        moreLoginButton.addTarget(self, action: #selector(moreLoginButtonClick(_:)), for: .touchUpInside)
        return moreLoginButton
    }()
    
    /// 懒加载，创建底部白色 view
    lazy var bottomView: YMMineHeaderBottomView = {
        let bottomView = YMMineHeaderBottomView()
        return bottomView
    }()

    /// 手机号登录按钮点击
    @objc func mobileLoginButtonClick(_ button: UIButton) {
        delegate?.noLoginHeaderView(self, mobileLoginButtonClick: button)
    }
    
    /// 微信登录按钮点击
    @objc func wechatLoginButtonClick(_ button: UIButton) {
        delegate?.noLoginHeaderView(self, wechatLoginButtonClick: button)
    }
    
    /// QQ 登录按钮点击
    @objc func qqLoginButtonClick(_ button: UIButton) {
        delegate?.noLoginHeaderView(self, qqLoginButtonClick: button)
    }
    
    /// 微博登录按钮点击
    @objc func weiboLoginButtonClick(_ button: UIButton) {
        delegate?.noLoginHeaderView(self, weiboLoginButtonClick: button)
    }
    
    /// 更多登录方式按钮点击
    @objc func moreLoginButtonClick(_ button: UIButton) {
        delegate?.noLoginHeaderView(self, moreLoginButtonClick: button)
    }

}

