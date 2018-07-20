package com.ziggy.coffriend.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ziggy.coffriend.R;
import com.ziggy.coffriend.holders.ChatSimpleHolder;

import java.util.Arrays;
import java.util.List;

public class OnlineChatListAdapter extends BaseAdapter {

    private List<ChatSimpleHolder> list;
    private Activity activity;

    public OnlineChatListAdapter(List<ChatSimpleHolder> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    public OnlineChatListAdapter(ChatSimpleHolder[] list, Activity activity) {
        this.list = Arrays.asList(list);
        this.activity = activity;
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
        return list.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = activity.getLayoutInflater();

        view = inflater.inflate(R.layout.item_online_chat, null);

        ChatSimpleHolder item = (ChatSimpleHolder) getItem(i);

        ((ImageView) (view.findViewById(R.id.imgOnlineProfile))).setImageResource(item.getImage());

        ((TextView) (view.findViewById(R.id.txtOnlineTitle))).setText(item.getName());

        return view;
    }
}
