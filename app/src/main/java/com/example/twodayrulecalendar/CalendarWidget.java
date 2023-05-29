package com.example.twodayrulecalendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CalendarWidget extends View {
    TwoDayRuleCalendar calendar;

    public CalendarWidget(Context context) {
        super(context);
        calendar = TwoDayRuleCalendarFactory.getCalendar(context);
    }

    public CalendarWidget(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        calendar = TwoDayRuleCalendarFactory.getCalendar(context);
    }

    public CalendarWidget(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        calendar = TwoDayRuleCalendarFactory.getCalendar(context);
    }
}
