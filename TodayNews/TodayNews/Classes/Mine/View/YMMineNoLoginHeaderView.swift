//
//  YMMineNoLoginHeaderView.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/18.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

class YMMineNoLoginHeaderView: UIView {
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
    }
    
    class func noLoginHeaderView() -> YMMineNoLoginHeaderView {
        return Bundle.main.loadNibNamed("YMMineNoLoginHeaderView", owner: nil, options: nil)?.last as! YMMineNoLoginHeaderView
    }
}

