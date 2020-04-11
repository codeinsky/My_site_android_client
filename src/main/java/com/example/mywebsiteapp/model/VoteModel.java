package com.example.mywebsiteapp.model;

import java.util.Date;

public class VoteModel {
    private int id;
    private boolean liked ;
    private boolean disliked;
    private String date;
    private String ip;

    public VoteModel(int id, boolean liked, boolean disliked, String date, String ip) {
        this.id = id;
        this.liked = liked;
        this.disliked = disliked;
        this.date = date;
        this.ip = ip;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public boolean isDisliked() {
        return disliked;
    }

    public void setDisliked(boolean disliked) {
        this.disliked = disliked;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
