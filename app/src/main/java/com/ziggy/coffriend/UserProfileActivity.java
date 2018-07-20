package com.ziggy.coffriend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.ziggy.coffriend.DB.DBUtils;

public class UserProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        if(!DBUtils.loadUsername(this).equals("vip")){
            ((LinearLayout) findViewById(R.id.llStatics)).setVisibility(View.GONE);
        }
    }


    public void clickBack(View view) {
        onBackPressed();

    }
}
