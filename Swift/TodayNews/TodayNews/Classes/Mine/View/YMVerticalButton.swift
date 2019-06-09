//
//  YMVerticalButton.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/17.
//  Copyright © 2019 林小興. All rights reserved.
//


import UIKit

class YMVerticalButton: UIButton {
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        titleLabel?.textAlignment = .center
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    override func layoutSubviews() {
        super.layoutSubviews()
        // 调整图片
        imageView?.centerX = self.width * 0.5
        imageView?.y = kMargin
        imageView?.width = 24
        imageView?.height = imageView!.width
        // 调整文字
        titleLabel?.x = 0
        titleLabel?.y = imageView!.height + kMargin
        titleLabel?.width = self.width
        titleLabel?.height = self.height - self.titleLabel!.y
    }
}
