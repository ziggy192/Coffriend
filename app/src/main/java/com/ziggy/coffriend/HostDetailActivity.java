package com.ziggy.coffriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HostDetailActivity extends AppCompatActivity {

    private boolean state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_detail);
    }

    public void clickFollow(View view) {
        if (state){
            ((Button) this.findViewById(R.id.btnFollow)).setText("Follow");
            state = false;
        } else {
            ((Button) this.findViewById(R.id.btnFollow)).setText("Followed");
            state = true;
        }
    }

    public void clickBack(View view) {
        onBackPressed();
    }

    public void goToChat(View view) {
        Intent intent = new Intent(HostDetailActivity.this, ChatActivity.class);
        startActivity(intent);
    }
}
