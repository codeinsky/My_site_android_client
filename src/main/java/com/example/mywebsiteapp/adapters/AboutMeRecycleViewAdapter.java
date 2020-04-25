package com.example.mywebsiteapp.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mywebsiteapp.R;
import com.example.mywebsiteapp.activities.MainActivity;
import com.example.mywebsiteapp.holders.AboutMeRecycleViewHolder;
import com.example.mywebsiteapp.model.AboutMeModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class AboutMeRecycleViewAdapter extends RecyclerView.Adapter<AboutMeRecycleViewHolder> {
    ArrayList<AboutMeModel> aboutMes;
    private final String baseUr = "http://10.0.2.2:8181";
    private final String urlDeleteAboutMe = "/android/deleteaboutme/";

    public AboutMeRecycleViewAdapter(ArrayList<AboutMeModel> aboutMes) {
        this.aboutMes = aboutMes;
    }

    @NonNull
    @Override
    public AboutMeRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.aboute_me_card , parent, false);
        final TextView id = view.findViewById(R.id.about_me_id);
        final TextView deleteAboutMe = (TextView)view.findViewById(R.id.delete_about_me);
        deleteAboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("TEST" , "delete " + id.getText().toString());
                String url = baseUr + urlDeleteAboutMe + id.getText().toString();

                StringRequest deleteRequest = new StringRequest(Request.Method.DELETE, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("TEST" , "request success");
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("TEST" , "request failed");
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
                Volley.newRequestQueue(view.getContext()).add(deleteRequest);

            }
        });
        return new AboutMeRecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AboutMeRecycleViewHolder holder, int position) {
        AboutMeModel aboutMe = aboutMes.get(position);
        holder.updateAboutMeRecycle(aboutMe);

    }

    @Override
    public int getItemCount() {
        return aboutMes.size();
    }
}
