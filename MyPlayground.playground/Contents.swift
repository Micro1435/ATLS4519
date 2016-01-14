//: Playground - noun: a place where people can play

import UIKit

var score : Int?
print("Score is \(score)")
score = 80
if score != nil {
    print("The score is \(score!)")
}

if let currentScore = score {
    print("My current score is \(currentScore)")
}

let newScore : Int! = 95
print("My new score is \(newScore)")

func sayHello (first: String, last: String) {
    print("Hi \(first) \(last)")
}

sayHello("Michael", last: "Montella")

func sayWhy (firstName first: String, lastName last: String) -> String {
    return "Why " + first + " " + last + "?"
}

let msg = sayWhy(firstName: "Jane", lastName: "Adams")
print(msg)



let group = ["Abed", "Jeff", "Troy", "Annie", "Britta"]
func backwards(s1: String, _ s2: String) -> Bool {
    return s1 > s2
}
var reversed = group.sort(backwards)

// using a closure
reversed = group.sort({(s1: String, s2: String) -> Bool in
    return s1 > s2})
print(reversed)



enum carType {
    case hypercar
    case supercar
    case racecar
}

var car = carType.hypercar
car = .supercar






class Pet {
    var name: String
    init(name: String) {
        self.name = name
    }
}

class Dog : Pet {
    var breed: String
    init(name: String, breed: String) {
        self.breed = breed
        super.init(name: name)
    }
}

class Fish : Pet {
    var species: String
    init(name: String, species: String) {
        self.species = species
        super.init(name: name)
    }
}

let myPets = [Dog(name: "Bagel", breed: "Beagle"),
    Dog(name: "Misty", breed: "Jack Russel"),
    Fish(name: "Nemo", species: "Clown Fish"),
    Dog(name: "Noodle", breed: "Shnauzer")]

var dogCount = 0
var fishCount = 0

for pet in myPets {
    if pet is Dog {
        dogCount++
    } else if pet is Fish {
        fishCount++
    }
}

print("I have \(dogCount) dogs and \(fishCount) fish")

for pet in myPets {
    if let dog = pet as? Dog {
        print("\(dog.name) is a \(dog.breed)")
    } else if let fish = pet as? Fish {
        print("\(fish.name) is a \(fish.species)")
    }
}






