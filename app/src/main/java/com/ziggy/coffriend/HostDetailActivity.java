package com.ziggy.coffriend;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;

public class HostDetailActivity extends AppCompatActivity {

    private boolean state = false;
    private boolean goState = false;

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        final ScrollView sv = findViewById(R.id.svMain);
        sv.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                View last = sv.getChildAt(sv.getChildCount() - 1);
                int diff = (last.getBottom() - (sv.getHeight() + sv.getScrollY())) -  last.getPaddingBottom();

                if (diff <= 0) {
                    findViewById(R.id.arrowDown).setVisibility(View.INVISIBLE);
                } else {
                    findViewById(R.id.arrowDown).setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void clickBack(View view) {
        onBackPressed();
    }

    public void goToChat(View view) {
        Intent intent = new Intent(HostDetailActivity.this, ChatActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.host_detail_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.btnShare:
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra("Temp","Temp");
                startActivity(Intent.createChooser(shareIntent, "Share to"));
                break;
            case R.id.btnFavorite:
                if(!state){
                    item.setIcon(R.drawable.ic_menu_favorite);
                } else {
                    item.setIcon(R.drawable.ic_menu_unfavorite);
                }
                state = !state;
                break;
            case R.id.btnReport:
                Intent intent = new Intent(HostDetailActivity.this, ReportActivity.class);
                startActivity(intent);
                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clickGoing(View view) {
        Button btnGo = ((Button) findViewById(R.id.btnGo));
        if(!goState){
            btnGo.setText("Cancle Your Check");
            btnGo.setBackgroundResource(R.drawable.button_cancle_going_background);
        } else {
            btnGo.setText("you'll going");
            btnGo.setBackgroundResource(R.drawable.button_going_background);
        }

        goState = !goState;
    }

    public void goToProfile(View view) {
        Intent intent = new Intent(HostDetailActivity.this, UserProfileActivity.class);
        startActivity(intent);
    }
}
