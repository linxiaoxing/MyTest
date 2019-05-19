//
//  YMNewCareTopCell.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/19.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

class YMNewCareTopCell: UITableViewCell {
    
    @IBOutlet weak var titleImageView: UIImageView!
    
    @IBOutlet weak var titleLabel: UILabel!
    
    @IBOutlet weak var newButton: UIButton!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        newButton.layer.cornerRadius = 8
        newButton.layer.masksToBounds = true
        newButton.layer.shouldRasterize = true
        newButton.layer.rasterizationScale = UIScreen.main.scale
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
        
        // Configure the view for the selected state
    }
}
