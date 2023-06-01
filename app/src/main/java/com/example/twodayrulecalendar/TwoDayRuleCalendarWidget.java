package com.example.twodayrulecalendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class TwoDayRuleCalendarWidget extends View {
    TwoDayRuleCalendar calendar;

    public TwoDayRuleCalendarWidget(Context context) {
        super(context);
    }

    public TwoDayRuleCalendarWidget(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TwoDayRuleCalendarWidget(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
