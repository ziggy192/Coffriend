package com.ziggy.coffriend;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ziggy.coffriend.adapters.ChatListAdapter;
import com.ziggy.coffriend.adapters.OnlineChatListAdapter;
import com.ziggy.coffriend.holders.ChatSimpleHolder;

import java.nio.file.Files;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ChatListActivity extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        List<ChatSimpleHolder> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(new ChatSimpleHolder(0, R.drawable.profile, R.drawable.profile, "Eric Bachman", "Hello !!!", new Date(118, 7, 20), false));
            list.add(new ChatSimpleHolder(0, R.drawable.profile, R.drawable.profile, "Eric Bachman", "Hello !!!", new Date(118, 7, 20), true));
        }

        ChatListAdapter adapter = new ChatListAdapter(list, this);

        ListView lv = findViewById(R.id.lvChat);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ChatListActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

        ActionBar actionBar = getSupportActionBar();

        Drawable btnBack = getResources().getDrawable(R.drawable.ic_back_dark_brown);
        getSupportActionBar().setHomeAsUpIndicator(btnBack);

        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        //------------------------------------------------------------------------------------------------
//        OnlineChatListAdapter onlineAdapter = new OnlineChatListAdapter(list,this);
//
//        ListView online = findViewById(R.id.lvChatOnline);
//        online.setAdapter(onlineAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
