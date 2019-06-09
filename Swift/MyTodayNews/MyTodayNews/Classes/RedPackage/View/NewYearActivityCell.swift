//
//  NewYearActivityCell.swift
//  MyTodayNews
//
//  Created by 林小興 on 2019/05/28.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

class NewYearActivityCell: UITableViewCell, RegisterCellFromNib {
    
    var newYearActivity = NewYearActivity() {
        didSet {
            mainImageView.image = UIImage(named: newYearActivity.image)
            titleLabel.text = newYearActivity.title
        }
    }
    
    @IBOutlet weak var mainImageView: UIImageView!
    
    @IBOutlet weak var titleLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }
}
