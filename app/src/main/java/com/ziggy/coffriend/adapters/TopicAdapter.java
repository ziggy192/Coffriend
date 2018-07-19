package com.ziggy.coffriend.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ziggy.coffriend.R;
import com.ziggy.coffriend.holders.TopicHolder;
import com.ziggy.coffriend.holders.TopicNodeHolder;

import java.util.List;

public class TopicAdapter extends BaseAdapter{
    private Activity activity;
    private List<TopicHolder> list;

    public TopicAdapter(Activity activity, List<TopicHolder> list) {
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
        view = inflater.inflate(R.layout.item_list_topic, null);

        TopicHolder holder = (TopicHolder) getItem(i);

        List<TopicNodeHolder> listTopics = holder.getList();

        TopicNodeAdapter adapter = new TopicNodeAdapter(activity, listTopics);
        final GridView gv = view.findViewById(R.id.gvTopics);
        gv.setAdapter(adapter);

        ((TextView) view.findViewById(R.id.txtTopicTitle)).setText(holder.getTitle());

        ((ImageButton) view.findViewById(R.id.btnCollapse)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gv.getVisibility() == View.GONE){
                    gv.setVisibility(View.VISIBLE);
                    ((ImageButton) view.findViewById(R.id.btnCollapse)).setImageResource(R.drawable.ic_arrow_up);
                } else {
                    gv.setVisibility(View.GONE);
                    ((ImageButton) view.findViewById(R.id.btnCollapse)).setImageResource(R.drawable.ic_arrow_down);
                }
            }
        });

        return view;
    }
}
