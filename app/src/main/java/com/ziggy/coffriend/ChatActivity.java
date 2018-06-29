package com.ziggy.coffriend;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

    }

    public void clickBack(View view) {
        onBackPressed();
    }

    public void sendMessage(View view) {
        EditText edt = (EditText) findViewById(R.id.edtMess);
        String text = String.valueOf(edt.getText());
        LinearLayout sv = findViewById(R.id.chatMessBody);
        if(text.indexOf("fuck") > -1){
            sv.addView(createMessageBox("Bad word",true));
        } else {
            sv.addView(createMessageBox(text,false));
        }
        edt.setText("");
    }

    private RelativeLayout createMessageBox(String text, boolean isError){
        RelativeLayout layout = new RelativeLayout(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(0,5,0,5);
        layout.setLayoutParams(params);

        TextView tv = new TextView(this);
        params.setMargins(0,0,0,0);
        params.addRule(RelativeLayout.ALIGN_PARENT_END);
        tv.setLayoutParams(params);
        tv.setBackgroundResource(R.drawable.chat_border_2);
        tv.setPadding(10,10,10,10);
        if(isError){
            tv.setTextColor(Color.RED);
        } else{
            tv.setTextColor(Color.parseColor("#795548"));
        }
        tv.setTextSize(20);
        tv.setText(text);
        layout.addView(tv);

        return layout;
    }
}
