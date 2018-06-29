package com.ziggy.coffriend.holders;

import java.sql.Date;

public class ChatSimpleHolder {
    private int id;
    private int image;
    private int friendImage;
    private String name;
    private String lastMess;
    private Date lastDate;
    private boolean isSeen;

    public ChatSimpleHolder(int id, int image, int friendImage, String name, String lastMess, Date lastDate, boolean isSeen) {
        this.id = id;
        this.image = image;
        this.friendImage = friendImage;
        this.name = name;
        this.lastMess = lastMess;
        this.lastDate = lastDate;
        this.isSeen = isSeen;
    }

    public int getId() {
        return id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getFriendImage() {
        return friendImage;
    }

    public void setFriendImage(int friendImage) {
        this.friendImage = friendImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastMess() {
        return lastMess;
    }

    public void setLastMess(String lastMess) {
        this.lastMess = lastMess;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean seen) {
        isSeen = seen;
    }
}
