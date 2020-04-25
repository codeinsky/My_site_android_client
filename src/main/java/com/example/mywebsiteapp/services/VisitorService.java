package com.example.mywebsiteapp.services;
import android.content.Context;
import android.util.Log;

import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mywebsiteapp.activities.MainActivity;
import com.example.mywebsiteapp.dialogFragments.VisitorReportDialogFragment;
import com.example.mywebsiteapp.model.VisitorModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VisitorService {

    private final String baseUrl = "http://10.0.2.2:8181";
    private final String getVisitorsUrl = "/android/getallvisitors";
    public static ArrayList<VisitorModel> visitorsFromServer = new ArrayList<>();

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

    public void getVisitorsServer(Context context , final Fragment fragment){
        String url = baseUrl + getVisitorsUrl;
        JsonArrayRequest visitorRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.v("TEST", "Success");
                for (int i = 0 ; i < response.length() ; i ++){
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        Log.v("TEST" , obj.getString("ip"));
                        visitorsFromServer.add(new VisitorModel(
                                obj.getString("id"),
                                obj.getString("date"),
                                obj.getString("ip"),
                                obj.getString("comment")

                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    VisitorReportDialogFragment frag = (VisitorReportDialogFragment)fragment;
                    frag.onDataReceived();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("TEST" , "failed");
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
        Volley.newRequestQueue(context).add(visitorRequest);
    }
}
