package com.ziggy.coffriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.ziggy.coffriend.adapters.TopicAdapter;
import com.ziggy.coffriend.holders.TopicHolder;
import com.ziggy.coffriend.holders.TopicNodeHolder;

import java.util.ArrayList;
import java.util.List;

public class ChoiceInterestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_interest);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.choice_topic_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.btnNext:
                Intent intent = new Intent(ChoiceInterestActivity.this, AppBaseActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void init(){
        List<TopicHolder> list = new ArrayList<>();

        List<TopicNodeHolder> listArt = new ArrayList<>();
        listArt.add(new TopicNodeHolder(R.drawable.art, "Art"));
        listArt.add(new TopicNodeHolder(R.drawable.film, "Film"));
        listArt.add(new TopicNodeHolder(R.drawable.gaming, "Gaming"));
        listArt.add(new TopicNodeHolder(R.drawable.social_media, "Social Media"));
        listArt.add(new TopicNodeHolder(R.drawable.sports, "Sports"));
        TopicHolder art = new TopicHolder("Art & Entertainment" , listArt);

        list.add(art);

        List<TopicNodeHolder> listInnovation = new ArrayList<>();
        listInnovation.add(new TopicNodeHolder(R.drawable.ai, "Artificial Intelligence"));
        listInnovation.add(new TopicNodeHolder(R.drawable.data_science, "Data Science"));
        listInnovation.add(new TopicNodeHolder(R.drawable.math, "Math"));
        listInnovation.add(new TopicNodeHolder(R.drawable.programming, "Programming"));
        listInnovation.add(new TopicNodeHolder(R.drawable.technology, "Technology"));
        TopicHolder innovation = new TopicHolder("Innovation & Tech" , listInnovation);

        list.add(innovation);

        TopicAdapter adapter = new TopicAdapter(this, list);

        ((ListView) findViewById(R.id.lvTopics)).setAdapter(adapter);
    }
}
