//
//  YMMineHeaderIconButton.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/18.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

class YMMineHeaderIconButton: UIButton {
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        titleLabel?.textAlignment = .center
        titleLabel?.font = UIFont.systemFont(ofSize: 18)
        setTitleColor(UIColor.white, for: .normal)
        imageView?.layer.cornerRadius = 25
        imageView?.layer.masksToBounds = true
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func layoutSubviews() {
        super.layoutSubviews()
        // 调整图片
        imageView?.x = kMargin
        imageView?.y = 0
        imageView?.width = 50
        imageView?.height = imageView!.width
        // 调整文字
        titleLabel?.x = 0
        titleLabel?.y = imageView!.height + kMargin
        titleLabel?.width = self.width
        titleLabel?.height = 2 * kMargin
    }
}
