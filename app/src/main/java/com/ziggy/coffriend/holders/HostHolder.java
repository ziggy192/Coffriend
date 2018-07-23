package com.ziggy.coffriend.holders;

import android.graphics.Bitmap;

import java.util.Date;
import java.util.List;

public class HostHolder {
    private List<String> topics;
    private Bitmap image;
    private String titlePlace;
    private String addressPlace;
    private Date date;
    private String timeStart;
    private String timeEnd;
    private String title;
    private String content;

    public HostHolder(List<String> topics, Bitmap image, String titlePlace, String addressPlace, Date date, String timeStart, String timeEnd, String title, String content) {
        this.topics = topics;
        this.image = image;
        this.titlePlace = titlePlace;
        this.addressPlace = addressPlace;
        this.date = date;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.title = title;
        this.content = content;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitlePlace() {
        return titlePlace;
    }

    public void setTitlePlace(String titlePlace) {
        this.titlePlace = titlePlace;
    }

    public String getAddressPlace() {
        return addressPlace;
    }

    public void setAddressPlace(String addressPlace) {
        this.addressPlace = addressPlace;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "HostHolder{" +
                "topics=" + topics +
                ", image=" + image +
                ", titlePlace='" + titlePlace + '\'' +
                ", addressPlace='" + addressPlace + '\'' +
                ", date=" + date +
                ", timeStart='" + timeStart + '\'' +
                ", timeEnd='" + timeEnd + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
