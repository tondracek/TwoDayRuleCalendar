package com.example.twodayrulecalendar;

import java.time.LocalDate;
import java.time.Month;

public class Day implements Comparable<Day> {
    private final LocalDate date;
    private boolean checked = false;

    public Day(LocalDate date) {
        this.date = date;
    }

    public boolean isChecked() {
        return checked;
    }

    public void switchChecked() {
        checked = !checked;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getDay() {
        return date.getDayOfMonth();
    }

    public Month getMonth() {
        return date.getMonth();
    }

    public int getYear() {
        return date.getYear();
    }

    @Override
    public int compareTo(Day day) {
        return getDate().compareTo(day.getDate());
    }


}
