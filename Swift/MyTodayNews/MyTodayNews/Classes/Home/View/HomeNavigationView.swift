//
//  HomeNavigationView.swift
//  MyTodayNews
//
//  Created by 林小興 on 2019/05/21.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit
import IBAnimatable

class HomeNavigationView: UIView, NibLoadable {
   
    @IBOutlet weak var searchButton: AnimatableButton!
    
    @IBOutlet weak var avatarButton: UIButton!
    @IBOutlet weak var cameraButton: UIButton!
    
    /// 搜索按钮点击
    var didSelectSearchButton: (()->())?
    /// 头像按钮点击
    var didSelectAvatarButton: (()->())?
    /// 相机按钮点击
    var didSelectCameraButton: (()->())?
    
    override func awakeFromNib() {
        super.awakeFromNib()
        searchButton.theme_backgroundColor = "colors.cellBackgroundColor"
    searchButton.theme_setTitleColor("colors.grayColor150", forState: .normal)
    }
    
    /// 固有的大小
    override var intrinsicContentSize: CGSize {
        return UIView.layoutFittingExpandedSize
    }
    
    /// 重写 frame
    override var frame: CGRect {
        didSet {
            super.frame = CGRect(x: 0, y: 0, width: screenWidth, height: 44)
        }
    }
    
    /// 相机按钮点击
    @IBAction func cameraButtonClicked(_ sender: UIButton) {
        didSelectCameraButton?()
    }
    /// 头像按钮点击
    @IBAction func avatarButtonClicked(_ sender: UIButton) {
        didSelectAvatarButton?()
    }
    
    /// 搜索按钮点击
    @IBAction func searchButtonClicked(_ sender: AnimatableButton) {
        didSelectSearchButton?()
    }
}

