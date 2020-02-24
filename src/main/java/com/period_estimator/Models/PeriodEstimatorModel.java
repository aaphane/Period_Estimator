package com.period_estimator.Models;

public class PeriodEstimatorModel {
    private int userID;
    private int year;
    private int month;
    private int day;
    private int periodLength;
    private int cycleLength;
    //more variables to follow

    public PeriodEstimatorModel() {
    }

    public PeriodEstimatorModel(int userID, int year, int month, int day, int periodLength, int cycleLength) {
        this.userID = userID;
        this.year = year;
        this.month = month;
        this.day = day;
        this.periodLength = periodLength;
        this.cycleLength = cycleLength;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getPeriodLength() {
        return periodLength;
    }

    public void setPeriodLength(int periodLength) {
        this.periodLength = periodLength;
    }

    public int getCycleLength() {
        return cycleLength;
    }

    public void setCycleLength(int cycleLength) {
        this.cycleLength = cycleLength;
    }
}
