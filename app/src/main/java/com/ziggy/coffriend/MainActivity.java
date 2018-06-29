package com.ziggy.coffriend;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.ziggy.coffriend.R;
import com.ziggy.coffriend.adapter.CoffeeAdapter;
import com.ziggy.coffriend.model.CoffeeShop;

public class MainActivity extends AppCompatActivity {

    private List<CoffeeShop> mListCoffee;
    private RecyclerView mRecycleViewCoffee;
    private CoffeeAdapter mAdapter;
    private ImageView mImg;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        },2000);
    }

    private void initialView(){
        mRecycleViewCoffee = findViewById(R.id.recycleView_coffee);
        mRecycleViewCoffee.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecycleViewCoffee.setLayoutManager(mLayoutManager);
        mListCoffee = new ArrayList<>();
        mListCoffee.add(new CoffeeShop(R.mipmap.coffee,R.mipmap.location1,"Coffee House","810 Xô Viết Nghệ Tĩnh, Quận 3,Tp. Hồ Chí Minh"));
        mListCoffee.add(new CoffeeShop(R.mipmap.coffee,R.mipmap.location1,"Coffee House","910 Xô Viết Nghệ Tĩnh, Quận 3,Tp. Hồ Chí Minh"));
        mListCoffee.add(new CoffeeShop(R.mipmap.coffee,R.mipmap.location1,"Coffee House","990 Xô Viết Nghệ Tĩnh, Quận 3,Tp. Hồ Chí Minh"));
        mListCoffee.add(new CoffeeShop(R.mipmap.coffee,R.mipmap.location1,"Coffee House","150 Xô Viết Nghệ Tĩnh, Quận 3,Tp. Hồ Chí Minh"));
        mListCoffee.add(new CoffeeShop(R.mipmap.coffee,R.mipmap.location1,"Coffee House","270 Xô Viết Nghệ Tĩnh, Quận 3,Tp. Hồ Chí Minh"));
        setAdapter(mListCoffee);
    };

    private void setAdapter(List<CoffeeShop> coffeeList){
        if(mAdapter == null){
            mAdapter = new CoffeeAdapter(coffeeList);
            Log.e("size", coffeeList.size() + "");
            mRecycleViewCoffee.setAdapter(mAdapter);
            mAdapter.setOnItemClickListener(new CoffeeAdapter.OnItemClickListener() {
                @Override
                public void onItemClickListener(int position) {
                      Toast.makeText(MainActivity.this,"You choose " + mListCoffee.get(position).getCoffeeAddress(), Toast.LENGTH_SHORT).show();
                }
            });
        } else{
            mAdapter.notifyDataSetChanged();
        }
    }
}
