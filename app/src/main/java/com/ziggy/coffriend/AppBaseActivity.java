package com.ziggy.coffriend;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Objects;

public class AppBaseActivity extends AppCompatActivity implements MenuBottomSheetDialogFragment.Listener{


    private static final String TAG = AppBaseActivity.class.toString();

    private BottomAppBar appBar;
    private MenuBottomSheetDialogFragment bottomSheetDialogFragment;

    private FrameLayout view_stub; //This is the framelayout to keep your content view


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_app_base);// The base layout that contains your navigation drawer.
        view_stub = findViewById(R.id.view_stub);
//        appBar = findViewById(R.id.bar);
//        bottomSheetDialogFragment = new MenuBottomSheetDialogFragment();
//        bottomSheetLayout = findViewById(R.id.bottomSheet);
//        sheetBehavior = BottomSheetBehavior.from(bottomSheetLayout);

//        navigation_view = (NavigationView) findViewById(R.id.navigation_view);
//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, 0, 0);
//        mDrawerLayout.setDrawerListener(mDrawerToggle);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
//        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

//        appBar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG, "onClick: appbarclicked");
////                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//
////                bottomSheetDialogFragment.show
//                bottomSheetDialogFragment.showNow(getSupportFragmentManager(),bottomSheetDialogFragment.getTag());
//            }
//        });


        //todo set menuitemclick event here
//        drawerMenu = navigation_view.getMenu();
//        for(int i = 0; i < drawerMenu.size(); i++) {
//            drawerMenu.getItem(i).setOnMenuItemClickListener(this);
//        }
        // and so on...
        appBar = findViewById(R.id.bar);
        bottomSheetDialogFragment = new MenuBottomSheetDialogFragment();
        appBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: appbarclicked");
//                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

//                bottomSheetDialogFragment.show
                bottomSheetDialogFragment.show(getSupportFragmentManager(),bottomSheetDialogFragment.getTag());
            }
        });



    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
//        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
//        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    /* Override all setContentView methods to put the content view to the FrameLayout view_stub
     * so that, we can make other activity implementations looks like normal activity subclasses.
     */
    @Override
    public void setContentView(int layoutResID) {
        if (view_stub != null) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            View stubView = inflater.inflate(layoutResID, view_stub, false);
            view_stub.addView(stubView, lp);
        }
    }

    @Override
    public void setContentView(View view) {
        if (view_stub != null) {
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            view_stub.addView(view, lp);
        }
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        if (view_stub != null) {
            view_stub.addView(view, params);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //todo set event here
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
//        if (mDrawerToggle.onOptionsItemSelected(item)) {
//            return true;
//        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public boolean onMenuItemClick(MenuItem item) {
//        todo set handle menuitemclick event here
//        switch (item.getItemId()) {
//            case R.id.item1:
//                // handle it
//                break;
//            case R.id.item2:
//                // do whatever
//                break;
//            // and so on...
//        }
//        return false;
//    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//        switch (menuItem.getItemId()) {
//            case R.id.nav_events:
//                Toast.makeText(this, "GotoEvents", Toast.LENGTH_SHORT).show();
//
//                break;
//            case R.id.nav_followings:
//                Toast.makeText(this, "GotoFollowings", Toast.LENGTH_SHORT).show();
//
//                break;
//            case R.id.nav_history:
//                Toast.makeText(this, "GotoHistory", Toast.LENGTH_SHORT).show();
//
//                break;
//            case R.id.nav_settings:
//                Toast.makeText(this, "GotoSettings", Toast.LENGTH_SHORT).show();
//                break;
//        }
//        menuItem.setChecked(true);
//        bottomSheetDialogFragment.dismiss();
//        return false;
//    }

    @Override
    public void onBottomSheetMenuItemClicked(int position) {
        switch (position) {
            case 0:
                //events
                if (!(this instanceof EventsActivity)) {
                    Intent intent = new Intent(this, EventsActivity.class);
                    startActivity(intent);
                }
                break;
            case 1:
                //followings
                break;
            case 2:
                //history
                if (!(this instanceof HistoryListActivity)) {
                    Intent intent = new Intent(this, HistoryListActivity.class);
                    startActivity(intent);
                }

                break;
            case 3:
                //settings
                break;
        }
        Log.d(TAG, "onBottomSheetMenuItemClicked: " + position);
    }

    public void gotoCreateHost(View view){
        Intent intent = new Intent(this,CreateHostActivity.class);
        startActivity(intent);
    }
}
