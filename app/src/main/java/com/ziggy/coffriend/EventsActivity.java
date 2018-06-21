package com.ziggy.coffriend;

import android.support.design.bottomappbar.BottomAppBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EventsActivity extends AppCompatActivity {

    BottomAppBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        bar = findViewById(R.id.bar);

        setSupportActionBar(bar);
    }

}
