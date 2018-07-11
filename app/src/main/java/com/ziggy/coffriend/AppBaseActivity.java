package com.ziggy.coffriend;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.EventLog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Objects;

public class AppBaseActivity extends AppCompatActivity implements MenuBottomSheetDialogFragment.Listener {


    private static final String TAG = AppBaseActivity.class.toString();

    private BottomAppBar appBar;
    private MenuBottomSheetDialogFragment bottomSheetDialogFragment;
    private TextView tvMonthTitle;
    private FrameLayout view_stub; //This is the framelayout to keep your content view
    private FloatingActionButton floatingActionButton;

    private ScrollController mScrollController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_app_base);// The base layout that contains your navigation drawer.
        view_stub = findViewById(R.id.view_stub);
        tvMonthTitle = findViewById(R.id.tvMonthTitle);
        floatingActionButton = findViewById(R.id.fab);

        appBar = findViewById(R.id.bar);
        bottomSheetDialogFragment = new MenuBottomSheetDialogFragment();
        appBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: appbarclicked");
//                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

//                bottomSheetDialogFragment.show
                bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
            }
        });

        appBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_message:
                        Intent intent = new Intent(AppBaseActivity.this, ChatListActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_today:
                        //todo scroll to middle
                        mScrollController.scrollToToday();
                        break;

                }
                return false;
            }
        });


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoCreateHost(view);
            }
        });
        floatingActionButton.setImageResource(R.drawable.ic_plus);
        setupAppbarUIOrigional();


    }

    public void setupAppbarUIOrigional() {
        tvMonthTitle.setVisibility(View.GONE);
        appBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
        appBar.replaceMenu(R.menu.bottom_app_bar_menu);


    }

    public void setupAppbarUIFollowings() {
        tvMonthTitle.setVisibility(View.VISIBLE);
        appBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
        appBar.replaceMenu(R.menu.bottom_app_bar_menu_followings);

//        floatingActionButton.setImageResource(R.drawable.ic_baseline_today_24px);
//        floatingActionButton.setOnClickListener(null);

    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        navigateFragement(EventsFragment.newInstance(null, null), "EventsFragment");

//        mDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
//        mDrawerToggle.onConfigurationChanged(newConfig);
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

    public void gotoHostDetail(View view) {
        Intent intent = new Intent(this, HostDetailActivity.class);
        startActivity(intent);


    }


    public void navigateFragement(Fragment fragment, String tag) {
        Fragment mFragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (mFragment == null) {
            mFragment = fragment;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.view_stub, mFragment, tag)
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .commit();

    }

    @Override
    public void onBottomSheetMenuItemClicked(int position) {
        switch (position) {
            case 0:
                setupAppbarUIOrigional();

                navigateFragement(EventsFragment.newInstance(null, null), "EventsFragment");
                break;
            case 1:
                //followings
                setupAppbarUIFollowings();
                Fragment fragment = getSupportFragmentManager().findFragmentByTag("FollowingsFragment");
                if (fragment == null) {
                    fragment = new FollowingsFragment();
                }
                if (fragment instanceof ScrollController) {
                    mScrollController = (ScrollController) fragment;
                }
                navigateFragement(fragment, "FollowingsFragment");
                break;
            case 2:
                //history
//                if (!(this instanceof HistoryListActivity)) {
//                    Intent intent = new Intent(this, HistoryListActivity.class);
//                    startActivity(intent);
//                }
                setupAppbarUIOrigional();
                navigateFragement(HistoryListFragment.newInstance(), "HistoryFragment");
                break;
            case 3:
                //settings
                setupAppbarUIOrigional();
                tvMonthTitle.setVisibility(View.GONE);
                appBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);

                navigateFragement(SettingsFragment.newInstance(), "SettingsFragment");
                break;
        }
        Log.d(TAG, "onBottomSheetMenuItemClicked: " + position);
    }


    public void gotoCreateHost(View view) {
        Intent intent = new Intent(this, CreateHostActivity.class);
        startActivity(intent);


    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onMonthChangedEvent(MonthChangedEvent event){
        tvMonthTitle.setText(event.newMonth);
    }


    public interface ScrollController {
        void scrollToToday();
    }

    public static class MonthChangedEvent{
        public String newMonth;

        public MonthChangedEvent(String newMonth) {
            this.newMonth = newMonth;
        }
    }
}
