package com.ziggy.coffriend;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.ziggy.coffriend.DB.DBUtils;
import com.ziggy.coffriend.adapters.TopicAdapter;
import com.ziggy.coffriend.adapters.TopicNodeAdapter;
import com.ziggy.coffriend.holders.TopicHolder;
import com.ziggy.coffriend.holders.TopicNodeHolder;

import java.util.ArrayList;
import java.util.List;

public class CreateHostTopicActivity extends AppCompatActivity {

    private List<TopicNodeHolder> listArt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_host_topic);
        init();
    }

    private void init(){
        List<TopicHolder> list = new ArrayList<>();

        listArt = new ArrayList<>();
        listArt.add(new TopicNodeHolder(R.drawable.ai, "Artificial Intelligence"));
        listArt.add(new TopicNodeHolder(R.drawable.art, "Art"));
        listArt.add(new TopicNodeHolder(R.drawable.data_science, "Data Science"));
        listArt.add(new TopicNodeHolder(R.drawable.film, "Film"));
        listArt.add(new TopicNodeHolder(R.drawable.gaming, "Gaming"));
        listArt.add(new TopicNodeHolder(R.drawable.math, "Math"));
        listArt.add(new TopicNodeHolder(R.drawable.programming, "Programming"));
        listArt.add(new TopicNodeHolder(R.drawable.social_media, "Social Media"));
        listArt.add(new TopicNodeHolder(R.drawable.sports, "Sports"));
        listArt.add(new TopicNodeHolder(R.drawable.technology, "Technology"));
        TopicHolder innovation = new TopicHolder("" , listArt);

        list.add(innovation);

        final Activity activity = this;

        TopicAdapter adapter = new TopicAdapter(this, list){
            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                LayoutInflater inflater = activity.getLayoutInflater();
                view = inflater.inflate(R.layout.item_list_topic_simple, null);

                TopicHolder holder = (TopicHolder) getItem(i);

                List<TopicNodeHolder> listTopics = holder.getList();

                TopicNodeAdapter adapter = new TopicNodeAdapter(activity, listTopics);
                final GridView gv = view.findViewById(R.id.gvTopics);
                gv.setAdapter(adapter);

                return view;
            }
        };

        ((ListView) findViewById(R.id.lvTopics)).setAdapter(adapter);
    }

    public void gotoPlace(View view) {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < listArt.size(); i++){
            TopicNodeHolder holder = listArt.get(i);
            if(holder.isCheck()){
                s.append(holder.getTitle() + ";");
            }
        }

        DBUtils.saveKey(this, "interest", s.toString());

        Intent intent = new Intent(CreateHostTopicActivity.this, CreateHostImageActivity.class);
        startActivity(intent);
    }
}
