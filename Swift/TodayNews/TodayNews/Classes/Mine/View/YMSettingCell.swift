//
//  YMSettingCell.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/18.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

class YMSettingCell: UITableViewCell {
    
    var setting: YMSettingModel! {
        didSet {
            titleLabel.text = setting.title
            subtitleLabel.text = setting.subtitle
            rightTitleLabel.text = setting.rightTitle
            arrowImageView.isHidden = setting.isHiddenArraw!
            switchView.isHidden = setting.isHiddenSwitch!
            lineView.isHidden = setting.isHiddenLine!
            rightTitleLabel.isHidden = setting.isHiddenRightTitle!
            if setting.subtitle?.count ?? 0 > 0 {
                titleConstraint.constant = -kMargin
            }
        }
    }
    
    @IBOutlet weak var titleConstraint: NSLayoutConstraint!
    
    @IBOutlet weak var titleLabel: UILabel!
    
    @IBOutlet weak var subtitleLabel: UILabel!
    
    @IBOutlet weak var rightTitleLabel: UILabel!
    
    @IBOutlet weak var arrowImageView: UIImageView!
    
    @IBOutlet weak var switchView: UISwitch!
    
    @IBOutlet weak var lineView: UIView!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
        
        // Configure the view for the selected state
    }
}
