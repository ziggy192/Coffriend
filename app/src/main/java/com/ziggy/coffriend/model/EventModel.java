package com.ziggy.coffriend.model;

public class EventModel {
    private boolean isFavorite;

    public EventModel() {
        isFavorite = false;
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