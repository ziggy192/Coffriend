package com.ziggy.coffriend.holders;

import java.util.List;

public class TopicHolder {

    private String title;
    private List<TopicNodeHolder> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TopicNodeHolder> getList() {
        return list;
    }

    public void setList(List<TopicNodeHolder> list) {
        this.list = list;
    }

    public TopicHolder(String title, List<TopicNodeHolder> list) {
        this.title = title;

        this.list = list;
    }
}
