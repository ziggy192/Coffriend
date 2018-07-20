package com.ziggy.coffriend.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ziggy.coffriend.R;
import com.ziggy.coffriend.model.EventModel;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class SmallEventsAdapter extends RecyclerView.Adapter<SmallEventsAdapter.SmallEventViewHolder> {

    private static final int MAX_LIST_LENGTH = 2;
    private List<EventModel> modelList;
    private int listLength;

    public SmallEventsAdapter() {
        listLength = MAX_LIST_LENGTH;
        modelList = new ArrayList<>();
        for (int i = 0; i < listLength; i++) {
            modelList.add(new EventModel());
        }
    }

    public int getListLength() {
        return listLength;
    }

    public void setListLength(int listLength) {
        this.listLength = listLength;
        this.notifyDataSetChanged();
    }

    @Override
    public SmallEventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SmallEventViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(@NonNull SmallEventViewHolder smallEventViewHolder, int i) {
        smallEventViewHolder.bind(modelList.get(i));
    }



    @Override
    public int getItemCount() {
        return modelList.size();
    }


    public static class SmallEventViewHolder extends RecyclerView.ViewHolder {

        private static final String TAG = "samlleventholder";

        ImageView imvFavorite;
        private EventModel model;


        SmallEventViewHolder(LayoutInflater inflater, ViewGroup parent) {

            super(inflater.inflate(R.layout.item_eventbrite_small, parent, false));
            imvFavorite = itemView.findViewById(R.id.btnFavorite);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    EventBus.getDefault().post(new SmallEventClickedEvent());

                }
            });
            imvFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, String.format("onClick: imvFavorite, model=%s", model));
                    if (model != null) {
                        model.setFavorite(!model.isFavorite());
                        inflatImvFavorite();
                    }
                }
            });
        }

        private void setOnClickListener(View.OnClickListener listener) {
            itemView.setOnClickListener(listener);
        }

        private void inflatImvFavorite() {
            if (model.isFavorite()) {
                imvFavorite.setImageResource(R.drawable.ic_menu_favorite);
            } else {
                imvFavorite.setImageResource(R.drawable.ic_menu_unfavorite);
            }
        }

        public void bind(EventModel model) {
            this.model = model;
            inflatImvFavorite();

        }




    }
    public static class SmallEventClickedEvent{

    }
}