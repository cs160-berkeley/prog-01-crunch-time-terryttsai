package com.terrytsai.caloriecalculator;

/**
 * Created by Terry T. Tsai on 1/29/2016.
 */
public class Exercise {
    private String exerciseName;
    private String shortName;
    private String exerciseType;
    private double conversionRate; //1 cal * conversionRate = this many reps/mins

    public Exercise(String exerciseName, String shortName, String exerciseType, double conversionRate) {
        this.exerciseName = exerciseName;
        this.shortName = shortName;
        this.exerciseType = exerciseType;
        this.conversionRate = conversionRate;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public double getRepsFromCalories(double calories) {
        return calories * this.conversionRate;
    }

    public double getCaloriesFromReps(double reps) {
        return reps / this.conversionRate;
    }

    public String getExerciseType() {
        return this.exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }


    @Override
    public String toString() {
        return this.exerciseName + " (Conversion rate = " + this.conversionRate + ")";
    }
}
