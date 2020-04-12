package com.example.mywebsiteapp.services;

import com.example.mywebsiteapp.model.AboutMeModel;

import java.util.ArrayList;

public class AboutMeService {

    private static AboutMeService aboutMeService = new AboutMeService();
    public static AboutMeService getInstance(){
        return  aboutMeService;
    }
    public AboutMeService() {
    }
    public  ArrayList<AboutMeModel> getAboutMe(){
        ArrayList<AboutMeModel> aboutMes = new ArrayList<AboutMeModel>();
        aboutMes.add(new AboutMeModel("1" , "Education" , "John Bryce" , "JAVA EE"));
        aboutMes.add(new AboutMeModel("2" , "Education" , "Udemy" , "Angular"));
        aboutMes.add(new AboutMeModel("3" , "Education" , "Udemy" , "Docker"));
        aboutMes.add(new AboutMeModel("4" , "Hobby" , "Drones" , "dorne youtube:"));
        aboutMes.add(new AboutMeModel("5" , "Education" , "Udemy" , "Android"));
        aboutMes.add(new AboutMeModel("6" , "Electronic" , "John Bryce" , "3d printing"));

        return  aboutMes;
    }
}
