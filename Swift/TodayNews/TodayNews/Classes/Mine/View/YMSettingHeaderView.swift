//
//  YMSettingHeaderView.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/19.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

protocol YMSettingHeaderViewDelegate: NSObjectProtocol {
    func settingHeaderView(_ headerView: YMSettingHeaderView, accountManageButton: UIButton)
}

class YMSettingHeaderView: UIView {
    
    weak var delegate: YMSettingHeaderViewDelegate?
    
    class func settingHeaderView() -> YMSettingHeaderView {
        return Bundle.main.loadNibNamed("YMSettingHeaderView", owner: nil, options: nil)?.last as! YMSettingHeaderView
    }
    
    @IBOutlet weak var accountManageButton: UIButton!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
    }
    
    @IBAction func accountManageButtonClick(sender: UIButton) {
        delegate?.settingHeaderView(self,  accountManageButton: sender)
    }
}
