//
//  DongtaiCollectionViewCell.swift
//  MyTodayNews
//
//  Created by 林小興 on 2019/06/19.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit
import Kingfisher
import SVProgressHUD

class DongtaiCollectionViewCell: UICollectionViewCell, RegisterCellFromNib {
    
    var isPostSmallVideo = false {
        didSet {
           iconButton.theme_setImage(isPostSmallVideo ? "images.smallvideo_all_32x32_" : nil, forState: .normal)
        }
    }
    
    var thumbImage = ThumbImage() {
        didSet {
            thumbImageView.kf.setImage(with: URL(string: thumbImage.urlString)!)
            gifLabel.isHidden = !(thumbImage.type == .gif)
        }
    }
    
    var largeImage = LargeImage() {
        didSet {
            thumbImageView.kf.setImage(with: URL(string: largeImage.urlString), placeholder: nil, options: nil, progressBlock: { (receivedSize, totalSize) in
                let progress = Float(receivedSize) / Float(totalSize)
                SVProgressHUD.showProgress(progress)
                SVProgressHUD.setBackgroundColor(.clear)
                SVProgressHUD.setForegroundColor(UIColor.white)
            }) { (image, error, cacheType, url) in
                SVProgressHUD.dismiss()
            }
        }
    }
    @IBOutlet weak var thumbImageView: UIImageView!
    
    @IBOutlet weak var iconButton: UIButton!
    
    @IBOutlet weak var gifLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        thumbImageView.layer.theme_borderColor = "colors.grayColor230"
        thumbImageView.layer.borderWidth = 1
        theme_backgroundColor = "colors.cellBackgroundColor"
    }

}
