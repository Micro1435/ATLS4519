//
//  HangBoardViewController.swift
//  IntervalTimer
//
//  Created by Michael Montella on 3/2/16.
//  Copyright © 2016 Michael Montella. All rights reserved.
//

import UIKit
import AudioToolbox

class HangBoardViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var timerLabel: UILabel!
    @IBOutlet weak var setNumberTextField: UITextField!
    
    var timer = NSTimer()
    var restTimer = NSTimer()
    var second = 0
    var reps = 0
    var currentRep = 0
    
    @IBAction func startTimer(sender: AnyObject) {
        if (Int(setNumberTextField.text!) != nil) {     // Checks if text field is not nil
            reps = Int(setNumberTextField.text!)!       // Set amount of reps
            startTimer()                                // Start timer
        } else {
            reps = 5
            startTimer()
        }
        
    }
    
    func startTimer() {     // Starts hang timer
        timer = NSTimer.scheduledTimerWithTimeInterval(1, target: self, selector: "countDown", userInfo: nil, repeats: true)
    }
    
    // TODO
    /*
    
    Make it look pretty
    Integrate vibration
    Make main screen look pretty
    Integrate option for user to set the time intervals 
        Use more text fields and variable instead to test if second is less than variable
    
*/

    func countDown() {
        timerLabel.textColor = UIColor.blackColor()     // Changes color to black
        if currentRep < reps {                          // Checks to make sure you haven't exceeded target reps
            if second < 10 {
                second++
                timerLabel.text = String(second)
            } else {    // If > 10 seconds, invalidate timer and start rest timer
                timer.invalidate()
                second = 0
                restTimer = NSTimer.scheduledTimerWithTimeInterval(1, target: self, selector: "restTime", userInfo: nil, repeats: true)
                currentRep++
                AudioServicesPlayAlertSound(SystemSoundID(kSystemSoundID_Vibrate))
            }
        } else {
            print("Over")
            timerLabel.text = "0"
            timer.invalidate()
        }
    }
    
    func restTime() {   // Starts rest timer
        if second < 5 {
            second++
            timerLabel.textColor = UIColor.redColor()   // Changes color to red to indicate rest
            timerLabel.text = String(second)
        } else {
            restTimer.invalidate()
            startTimer()
            second = 0
            AudioServicesPlayAlertSound(SystemSoundID(kSystemSoundID_Vibrate))
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.

        setNumberTextField.delegate = self
        let tap: UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: "dismissKeyboard")
        view.addGestureRecognizer(tap)
    }
    
    func dismissKeyboard() {    // Dismiss keyboard on tap
        view.endEditing(true)
    }
    
    func textFieldShouldReturn(textField: UITextField) -> Bool {    // Dismiss keyboard on tap of return
        setNumberTextField.resignFirstResponder()
        return true
    }


    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
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
