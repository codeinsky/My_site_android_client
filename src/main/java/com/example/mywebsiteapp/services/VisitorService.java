package com.example.mywebsiteapp.services;
import com.example.mywebsiteapp.model.VisitorModel;

import java.util.ArrayList;

public class VisitorService {

    private static VisitorService visitorService = new VisitorService();

    public static VisitorService getInstance(){
        return visitorService;
    }

    private VisitorService(){

    }

    public ArrayList<VisitorModel> getVisitors(){
        ArrayList<VisitorModel> visitors = new ArrayList<VisitorModel>();
        visitors.add(new VisitorModel("1" , "01.05.2025" , "that is web visitor" , "172.56.07.65"));
        visitors.add(new VisitorModel("2" , "04.06.2025" , "new visitor" ,         "172.56.21.65"));
        visitors.add(new VisitorModel("3" , "04.10.2025" , "return  vsisit" ,      "172.56.23.65"));
        visitors.add(new VisitorModel("4" , "04.06.2025" , "that is web visitor" , "123.56.24.65"));
        visitors.add(new VisitorModel("5" , "04.11.2025" , "that is web visitor" , "109.46.23.65"));
        visitors.add(new VisitorModel("6" , "04.07.2025" , "that is web visitor" , "145.55.23.65"));
        visitors.add(new VisitorModel("7" , "04.05.2025" , "that is web visitor" , "200.88.23.65"));
        return  visitors;
    }
}
