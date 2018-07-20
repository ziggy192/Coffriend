package com.ziggy.coffriend.model;

import com.ziggy.coffriend.R;

public class EventModel {
    private int resourceId;
    private String title;
    private String time;
    private String date;
    private String location;
    private String dateNumber;

    private boolean isFavorite;

    public EventModel(int resourceId, String title, String time, String date, String dateNumber, String location, boolean isFavorite) {
        this.resourceId = resourceId;
        this.title = title;
        this.time = time;
        this.date = date;
        this.dateNumber = dateNumber;
        this.location = location;
        this.isFavorite = isFavorite;
    }

    public int getResourceId() {
        return resourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getDateTime() {
        return date + " - " + time;
    }

    public String getDateNumber() {
        return dateNumber;
    }

    public EventModel() {
        this(false);
    }

    public EventModel(boolean isFavorite) {
        this.isFavorite = isFavorite;
        resourceId = R.drawable.bg_ml;
        title = "Find friends for machine learning discussion";
        time = "5:00PM";
        location = "The Coffee House";
        date = "Jun, Aug 4";
        dateNumber = "4";
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    @Override
    public String toString() {
        return "EventModel{" +
                "isFavorite=" + isFavorite +
                '}';
    }
}