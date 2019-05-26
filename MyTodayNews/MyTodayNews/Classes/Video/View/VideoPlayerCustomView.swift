//
//  VideoPlayerCustomView.swift
//  MyTodayNews
//
//  Created by 林小興 on 2019/05/24.
//  Copyright © 2019 林小興. All rights reserved.
//

import BMPlayer
import SnapKit

class VideoPlayerCustomView: BMPlayerControlView {
    
    override func customizeUIComponents() {
        BMPlayerConf.topBarShowInCase = .none
    }
}
