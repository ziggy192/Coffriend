package com.ziggy.coffriend;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ziggy.coffriend.adapters.SmallEventsAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;



/**
 * A simple {@link Fragment} subclass.
 */
public class FollowingsFragment extends Fragment  {
    public static final String TAG = FollowingsFragment.class.toString();


    RecyclerView rvFavoriteEvents1;
    RecyclerView rvFavoriteEvents2;

    public FollowingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_followings, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvFavoriteEvents1 = view.findViewById(R.id.rvFavoriteEvents1);
        rvFavoriteEvents2 = view.findViewById(R.id.rvFavoriteEvents2);
        rvFavoriteEvents1.setLayoutManager(new LinearLayoutManager(getActivity()));
        SmallEventsAdapter smallEventsAdapter1 = new SmallEventsAdapter();
        rvFavoriteEvents1.setAdapter(smallEventsAdapter1);


        rvFavoriteEvents2.setLayoutManager(new LinearLayoutManager(getActivity()));
        SmallEventsAdapter smallEventsAdapter2 = new SmallEventsAdapter();
        rvFavoriteEvents2.setAdapter(smallEventsAdapter2);
    }

    @Subscribe
    public void onSmallEventClicked(SmallEventsAdapter.SmallEventClickedEvent event) {
        Intent intent = new Intent(this.getActivity(), HostDetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


//    private static class ViewHolder extends RecyclerView.ViewHolder {
//
//        TextView tvDate;
//        TextView tvDay;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            tvDate = itemView.findViewById(R.id.tvDate);
//            tvDay = itemView.findViewById(R.id.tvDay);
//
//        }
//
//        public void bind(FollowingModel model) {
//            SimpleDateFormat dateFormat = new SimpleDateFormat();
////            dateFormat.applyPattern("EEE");
////            String day = dateFormat.format(model.calendar.getTime());
////            tvDay.setText(day);
////            Log.d(TAG, "bind: Day = " + day);
//
//            dateFormat.applyPattern("EE, MMM dd");
//            String date = dateFormat.format(model.calendar.getTime());
//            tvDate.setText(date);
//            Log.d(TAG, "bind: Date = " + date);
//        }
//    }
//
//    public static class FollowingsAdapter extends RecyclerView.Adapter<ViewHolder> {
//
//        public static final int TODAY_POSITION_IN_LIST = 0;
//        private static final int MAX_LIST_LENGTH = 5;
//
//        @Override
//        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            return new ViewHolder(
//                    LayoutInflater.from(parent.getContext())
//                            .inflate(R.layout.item_followings_list, parent, false));
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
//
//            //generate Model by position, no list needed
//            FollowingModel model = new FollowingModel(i);
//            viewHolder.bind(model);
//        }
//
//
//        @Override
//        public int getItemCount() {
//            return MAX_LIST_LENGTH;
//        }
//
//    }
//
//    private static class FollowingModel {
//        public Calendar calendar;
//
//        public FollowingModel(Calendar calendar) {
//            this.calendar = calendar;
//        }
//
//        public FollowingModel(int position) {
//            int addAmount = position - TODAY_POSITION_IN_LIST;
//            calendar = Calendar.getInstance();
//            calendar.add(Calendar.DATE, addAmount);
//        }
//    }


}
