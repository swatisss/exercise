//
//  ViewController.swift
//  MyFirstApp
//
//  Created by blue210 on 2015/04/25.
//  Copyright (c) 2015年 blue210. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var myLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    @IBAction func tapButton(sender: UIButton) {
        self.myLabel.text = "Hello, World!"
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

