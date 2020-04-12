package com.example.mywebsiteapp.model;

public class AboutMeModel {
    private String id;
    private String section;
    private String details;
    private String comment;

    public AboutMeModel(String id, String section, String details, String comment) {
        this.id = id;
        this.section = section;
        this.details = details;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
