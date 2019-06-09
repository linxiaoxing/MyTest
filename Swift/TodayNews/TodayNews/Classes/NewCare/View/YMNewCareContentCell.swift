//
//  YMNewCareContentCell.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/19.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

class YMNewCareContentCell: UITableViewCell {
    
    @IBOutlet weak var titleLabel: UILabel!
    
    @IBOutlet weak var avaterImageView: UIImageView!
    
    @IBOutlet weak var peopleCountLabel: UILabel!
    
    @IBOutlet weak var commentCountLabel: UILabel!
    
    @IBOutlet weak var careButton: UIButton!

    override func awakeFromNib() {
        super.awakeFromNib()
        careButton.layer.cornerRadius = 7
        careButton.layer.masksToBounds = true
        careButton.layer.borderColor = YMColor(91, g: 162, b: 207, a: 1.0).cgColor
        careButton.layer.borderWidth = klineWidth
        careButton.layer.shouldRasterize = true
        careButton.layer.rasterizationScale = UIScreen.main.scale
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
        
        // Configure the view for the selected state
    }
}
