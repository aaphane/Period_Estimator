package com.periodestimator.PEstimator;

public class Input {

    String name ;
    int year;
    int startDate;
    int monthNum;
    int periodLength;
    int cycleLength;

    public String getName() {
        return name;   
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;   
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStartDate() {
        return startDate;        
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getMonthNum() {
        return monthNum;
    }

    public void setMonthNum(int monthNum) {
        this.monthNum = monthNum;
    }

    public int getPeriodLength(){
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