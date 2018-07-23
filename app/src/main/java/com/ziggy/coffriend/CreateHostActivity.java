package com.ziggy.coffriend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.animation.AnimationUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.ziggy.coffriend.DB.DBUtils;
import com.ziggy.coffriend.R;
import com.ziggy.coffriend.adapter.CoffeeAdapter;
import com.ziggy.coffriend.model.CoffeeShop;

public class CreateHostActivity extends AppCompatActivity{
    private static final String TAG = CreateHostActivity.class.toString();

    private List<CoffeeShop> mListCoffee;
    private RecyclerView mRecycleViewCoffee;
    private CoffeeAdapter mAdapter;
    private ImageView mImg;
    private static final int HIDE_TAG = 0;
    FloatingSearchView searhView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initialView();
    }
    private void initialView(){
        searhView = findViewById(R.id.floating_search_view);

        mRecycleViewCoffee = findViewById(R.id.recycleView_coffee);
        mRecycleViewCoffee.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

        mRecycleViewCoffee.setLayoutManager(mLayoutManager);
        mListCoffee = new ArrayList<>();
        mListCoffee.add(new CoffeeShop(R.drawable.coffee,R.drawable.location1,"Coffee House","810 Xô Viết Nghệ Tĩnh, Quận 3,Tp. Hồ Chí Minh"));
        mListCoffee.add(new CoffeeShop(R.drawable.starbuck,R.drawable.location1,"Starbuck Coffee","110 Lê Văn Sỹ, Quận 12,Tp. Hồ Chí Minh"));
        mListCoffee.add(new CoffeeShop(R.drawable.review_trung_nguyen,R.drawable.location1,"Trung Nguyen House","9 Trần Hưng Đạo, Phường 9, Quận 11,Tp. Hồ Chí Minh"));
        mListCoffee.add(new CoffeeShop(R.drawable.coffee_house,R.drawable.location1,"The Coffee House","12 Vũ Văn Dũng, p 11, Quận 3,Tp. Hồ Chí Minh"));
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
                    DBUtils.saveKey(CreateHostActivity.this, "name_address", mListCoffee.get(position).getCoffeeName());
                    DBUtils.saveKey(CreateHostActivity.this, "address", mListCoffee.get(position).getCoffeeAddress());

                    Intent intent = new Intent(CreateHostActivity.this, CalendarActivity.class);
                    startActivity(intent);
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
