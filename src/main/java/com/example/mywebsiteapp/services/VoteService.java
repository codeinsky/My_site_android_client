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

    public ArrayList<VoteModel> getVote(){
        ArrayList<VoteModel> voteModelList = new ArrayList<>();
        voteModelList.add(new VoteModel(1,true , false , null , "1.74.272.198"));
        voteModelList.add(new VoteModel(2,false, true , null , "1.74.272.198"));
        voteModelList.add(new VoteModel(3,false, true , null , "1.74.134.158"));
        voteModelList.add(new VoteModel(4,true , false , null , "1.74.200.298"));
        voteModelList.add(new VoteModel(5,true , false , null , "1.74.134.498"));
        return  voteModelList;
    }
}
