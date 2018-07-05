package com.ziggy.coffriend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.ziggy.coffriend.R;
import com.ziggy.coffriend.adapter.CoffeeAdapter;
import com.ziggy.coffriend.model.CoffeeShop;

public class CreateHostActivity extends AppCompatActivity{
    private List<CoffeeShop> mListCoffee;
    private RecyclerView mRecycleViewCoffee;
    private CoffeeAdapter mAdapter;
    private EditText mEditSearch;
    private ImageView mImg;
    private static final int HIDE_TAG = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initialView();
    }
    private void initialView(){
        mRecycleViewCoffee = findViewById(R.id.recycleView_coffee);
        mRecycleViewCoffee.setHasFixedSize(true);
        mEditSearch = findViewById(R.id.edit_search);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecycleViewCoffee.setLayoutManager(mLayoutManager);
        mListCoffee = new ArrayList<>();
        mListCoffee.add(new CoffeeShop(R.drawable.coffee,R.drawable.location1,"Coffee House","810 Xô Viết Nghệ Tĩnh, Quận 3,Tp. Hồ Chí Minh"));
        mListCoffee.add(new CoffeeShop(R.drawable.coffee,R.drawable.location1,"Coffee House","910 Xô Viết Nghệ Tĩnh, Quận 3,Tp. Hồ Chí Minh"));
        mListCoffee.add(new CoffeeShop(R.drawable.coffee,R.drawable.location1,"Coffee House","990 Xô Viết Nghệ Tĩnh, Quận 3,Tp. Hồ Chí Minh"));
        mListCoffee.add(new CoffeeShop(R.drawable.coffee,R.drawable.location1,"Coffee House","150 Xô Viết Nghệ Tĩnh, Quận 3,Tp. Hồ Chí Minh"));
        mListCoffee.add(new CoffeeShop(R.drawable.coffee,R.drawable.location1,"Coffee House","270 Xô Viết Nghệ Tĩnh, Quận 3,Tp. Hồ Chí Minh"));
        setAdapter(mListCoffee);
    };

    private void setAdapter(List<CoffeeShop> coffeeList){
        if(mAdapter == null){
            mAdapter = new CoffeeAdapter(coffeeList);
            mRecycleViewCoffee.setAdapter(mAdapter);
            mAdapter.setOnItemClickListener(new CoffeeAdapter.OnItemClickListener() {
                @Override
                public void onItemClickListener(int position) {
                    Toast.makeText(CreateHostActivity.this,"You choose " + mListCoffee.get(position).getCoffeeAddress(), Toast.LENGTH_SHORT).show();
                }
            });
        } else{
            mAdapter.notifyDataSetChanged();
        }
    }

    public void gotoCalendar(View view) {
        Intent intent = new Intent(this,CalendarActivity.class);
        startActivity(intent);
    }
}
