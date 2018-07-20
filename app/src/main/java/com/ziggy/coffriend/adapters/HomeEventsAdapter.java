package com.ziggy.coffriend.adapters;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
            MaskTransformation transformation = new MaskTransformation(itemView.getContext()
                    ,R.drawable.transformation_rounded_corners);
            Picasso.get()
                    .load(R.drawable.bg_ml)
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

