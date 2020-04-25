package com.example.mywebsiteapp.services;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import com.android.volley.toolbox.Volley;
import com.example.mywebsiteapp.activities.MainActivity;
import com.example.mywebsiteapp.dialogFragments.AboutMeUpdateDialogFragment;
import com.example.mywebsiteapp.fragments.AboutMeRecycleViewFragment;
import com.example.mywebsiteapp.model.AboutMeModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AboutMeService {
    private final String baseUrl="http://10.0.2.2:8181";
    private final String getAboutMeUrl = "/android/getallaboutme";
    public static  ArrayList<AboutMeModel> aboutMeModelsServer = new ArrayList<>();


    private static AboutMeService aboutMeService = new AboutMeService();
    public static AboutMeService getInstance(){
        return  aboutMeService;
    }
    public AboutMeService() {
    }
    public  ArrayList<AboutMeModel> getAboutMeLocal(Context context){
        ArrayList<AboutMeModel> aboutMes = new ArrayList<AboutMeModel>();
        aboutMes.add(new AboutMeModel("1" , "Education" , "John Bryce" , "JAVA EE"));
        aboutMes.add(new AboutMeModel("2" , "Education" , "Udemy" , "Angular"));
        aboutMes.add(new AboutMeModel("3" , "Education" , "Udemy" , "Docker"));
        aboutMes.add(new AboutMeModel("4" , "Hobby" , "Drones" , "dorne youtube:"));
        aboutMes.add(new AboutMeModel("5" , "Education" , "Udemy" , "Android"));
        aboutMes.add(new AboutMeModel("6" , "Electronic" , "John Bryce" , "3d printing"));
        return  aboutMes;
    }

    //http://localhost:8181/android/getallaboutme
    public  ArrayList<AboutMeModel> getAboutMeServer(final Context context , final Fragment fragment){
        Log.v("TEST", "service started");
        String url = baseUrl + getAboutMeUrl;
        JsonArrayRequest getAboutMe = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response.length()>0) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject aboutMe = response.getJSONObject(i);
                            aboutMeModelsServer.add(new AboutMeModel(
                                    aboutMe.getString("id"),
                                    aboutMe.getString("section"),
                                    aboutMe.getString("details"),
                                    aboutMe.getString("cooment")));
                            Log.v("TEST" , aboutMeModelsServer.toString());
                            AboutMeUpdateDialogFragment aboutMeDialog = (AboutMeUpdateDialogFragment)fragment;
                            aboutMeDialog.onDataReceived();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
                else {
                    Toast.makeText(context , "No any about me in data base" , Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("TEST" , error.toString());
            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type" , "application/json");
                params.put("Authorization" , MainActivity.key + MainActivity.jwt);
                return  params;
            }
        };


        Volley.newRequestQueue(context).add(getAboutMe);
        Log.v("TEST" , aboutMeModelsServer.toString());
        return aboutMeModelsServer;
    }
}
