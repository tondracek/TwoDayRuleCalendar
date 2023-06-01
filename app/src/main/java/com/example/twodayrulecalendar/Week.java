package com.example.twodayrulecalendar;

import java.io.Serializable;

public class Week implements Serializable {
    Day[] daysInWeek;
    int month;
    int year;

    public Week(Day[] daysInWeek, int month, int year) {
        this.daysInWeek = daysInWeek;
        this.month = month;
        this.year = year;
    }
}
