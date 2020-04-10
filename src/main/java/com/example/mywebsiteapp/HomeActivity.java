package com.example.mywebsiteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class HomeActivity extends AppCompatActivity {
    private Button logOut;
    private TextView visitorsCountView;
    private TextView likesCountView;
    private TextView dislikesCountView;
    private final String baseURL = "http://10.0.2.2:8181";
    private final String getVisitorsCountURL = "/android/getvisitorcount";
    private final String getLikesCountURL    = "/android/getlikescount";
    private final String getDislikesCountURL = "/android/getdislikescount" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        logOut = (Button)findViewById(R.id.logOut);
        visitorsCountView = (TextView)findViewById(R.id.visitor_count);
        likesCountView = (TextView)findViewById(R.id.likes_count);
        dislikesCountView = (TextView)findViewById(R.id.dislike_counts);
        dislikesCountView.setText("on request");
        visitorsCountView.setText("on request");
        likesCountView.setText("on request");
        getVisitorsCountRequest();
        getLikeCountRequest();
        getDislikeCountRequest();

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logIn = new Intent(HomeActivity.this , MainActivity.class);
                startActivity(logIn);
            }
        });

    }

    private void  getVisitorsCountRequest(){
        String url = baseURL + getVisitorsCountURL;
        StringRequest getVisitorCount =  new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("TEST" , "visitor count is: " + response.toString());
                visitorsCountView.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("TEST", "get visitor count request failed " + error.toString());
                visitorsCountView.setText("request failed");
            }
        });
        Volley.newRequestQueue(this).add(getVisitorCount);

    }

    private void  getLikeCountRequest(){
        String url = baseURL + getLikesCountURL;
        StringRequest getLikesCount = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                likesCountView.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                likesCountView.setText("Request failed");

            }
        });
        Volley.newRequestQueue(this).add(getLikesCount);
    }

    private void getDislikeCountRequest(){
        String url = baseURL + getDislikesCountURL;
        StringRequest getDislikesRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dislikesCountView.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dislikesCountView.setText("Request failed");
            }
        });

        Volley.newRequestQueue(this).add(getDislikesRequest);
    }
}
