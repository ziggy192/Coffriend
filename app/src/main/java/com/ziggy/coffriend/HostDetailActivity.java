package com.ziggy.coffriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HostDetailActivity extends AppCompatActivity {

    private boolean state = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
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
}
