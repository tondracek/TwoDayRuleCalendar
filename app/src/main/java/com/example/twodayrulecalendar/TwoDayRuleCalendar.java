package com.example.twodayrulecalendar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TwoDayRuleCalendar implements Serializable {
    private final List<Day> DaysInMonth = new ArrayList<>();
    private final int month;

    public TwoDayRuleCalendar() {
        month = Calendar.getInstance().get(Calendar.MONTH);
    }

    public boolean isActual() {
        int actualMonth = Calendar.getInstance().get(Calendar.MONTH);
        return month == actualMonth;
    }
}
