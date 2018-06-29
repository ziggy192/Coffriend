package com.ziggy.coffriend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;

import java.util.Date;

import com.ziggy.coffriend.R;

public class CalendarActivity extends AppCompatActivity {
    private CompactCalendarView compactCalendar;
    private Button mButtonNext;
    private TextView mTextViewDate;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        initialView();
    }

    private void initialView() {
        compactCalendar = findViewById(R.id.calendar_view);
        mTextViewDate = findViewById(R.id.text_day);
        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                String[] words = (dateClicked.toString()).split(" ", 6);
                mTextViewDate.setText(words[0] + " " + words[1] + " " + words[2]);
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {

            }
        });
    }
}
