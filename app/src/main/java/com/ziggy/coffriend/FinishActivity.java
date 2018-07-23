package com.ziggy.coffriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ziggy.coffriend.DB.DBUtils;

public class FinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
    }

    public void gotoAppBase(View view) {
        DBUtils.saveKey(this,"title", String.valueOf(((TextView) findViewById(R.id.txt_title)).getText()));
        DBUtils.saveKey(this,"content", String.valueOf(((TextView) findViewById(R.id.txt_content)).getText()));
        Intent intent = new Intent(this,EditHostActivity.class);
        startActivity(intent);
    }
}
