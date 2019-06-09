//
//  ShengxiaoBigImageController.swift
//  MyTodayNews
//
//  Created by 林小興 on 2019/05/28.
//  Copyright © 2019 林小興. All rights reserved.
//

import UIKit
import IBAnimatable

class ShengxiaoBigImageController: AnimatableModalViewController, StoryboardLoadable {
    
    var shengxiao = Shengxiao()
    
    @IBOutlet weak var shengxiaoTitleLabel: UILabel!
    
    @IBOutlet weak var imageButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        shengxiaoTitleLabel.text = shengxiao.title
        imageButton.setImage(UIImage(named: shengxiao.big), for: .normal)
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
    /*
     // MARK: - Navigation
     
     // In a storyboard-based application, you will often want to do a little preparation before navigation
     override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
     // Get the new view controller using segue.destinationViewController.
     // Pass the selected object to the new view controller.
     }
     */
    
}
