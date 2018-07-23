package com.ziggy.coffriend;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ziggy.coffriend.adapters.HomeEventsAdapter;
import com.ziggy.coffriend.model.EventModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class EventsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    @BindView(R.id.rvEvents)
    RecyclerView rvEvents;

    public EventsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventsFragment newInstance(String param1, String param2) {
        EventsFragment fragment = new EventsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_events_content, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        List<EventModel> eventModels = new ArrayList<>();
        eventModels.add(new EventModel(false));
        EventModel eventmodel2 = new EventModel(R.drawable.blockchain,"BlockChain discussion","6:00 PM","Jun, Aug 5","5","Passio Coffee Q5",false);
        eventModels.add(eventmodel2);
        EventModel eventmodel3 = new EventModel(R.drawable.bitcoin,"BitCoin discussion","3:00 PM","Jun, Aug 8","8","The Coffe House",false);
        eventModels.add(eventmodel3);
        EventModel eventmodel4 = new EventModel(R.drawable.harryporter,"Harry Porter discussion","9:00 PM","Jun, Aug 10","10","Lala Restaurent",false);
        eventModels.add(eventmodel4);

        HomeEventsAdapter adapter = new HomeEventsAdapter(eventModels);
        rvEvents.setAdapter(adapter);
        rvEvents.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }



}
