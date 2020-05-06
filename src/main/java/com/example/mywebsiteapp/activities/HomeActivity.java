package com.example.mywebsiteapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mywebsiteapp.R;
import com.example.mywebsiteapp.dialogFragments.AboutMeUpdateDialogFragment;
import com.example.mywebsiteapp.dialogFragments.ProjectsUpdateDialogFragment;
import com.example.mywebsiteapp.dialogFragments.VisitorReportDialogFragment;
import com.example.mywebsiteapp.dialogFragments.VotesReportDialogFragment;
import com.example.mywebsiteapp.services.UrlsStrings;


import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {
    private Button logOut;
    private TextView visitorsCountView;
    private TextView likesCountView;
    private TextView dislikesCountView;
    private Button voteReportBtn;
    private Button visitorReportBtn;
    private Button updateAboutMeBtn;
    private Button updateProjectsBtn;
    private Button resetVisitorCountBtn;
    private Button resetVoteCountBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        logOut = (Button)findViewById(R.id.logOut);
        visitorsCountView = (TextView)findViewById(R.id.visitor_count);
        likesCountView = (TextView)findViewById(R.id.likes_count);
        dislikesCountView = (TextView)findViewById(R.id.dislike_counts);
        voteReportBtn = (Button)findViewById(R.id.vote_btn);
        visitorReportBtn = (Button)findViewById(R.id.visitor_report_btn);
        updateAboutMeBtn = (Button)findViewById(R.id.about_me_update_btn);
        updateProjectsBtn = (Button)findViewById(R.id.projects_update_btn);
        resetVisitorCountBtn = (Button)findViewById(R.id.reset_visitors);
        resetVoteCountBtn = (Button)findViewById(R.id.reset_votes);
        dislikesCountView.setText("on request");
        visitorsCountView.setText("on request");
        likesCountView.setText("on request");
        getVisitorsCountRequest();
        getLikeCountRequest();
        getDislikeCountRequest();

        resetVisitorCountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest resetVisitorCount = new StringRequest(Request.Method.POST, UrlsStrings.baseUrlResetVisitorCount, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Visitor list deleted" , Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Visitor delete request failed" , Toast.LENGTH_SHORT).show();

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
                Volley.newRequestQueue(getApplicationContext()).add(resetVisitorCount);
            }
        });

        resetVoteCountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest resetVoteCount = new StringRequest(Request.Method.POST, UrlsStrings.baseUrlResetVote, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), "Vote list deleted" , Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Vote delete request failed" , Toast.LENGTH_SHORT).show();

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
                Volley.newRequestQueue(getApplicationContext()).add(resetVoteCount);
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logIn = new Intent(HomeActivity.this , MainActivity.class);
                startActivity(logIn);
            }
        });

        voteReportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment voteReport = new VotesReportDialogFragment();
                voteReport.show(getSupportFragmentManager().beginTransaction() , "voteReport");
            }
        });

        visitorReportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment visitorReport = new VisitorReportDialogFragment();
                visitorReport.show(getSupportFragmentManager().beginTransaction() , "visitorReport");
            }
        });

        updateAboutMeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment updateAboutMe = new AboutMeUpdateDialogFragment();
                updateAboutMe.show(getSupportFragmentManager().beginTransaction() , "aboutMeUpdate");
            }
        });

        updateProjectsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment updateProject = new ProjectsUpdateDialogFragment();
                updateProject.show(getSupportFragmentManager().beginTransaction() , "projectsUpdate");
            }
        });


    }

    private void  getVisitorsCountRequest(){
        StringRequest getVisitorCount =  new StringRequest(Request.Method.GET, UrlsStrings.baseUrlGetVisitorCount, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                visitorsCountView.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                visitorsCountView.setText("request failed");
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
        Volley.newRequestQueue(this).add(getVisitorCount);

    }

    private void  getLikeCountRequest(){
        StringRequest getLikesCount = new StringRequest(Request.Method.GET, UrlsStrings.baseUrlGetLikesCount, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                likesCountView.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                likesCountView.setText("Request failed");

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
        }
                ;
        Volley.newRequestQueue(this).add(getLikesCount);
    }

    private void getDislikeCountRequest(){
        StringRequest getDislikesRequest = new StringRequest(Request.Method.GET, UrlsStrings.baseUrlGetDisLikesCount, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                dislikesCountView.setText(response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dislikesCountView.setText("Request failed");
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

        Volley.newRequestQueue(this).add(getDislikesRequest);
    }
}
