package com.example.mywebsiteapp.services;

import android.content.Context;
import android.util.Log;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.mywebsiteapp.dialogFragments.VotesReportDialogFragment;
import com.example.mywebsiteapp.fragments.VoteRecycleViewFragment;
import com.example.mywebsiteapp.model.VoteModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class VoteService {
    private final String baseUrl = "http://10.0.2.2:8181";
    private final String getVoteUrl= "/android/getallvotes";
    private static VoteService VoteService = new VoteService();
    public static ArrayList<VoteModel> votesFromServer = new ArrayList<>();
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

    public void getVotesFromServer(Context context , final Fragment fragment){
        String url = baseUrl + getVoteUrl;
        JsonArrayRequest getVotesServer = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                    for(int i=0 ; i < response.length() ; i++){
                        try {
                            JSONObject obj = response.getJSONObject(i);
                            votesFromServer.add(new VoteModel(
                                    obj.getInt("id"),
                                    obj.getBoolean("liked"),
                                    obj.getBoolean("disliked"),
                                    obj.getString("date"),
                                    obj.getString("ipVoted")
                            ));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                VotesReportDialogFragment frg = (VotesReportDialogFragment) fragment;
                    frg.onDataReceived();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("TEST" , "request failed");
            }
        });
        Volley.newRequestQueue(context).add(getVotesServer);
    }
}
