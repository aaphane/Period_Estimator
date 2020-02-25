package com.period_estimator.Models;

public class UserInputModel {

    private int id;
    private String userName;
    private int day;
    private int month;
    private int year;

    //Alternatives
//    private int id;
//    private String userName;
//    private byte day;
//    private byte month;
//    private short year;


    public UserInputModel(int id, String userName, int day, int month, int year) {
        this.id = id;
        this.userName = userName;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
