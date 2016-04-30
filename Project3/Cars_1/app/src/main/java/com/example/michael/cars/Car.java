package com.example.michael.cars;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Michael on 4/30/16.
 */


public class Car {
    private String make;
    private int imageResourceID;

    private Car(String newMake, int newId) {
        this.make = newMake;
        this.imageResourceID = newId;
    }

    public static final Car[] cars = {
            new Car("P1", R.drawable.p1),
            new Car("LaFerrari", R.drawable.laferrari),
            new Car("918", R.drawable.porsche),
            new Car("675LT", R.drawable.lt),
            new Car("Huayra BC", R.drawable.bc)
    };

    public String getMake() {
        return make;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public String toString() {
        return this.make;
    }
}

