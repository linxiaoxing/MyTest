//
//  YMTitleView.swift
//  TodayNews
//
//  Created by 林小興 on 2019/05/19.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit
import SnapKit

let videoCollectionViewCellID = "videoCollectionViewCellID"

protocol YMTitleViewDelegate: NSObjectProtocol {
    func titleView(_ titleView: YMTitleView, titleSearchButton button: UIButton)
}

class YMTitleView: UIView {
    
    weak var delegate: YMTitleViewDelegate?
    
    class func titleView() -> YMTitleView {
        let frame = CGRect(x: 0, y: 0, width: SCREENW, height: 44)
        return YMTitleView(frame: frame)
    }
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setupUI()
    }
    
    private func setupUI() {
        addSubview(titleCollectionView)
        
        addSubview(titleSearchButton)
        
        titleCollectionView.snp_makeConstraints { (make) in
            make.left.top.bottom.equalTo(self)
        }
        
        titleSearchButton.snp_makeConstraints { (make) in
            make.left.equalTo(titleCollectionView.snp_right)
            make.size.equalTo(CGSize(width: 30, height: 44))
            make.top.right.bottom.equalTo(self)
        }
    }
    
    private lazy var titleSearchButton: UIButton = {
        let titleSearchButton = UIButton()
        //        titleSearchButton.setBackgroundImage(UIImage(named: "shadow_add_titlebar_new_52x44_"), forState: .Normal)
        titleSearchButton.setImage(UIImage(named: "search_topic_24x24_"), for: .normal)
        titleSearchButton.addTarget(self, action: #selector(titleSearchButtonClick(_:)), for: .touchUpInside)
        return titleSearchButton
    }()
    
    private lazy var titleCollectionView: UICollectionView = {
        let layout = UICollectionViewFlowLayout()
        layout.scrollDirection = .horizontal
        let titleCollectionView = UICollectionView(frame: .zero, collectionViewLayout: layout)
        titleCollectionView.backgroundColor = UIColor.white
        titleCollectionView.delegate = self
        titleCollectionView.dataSource = self
        let nib = UINib(nibName: "YMVideoCollectionViewCell", bundle: nil)
        titleCollectionView.register(nib, forCellWithReuseIdentifier: videoCollectionViewCellID)
        titleCollectionView.showsHorizontalScrollIndicator = false
        return titleCollectionView
    }()
    
    @objc func titleSearchButtonClick(_ button: UIButton) {
        delegate?.titleView(self, titleSearchButton: button)
    }
    
    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
}

extension YMTitleView: UICollectionViewDelegate, UICollectionViewDataSource {
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: videoCollectionViewCellID, for: indexPath) as! YMVideoCollectionViewCell
        cell.titleLabel.text = "推荐"
        return cell
    }
    
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return 10
    }
    
    private func collectionView(collectionView: UICollectionView, didSelectItemAtIndexPath indexPath: NSIndexPath) {
        let cell = collectionView.cellForItem(at: indexPath as IndexPath) as! YMVideoCollectionViewCell
        cell.titleLabel.textColor = UIColor.red
    }
    
}
