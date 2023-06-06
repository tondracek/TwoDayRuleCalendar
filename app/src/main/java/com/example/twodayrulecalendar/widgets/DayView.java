package com.example.twodayrulecalendar.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.twodayrulecalendar.Day;
import com.example.twodayrulecalendar.R;

public class DayView extends View implements View.OnTouchListener {
    private Day day;

    public DayView(Context context) {
        super(context);
    }

    public DayView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DayView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    void init(Day day, Context context) {
        this.day = day;

        inflate(context, R.layout.day_layout, null);
        setOnTouchListener(this);

        updateLayout();
    }

    public void updateLayout() {
        TextView number = findViewById(R.id.day_text);
        number.setText(day.getDay());

        setBackgroundColor(day.isChecked() ? Color.GREEN : Color.WHITE);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            day.switchChecked();
        }

        return true;
    }
}
