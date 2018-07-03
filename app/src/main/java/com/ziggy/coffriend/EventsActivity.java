package com.ziggy.coffriend;

import android.content.Intent;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class EventsActivity extends AppBaseActivity {

    private static final String TAG = EventsActivity.class.toString();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_content);
//        bar = findViewById(R.id.bar);
//
//        setSupportActionBar(bar);




    }

    @Override
    protected void onStart() {
        super.onStart();
//        Intent intent = new Intent(this, UserProfileActivity.class);
//        startActivity(intent);
//        Intent intent = new Intent(this, HistoryDetailActivity.class);
//        startActivity(intent);
    }

    public void gotoHostDetail(View view){
        Intent intent = new Intent(EventsActivity.this, HostDetailActivity.class);
        startActivity(intent);
    }


}
