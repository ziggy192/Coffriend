package com.ziggy.coffriend;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.ziggy.coffriend.adapters.HomeEventsAdapter;
import com.ziggy.coffriend.adapters.TopicAdapter;
import com.ziggy.coffriend.adapters.TopicNodeAdapter;
import com.ziggy.coffriend.holders.TopicHolder;
import com.ziggy.coffriend.holders.TopicNodeHolder;
import com.ziggy.coffriend.model.EventModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.rvEvents)
    RecyclerView rvEvents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_screen);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Search");
    }

    public void clickBack(View view) {
        onBackPressed();
    }

    public void showTimeDialog(View view) {
        DatePickerDialog.OnDateSetListener callback=new DatePickerDialog.OnDateSetListener(){
            public void onDateSet(DatePicker view, int year,
                                  int monthOfYear,
                                  int dayOfMonth) {
                ((TextView) findViewById(R.id.txtDate)).setText(dayOfMonth + "/" + monthOfYear + "/" + year);
            }
        };
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(SearchActivity.this, callback, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    public void showTimeToDialog(View view) {
        DatePickerDialog.OnDateSetListener callback=new DatePickerDialog.OnDateSetListener(){
            public void onDateSet(DatePicker view, int year,
                                  int monthOfYear,
                                  int dayOfMonth) {
                ((TextView) findViewById(R.id.txtDateTo)).setText(dayOfMonth + "/" + monthOfYear + "/" + year);
            }
        };
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(SearchActivity.this, callback, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    public void findLocation(View view) {
    }

    public void showResult(View view) {
        rvEvents.setVisibility(View.VISIBLE);
        List<EventModel> eventModels = new ArrayList<>();
        eventModels.add(new EventModel(false));
        eventModels.add(new EventModel(false));
        eventModels.add(new EventModel(false));
        eventModels.add(new EventModel(false));

        HomeEventsAdapter adapter = new HomeEventsAdapter(eventModels);
        rvEvents.setAdapter(adapter);
        rvEvents.setLayoutManager(new LinearLayoutManager(this));
    }
}
