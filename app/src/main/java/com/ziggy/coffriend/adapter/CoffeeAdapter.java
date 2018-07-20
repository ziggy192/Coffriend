package com.ziggy.coffriend.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.squareup.picasso.Picasso;
import com.ziggy.coffriend.R;
import com.ziggy.coffriend.model.CoffeeShop;


public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.ViewHolder> {

    private List<CoffeeShop> mListCoffee;
    private OnItemClickListener mListener;

    public CoffeeAdapter(List<CoffeeShop> mListCoffee) {
        this.mListCoffee = mListCoffee;
    }

    @NonNull
    @Override
    public CoffeeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_coffee,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final CoffeeAdapter.ViewHolder holder, final int position) {
        Picasso.get().load(mListCoffee.get(position).getBackgroundImg()).into(holder.mImgBackground);
//        holder.mImgBackground.setImageResource(mListCoffee.get(position).getBackgroundImg());
//        holder.mImgLocation.setImageResource(mListCoffee.get(position).getLocationImg());
        holder.mTxtCoffeeName.setText(mListCoffee.get(position).getCoffeeName());
        holder.mTxtCoffeeAddress.setText(mListCoffee.get(position).getCoffeeAddress());
        holder.mlnlCoffeeRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null){
                    mListener.onItemClickListener(position);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        int count = (mListCoffee!=null) ? mListCoffee.size() : 0;
        return count;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImgBackground,mImgLocation;
        private TextView mTxtCoffeeName,mTxtCoffeeAddress;
        private FrameLayout mlnlCoffeeRoot;

        public ViewHolder(View itemView) {
            super(itemView);
            mImgBackground = itemView.findViewById(R.id.img_background);
            mImgLocation = itemView.findViewById(R.id.img_location);
            mTxtCoffeeName = itemView.findViewById(R.id.text_view_coffee_name);
            mTxtCoffeeAddress = itemView.findViewById(R.id.text_view_coffee_address);
            mlnlCoffeeRoot = itemView.findViewById(R.id.lnl_coffee_root);
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener){this.mListener = listener;}

    public interface OnItemClickListener{
        void onItemClickListener(int position);
    }
}
