package com.papillon.datatypes;

/**
 * Created by papillon on 5/8/2017.
 */
public class MyDate {

    private int date;
    private int month;
    private int year;
    private String locale;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
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

    @Override
    public String toString() {
        return String.format("My Date : date=%d , month=%d , year=%d", date,month,year);
    }
}
