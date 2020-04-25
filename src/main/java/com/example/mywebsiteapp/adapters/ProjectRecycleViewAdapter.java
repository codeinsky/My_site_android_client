package com.example.mywebsiteapp.adapters;

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
import com.example.mywebsiteapp.holders.ProjectRecycleViewHolder;
import com.example.mywebsiteapp.model.ProjectModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProjectRecycleViewAdapter  extends RecyclerView.Adapter<ProjectRecycleViewHolder> {

    ArrayList<ProjectModel> projects;
    final private String baseUrl = "http://10.0.2.2:8181";
    final private String deleteProjectUrl = "/android/deleteproject/";
    public ProjectRecycleViewAdapter(ArrayList<ProjectModel> projects) {
        this.projects = projects;
    }

    @NonNull
    @Override
    public ProjectRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_card , parent , false);
        final TextView id = view.findViewById(R.id.card_project_id);
        TextView deleteProjectBtn = view.findViewById(R.id.delete_project);
        deleteProjectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("TEST" , "Delete project with id: " + id.getText() );
                String url = baseUrl + deleteProjectUrl + id.getText();
                StringRequest deleteProject = new StringRequest(Request.Method.DELETE, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("TEST" , "Project deleted");
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("TEST" , "project delete failed");
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
                Volley.newRequestQueue(view.getContext()).add(deleteProject);
            }
        });
        return new ProjectRecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectRecycleViewHolder holder, int position) {
        ProjectModel project = projects.get(position);
        holder.updateProjectCardView(project);
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }
}
