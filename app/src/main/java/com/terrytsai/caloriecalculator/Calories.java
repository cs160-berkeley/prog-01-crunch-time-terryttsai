package com.terrytsai.caloriecalculator;

import android.util.Log;

/**
 * Created by Terry T. Tsai on 1/31/2016.
 */
public class Calories {
    private double cal;

    public Calories(double cal) {
        this.cal = cal;
    }

    public double getCalories() {
        return cal;
    }

    public void setCalories(String cal) {
        try {
            this.cal = Double.parseDouble(cal);
        } catch(Exception e) {
            Log.d("setCalories", e.toString());
            this.cal = 0;
        }
    }

    @Override
    public String toString() {
        return ("" + this.cal);
    }

}
