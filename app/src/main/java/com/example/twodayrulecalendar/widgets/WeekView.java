package com.example.twodayrulecalendar.widgets;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.twodayrulecalendar.Day;
import com.example.twodayrulecalendar.R;
import com.example.twodayrulecalendar.Week;


public class WeekView extends View {
    private Week week;
    private final DayView[] dayViews = new DayView[7];

    public WeekView(Context context) {
        super(context);
    }

    public WeekView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WeekView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    void init(Week week, Context context) {
        this.week = week;

        inflate(context, R.layout.week_layout, null);

        LinearLayout daysLayout = findViewById(R.id.weeks_days_layout);
        for (int i = 0; i < daysLayout.getChildCount(); i++) {
            DayView dayView = (DayView) daysLayout.getChildAt(i);
            dayViews[i] = dayView;
        }

        for (int i = 0; i < dayViews.length; i++) {
            Day day = week.getDaysInWeek()[i];
            dayViews[i].init(day, context);
        }

        updateLayout();
    }

    private void updateLayout() {
        for (DayView dayView : dayViews) {
            dayView.updateLayout();
        }
    }
}
