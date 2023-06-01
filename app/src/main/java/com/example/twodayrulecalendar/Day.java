package com.example.twodayrulecalendar;

import java.util.Date;

public class Day {
    private final Date date;
    private boolean checked = false;

    public Day(Date date) {
        this.date = date;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Date getDate() {
        return date;
    }
}
