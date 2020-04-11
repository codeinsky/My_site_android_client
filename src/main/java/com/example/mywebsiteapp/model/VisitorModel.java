package com.example.mywebsiteapp.model;

public class VisitorModel {
    private String id;
    private String date;
    private String comment;
    private String ip;

    public VisitorModel(String id, String date, String comment, String ip) {
        this.id = id;
        this.date = date;
        this.comment = comment;
        this.ip = ip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
