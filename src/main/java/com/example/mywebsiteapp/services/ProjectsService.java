package com.example.mywebsiteapp.services;

import com.example.mywebsiteapp.model.ProjectModel;

import java.util.ArrayList;

public class ProjectsService {
    private static ProjectsService projectsService = new ProjectsService();
    public  static ProjectsService getInstance(){
        return projectsService;
    }
    private ProjectsService(){}

    public ArrayList<ProjectModel> getProjects(){
        ArrayList<ProjectModel> projects = new  ArrayList<ProjectModel>();
        projects.add(new ProjectModel("1" , "That is my new project" , "WWW.git.com" , "MAC OS" , "My Web"));
        projects.add(new ProjectModel("2" , "AKA project " , "WWW.git.com" , "JAVA and AKA" , "actors"));
        projects.add(new ProjectModel("3" , "Angular 6" , "WWW.git.com" , "Angular " , "dynamic web"));
        projects.add(new ProjectModel("4" , "That is my new project" , "WWW.git.com" , "MAC OS" , "My Web"));
        projects.add(new ProjectModel("6" , "JAVA EE " , "WWW.git.com" , "JAVA 8" , "My Web"));
        projects.add(new ProjectModel("6" , "Android app" , "WWW.git.com" , "android studio" , "My Web"));
        projects.add(new ProjectModel("9" , "Android " , "WWW.git.com" , "MAC OS" , "SMS picker"));
        projects.add(new ProjectModel("8" , "Android " , "WWW.git.com" , "MAC OS" , "My web app client"));
        return  projects;
    }
}
