//: Playground - noun: a place where people can play

import UIKit

var str = "Hello, playground"

var seconds = 520

var minutes = 0
var seconds2 = 0

if seconds % 60 == 0 {
    minutes = seconds / 60
} else {
    minutes = seconds / 60
    seconds2 = seconds - (minutes * 60)
}

print(\(minutes) : \(seconds2))