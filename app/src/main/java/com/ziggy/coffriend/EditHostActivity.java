package com.ziggy.coffriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.ziggy.coffriend.DB.DBUtils;
import com.ziggy.coffriend.holders.HostHolder;

import java.text.SimpleDateFormat;

public class EditHostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_host);

        HostHolder holder = DBUtils.loadHost(this);
        ((ImageView) findViewById(R.id.imgDetail)).setImageBitmap(holder.getImage());
        ((TextView) findViewById(R.id.title_detail)).setText(holder.getTitle());
        ((TextView) findViewById(R.id.title_content)).setText(holder.getContent());
        ((TextView) findViewById(R.id.title_date)).setText((new SimpleDateFormat("E, dd/MM/yyyy")).format(holder.getDate()));
        ((TextView) findViewById(R.id.title_time)).setText(holder.getTimeStart() + " - " + holder.getTimeEnd());
        ((TextView) findViewById(R.id.title_name_address)).setText(holder.getTitlePlace());
        ((TextView) findViewById(R.id.title_address)).setText(holder.getAddressPlace());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edit_host_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.btnNext:
                Intent intent = new Intent(EditHostActivity.this, AppBaseActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
