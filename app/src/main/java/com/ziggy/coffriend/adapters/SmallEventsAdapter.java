package com.ziggy.coffriend.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.ziggy.coffriend.R;
import com.ziggy.coffriend.model.EventModel;

import org.greenrobot.eventbus.EventBus;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class SmallEventsAdapter extends RecyclerView.Adapter<SmallEventsAdapter.SmallEventViewHolder> {


    private List<EventModel> modelList;


    public SmallEventsAdapter() {
        modelList = new ArrayList<>();
        modelList.add(new EventModel());
        modelList.add(new EventModel());

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

        @BindView(R.id.imvEvent)
        ImageView imvEvent;
        @BindView(R.id.tvEventName)
        TextView tvEventName;
        @BindView(R.id.tvLocation)
        TextView tvLocation;
        @BindView(R.id.tvTime)
        TextView tvTime;


        SmallEventViewHolder(LayoutInflater inflater, ViewGroup parent) {

            super(inflater.inflate(R.layout.item_eventbrite_small, parent, false));
            ButterKnife.bind(this, itemView);
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

            tvEventName.setText(model.getTitle());
            tvLocation.setText(model.getLocation());
            tvTime.setText(model.getDateTime());
            Picasso.get().load(model.getResourceId())
                    .resize(104,104)
                    .transform(new RoundedCornersTransformation(10,0))
                    .into(imvEvent);
        }




    }
    public static class SmallEventClickedEvent{

    }
}