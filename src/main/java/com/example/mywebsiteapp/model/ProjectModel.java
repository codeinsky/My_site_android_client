package com.example.mywebsiteapp.model;

public class ProjectModel {
    private String id;
    private String comment;
    private String links;
    private String system;
    private String name;

    public ProjectModel(String id, String comment, String links, String system, String name) {
        this.id = id;
        this.comment = comment;
        this.links = links;
        this.system = system;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
