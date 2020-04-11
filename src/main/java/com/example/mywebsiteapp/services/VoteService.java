package com.example.mywebsiteapp.services;

import com.example.mywebsiteapp.model.VoteModel;

import java.util.ArrayList;

public class VoteService {
    private static VoteService VoteService = new VoteService();

    public static VoteService getInstance(){
        return  VoteService;
    }
    private VoteService(){

    }

    public ArrayList<VoteModel> getVotes(){
        ArrayList<VoteModel> voteModelList = new ArrayList<>();
        voteModelList.add(new VoteModel(1,true , false , "01.02.2020" , "1.74.272.198"));
        voteModelList.add(new VoteModel(2,false, true , "05.06.2020" , "1.74.272.198"));
        voteModelList.add(new VoteModel(3,false, true , "06.07.2020", "1.74.134.158"));
        voteModelList.add(new VoteModel(4,true , false , "08.09.2023" , "1.74.200.298"));
        voteModelList.add(new VoteModel(5,true , false , "01.02.2019" , "1.74.134.498"));
        return  voteModelList;
    }
}
