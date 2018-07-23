package com.ziggy.coffriend;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.ziggy.coffriend.DB.DBUtils;
import com.ziggy.coffriend.R;

public class CalendarActivity extends AppCompatActivity {
    private CompactCalendarView compactCalendar;
    private Button mButtonNext;
    private TextView mTextViewDate;
    private TextView tvStartTime;
    private TextView tvEndTime;
    private int currentStartHour;
    private int currentStartMinute;
    private int currentEndHour;
    private int currentEndMinute;
    private Date currentDate = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        initialView();
        currentStartHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        currentEndHour = currentStartHour+1;
        currentStartMinute = Calendar.getInstance().get(Calendar.MINUTE);
        currentEndMinute = 0;
        tvStartTime.setText(formatHour(currentStartHour,currentStartMinute));
        tvEndTime.setText(formatHour(currentEndHour,currentEndMinute));

    }

    private void initialView() {
        compactCalendar = findViewById(R.id.calendar_view);
        mTextViewDate = findViewById(R.id.text_day);

        tvStartTime = findViewById(R.id.tvStartTime);
        tvEndTime = findViewById(R.id.tvEndTime);
        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                String[] words = (dateClicked.toString()).split(" ", 6);
                mTextViewDate.setText(words[0] + " " + words[1] + " " + words[2]);
                currentDate = dateClicked;
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {

            }
        });
    }

    public void gotoFinish(View view) {
        DBUtils.saveKey(this, "date", sdf.format(currentDate));
        DBUtils.saveKey(this, "start",formatHour(currentStartHour, currentStartMinute));
        DBUtils.saveKey(this, "end",formatHour(currentEndHour, currentEndMinute));
        Intent intent = new Intent(this,FinishActivity.class);
        startActivity(intent);
    }

    public void onPickStartTime(View view) {
        pickStartTime();
    }

    public void onPickEndTime(View view) {
        pickEndTime();
    }

    public void pickStartTime() {
        TimePickerDialog dialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        tvStartTime.setText(formatHour(i,i1));
                        currentStartHour = i;
                        currentStartMinute = i1;
                    }
                }
                ,currentStartHour
                ,currentStartMinute
                ,false
        );
        dialog.show();
    }

    private String formatHour(int hourOfDay,int minute) {
        String am = "AM";
        if (hourOfDay > 12 || (hourOfDay==12 && minute>0)) {
            am = "PM";
            hourOfDay -= 12;
        }
        return String.format("%02d:%02d%s", hourOfDay, minute, am);

    }
    public void pickEndTime() {
        TimePickerDialog dialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {

                        tvEndTime.setText(formatHour(i,i1));
                        currentEndHour = i;
                        currentEndMinute = i1;
                    }
                }
                ,currentEndHour
                ,currentEndMinute
                ,false
        );
        dialog.show();
    }
}
