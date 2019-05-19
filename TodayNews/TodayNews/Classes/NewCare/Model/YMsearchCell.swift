//
//  YMsearchCell.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/19.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit

class YMsearchCell: UITableViewCell {
    
    @IBOutlet weak var keywordLabel: UILabel!
    var keyword: YMKeyword? {
        didSet {
            keywordLabel.text = keyword!.keyword
        }
    }
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
        
        // Configure the view for the selected state
    }
}
