package com.example.twodayrulecalendar;

import android.view.View;

import java.io.Serializable;
import java.time.Month;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Week implements Serializable {
    private final Day[] daysInWeek;
    private final Set<Month> months = new HashSet<>(2);
    private final Set<Integer> years = new HashSet<>(2);

    public Week(Day[] daysInWeek) {
        this.daysInWeek = daysInWeek;

        for (Day day : daysInWeek) {
            months.add(day.getMonth());
            years.add(day.getYear());
        }
    }

    public boolean isActual() {
        Month actualMonth = Month.of(Calendar.getInstance().get(Calendar.MONTH));
        Integer actualYear = Calendar.getInstance().get(Calendar.YEAR);

        return years.contains(actualYear) && months.contains(actualMonth);
    }

    public Day[] getDaysInWeek() {
        return daysInWeek;
    }
}
