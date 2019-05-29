//
//  ShengxiaoCell.swift
//  MyTodayNews
//
//  Created by 林小興 on 2019/05/28.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit
import IBAnimatable

class ShengxiaoCell: UICollectionViewCell, RegisterCellFromNib {
    
    @IBOutlet weak var imageView: AnimatableImageView!
    
    var shengxiao = Shengxiao() {
        didSet {
            imageView.image = UIImage(named: shengxiao.small)
        }
    }
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
    }
    
}
