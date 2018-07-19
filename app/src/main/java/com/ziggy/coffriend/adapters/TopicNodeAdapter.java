package com.ziggy.coffriend.adapters;

import android.app.Activity;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ziggy.coffriend.R;
import com.ziggy.coffriend.holders.TopicNodeHolder;

import java.util.List;
import java.util.zip.Inflater;

import de.hdodenhof.circleimageview.CircleImageView;

public class TopicNodeAdapter extends BaseAdapter{
    private Activity activity;
    private List<TopicNodeHolder> list;

    public TopicNodeAdapter(Activity activity, List<TopicNodeHolder> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.item_list_topic_node, null);

        final TopicNodeHolder holder = (TopicNodeHolder) getItem(i);
        view.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CircleImageView btnTopicCheck = view.findViewById(R.id.btnTopicCheck);

                if(!holder.isCheck()){
                    btnTopicCheck.setBackgroundResource(R.drawable.bg_radius_white_line_green);
                } else {
                    btnTopicCheck.setBackgroundResource(R.drawable.bg_radius_white);
                }

                holder.setCheck(!holder.isCheck());
            }
        });

        ((ImageView) view.findViewById(R.id.imageTopic)).setImageResource(holder.getImage());

        ((TextView) view.findViewById(R.id.txtTopicNodeTitle)).setText(holder.getTitle());

        return view;
    }
}
