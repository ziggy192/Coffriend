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

import org.greenrobot.eventbus.EventBus;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.support.constraint.Constraints.TAG;
import static com.ziggy.coffriend.FollowingsFragment.FollowingsAdapter.TODAY_POSITION_IN_LIST;


/**
 * A simple {@link Fragment} subclass.
 */
public class FollowingsFragment extends Fragment implements AppBaseActivity.ScrollController {
    public static final String TAG = FollowingsFragment.class.toString();

    public FollowingsFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    private int currentMonth = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_followings, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvFollowings);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        FollowingsAdapter adapter = new FollowingsAdapter();
        recyclerView.setAdapter(adapter);

        recyclerView.scrollToPosition(TODAY_POSITION_IN_LIST);
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
//                int position = ((LinearLayoutManager) recyclerView.getLayoutManager())
//                        .findFirstCompletelyVisibleItemPosition();
//                if (position == -1) {
//                    return;
//                }
//                FollowingModel model = new FollowingModel(position);
//                Log.d(TAG, String.format("onScrolled: firstVisiblePosition=%d, currentMonth=%d,newMonth=%d"
//                        , position, currentMonth, model.calendar.get(Calendar.MONTH)));
//
//                if (model.calendar.get(Calendar.MONTH) != currentMonth) {
//                    currentMonth = model.calendar.get(Calendar.MONTH);
//                    SimpleDateFormat dateFormat = new SimpleDateFormat();
//                    dateFormat.applyPattern("MMMM");
//                    String month = dateFormat.format(model.calendar.getTime());
//                    EventBus.getDefault().post(new AppBaseActivity.MonthChangedEvent(month));
//                }

            }
        });

    }

    @Override
    public void scrollToToday() {
        recyclerView.smoothScrollToPosition(TODAY_POSITION_IN_LIST);
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvDate;
        TextView tvDay;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvDay = itemView.findViewById(R.id.tvDay);

        }

        public void bind(FollowingModel model) {
            SimpleDateFormat dateFormat = new SimpleDateFormat();
//            dateFormat.applyPattern("EEE");
//            String day = dateFormat.format(model.calendar.getTime());
//            tvDay.setText(day);
//            Log.d(TAG, "bind: Day = " + day);

            dateFormat.applyPattern("EE, MMM dd");
            String date = dateFormat.format(model.calendar.getTime());
            tvDate.setText(date);
            Log.d(TAG, "bind: Date = " + date);
        }
    }

    public static class FollowingsAdapter extends RecyclerView.Adapter<ViewHolder> {

        private static final int MAX_LIST_LENGTH = 5;
        public static final int TODAY_POSITION_IN_LIST =   0;



        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(
                    LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.item_followings_list, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

            //generate Model by position, no list needed
            FollowingModel model =new FollowingModel(i);
            viewHolder.bind(model);
        }


        @Override
        public int getItemCount() {
            return MAX_LIST_LENGTH;
        }

    }

    private static class FollowingModel {
        public Calendar calendar;

        public FollowingModel(Calendar calendar) {
            this.calendar = calendar;
        }

        public FollowingModel(int position) {
            int addAmount = position - TODAY_POSITION_IN_LIST;
            calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, addAmount);
        }
    }


}
