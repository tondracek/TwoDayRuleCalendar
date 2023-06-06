package com.example.twodayrulecalendar.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.twodayrulecalendar.TwoDayRuleCalendar;

public class TwoDayRuleCalendarView extends View implements CalendarView {
    private TwoDayRuleCalendar twoDayRuleCalendar;

    public TwoDayRuleCalendarView(Context context) {
        super(context);
    }

    public TwoDayRuleCalendarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TwoDayRuleCalendarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init(TwoDayRuleCalendar twoDayRuleCalendar, Context context) {
        this.twoDayRuleCalendar = twoDayRuleCalendar;

        updateLayout();
    }

    public void updateLayout() {

    }

    public TwoDayRuleCalendar getTwoDayRuleCalendar() {
        return twoDayRuleCalendar;
    }
}
