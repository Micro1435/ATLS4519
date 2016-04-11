//
//  AddViewController.swift
//  Recipes
//
//  Created by Michael Montella on 3/17/16.
//  Copyright © 2016 Michael Montella. All rights reserved.
//

import UIKit

class AddViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var recipeName: UITextField!
    @IBOutlet weak var recipeURL: UITextField!
    
    var addedRecipe = String()
    var addedURL = String()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        recipeName.delegate = self
        recipeURL.delegate = self
        // Do any additional setup after loading the view.
    }

    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        if segue.identifier == "saveSegue" {
            if recipeName.text?.isEmpty == false {
                addedRecipe = recipeName.text!
                addedURL = recipeURL.text!
            }
        }
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // Retract Keyboard
    func textFieldShouldReturn(textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
