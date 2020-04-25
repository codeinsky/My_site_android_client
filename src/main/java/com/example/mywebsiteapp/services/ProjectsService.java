package com.example.mywebsiteapp.services;

import android.content.Context;
import android.util.Log;

import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.mywebsiteapp.activities.MainActivity;
import com.example.mywebsiteapp.dialogFragments.ProjectsUpdateDialogFragment;
import com.example.mywebsiteapp.model.ProjectModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProjectsService {
    private final String baseUrl="http://10.0.2.2:8181";
    public final String getAllProjectsUrl = "/android/getallprojects";
    public static ArrayList<ProjectModel>  projectsFromServer = new ArrayList<>();
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

    public  void getProjectSFromServer(Context context , final Fragment fragment){
        String url = baseUrl + getAllProjectsUrl;
        JsonArrayRequest getProjectsRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
                public void onResponse(JSONArray response) {
                    Log.v("TEST" , "response success:" + response.length());
                        for(int i = 0; i < response.length(); i ++) {
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                projectsFromServer.add(new ProjectModel(
                                       obj.getString("id"),
                                       obj.getString("name"),
                                       obj.getString("system"),
                                       obj.getString("comment"),
                                        obj.getString("links")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            ProjectsUpdateDialogFragment frg = (ProjectsUpdateDialogFragment)fragment;
                            frg.onDataReceived();
                        }
                    }
                },
                new Response.ErrorListener() {
            @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("TEST" , "Request failed: " + error.getMessage());
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
        Volley.newRequestQueue(context).add(getProjectsRequest);

    }
}
