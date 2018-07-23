package com.ziggy.coffriend.adapters;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import com.ziggy.coffriend.R;
import com.ziggy.coffriend.model.EventModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.picasso.transformations.MaskTransformation;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class HomeEventsAdapter extends RecyclerView.Adapter<HomeEventsAdapter.ViewHolder> {
    List<EventModel> eventModelList;

    public HomeEventsAdapter(List<EventModel> eventModelList) {
        this.eventModelList = eventModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_eventbrite_home,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(eventModelList.get(i));
    }

    @Override
    public int getItemCount() {
        return eventModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private EventModel model;

        @BindView(R.id.btnFavorite)
        FloatingActionButton btnFavorite;

        @BindView(R.id.imvEvent)
        ImageView imvEvent;

        @BindView(R.id.tvLocation)
        TextView tvLocation;
        @BindView(R.id.tvTime)
        TextView tvTime;
        @BindView(R.id.tvEventName)
        TextView tvEventName;

        @BindView(R.id.tvDateOfMonth)
        TextView tvDateOfMonth;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bind(EventModel model) {
            this.model = model;
            if (model.isFavorite()) {
                btnFavorite.setImageResource(R.drawable.ic_menu_favorite);
            } else {
                btnFavorite.setImageResource(R.drawable.ic_menu_unfavorite);
            }
            tvEventName.setText(model.getTitle());
            tvLocation.setText(model.getLocation());
            tvTime.setText(model.getTime());
            tvDateOfMonth.setText(model.getDateNumber());

            Picasso.get()
                    .load(model.getResourceId())
                    .centerCrop()
                    .resize(300,160)
                    .transform(new RoundedCornersTransformation(10,10))
                    .into(imvEvent);



        }

        @OnClick(R.id.btnFavorite)
        public void changeFavorite(FloatingActionButton button) {
            model.setFavorite(!model.isFavorite());
            if (model.isFavorite()) {
                btnFavorite.setImageResource(R.drawable.ic_menu_favorite);
            } else {
                btnFavorite.setImageResource(R.drawable.ic_menu_unfavorite);
            }

        }
    }
}

