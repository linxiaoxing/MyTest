//
//  YMNewCareBottomCell.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/19.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit
import Kingfisher
protocol YMNewCareBottomCellDelegate: NSObjectProtocol {
    func bottomCell(_ bottomCell: YMNewCareBottomCell, careButton: UIButton)
}

class YMNewCareBottomCell: UITableViewCell {
    
    weak var delegate: YMNewCareBottomCellDelegate?
    
    var concern: YMConcern? {
        didSet {
            let url = concern!.avatar_url!
            titleImageView.kf.setImage(with: ImageResource(downloadURL:URL(string: url)!))
            titleLabel.text = concern!.name
            peopleCountLabel.text = "\(concern!.concern_count)人关心"
            peopleCountLabel.isHidden = (concern!.concern_count != 0) ? false : true
            commentCountLabel.text = "\(concern!.discuss_count)条评论"
            commentCountLabel.isHidden = (concern!.discuss_count != 0) ? false : true
        }
    }
    @IBOutlet weak var titleImageView: UIImageView!
    // 关注标题
    @IBOutlet weak var titleLabel: UILabel!
    // 关注人数
    @IBOutlet weak var peopleCountLabel: UILabel!
    // 评论条数
    @IBOutlet weak var commentCountLabel: UILabel!
    // 关心按钮
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
    
    @IBAction func careButtonClick(sender: UIButton) {
         delegate?.bottomCell(self, careButton: sender)
    }
    
}
