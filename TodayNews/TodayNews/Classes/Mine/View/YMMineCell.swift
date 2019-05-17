//
//  YMMineCell.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/17.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

class YMMineCell: UITableViewCell {
    
    var cellModel: YMMineCellModel? {
        didSet {
            titleLabel.text = cellModel!.title
            subtitleLabel.text = cellModel!.subtitle
            lineView.isHidden = cellModel!.isHiddenLine!
            subtitleLabel.isHidden = cellModel!.isHiddenSubtitle!
        }
    }
    
    @IBOutlet weak var titleLabel: UILabel!
    
    @IBOutlet weak var subtitleLabel: UILabel!
    
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
