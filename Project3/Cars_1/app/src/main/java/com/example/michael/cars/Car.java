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
            new Car("Huayra BC", R.drawable.bc)
    };

}

