package com.example.mywebsiteapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mywebsiteapp.R;
import com.example.mywebsiteapp.holders.ProjectRecycleViewHolder;
import com.example.mywebsiteapp.model.ProjectModel;

import java.util.ArrayList;

public class ProjectRecycleViewAdapter  extends RecyclerView.Adapter<ProjectRecycleViewHolder> {

    ArrayList<ProjectModel> projects;

    public ProjectRecycleViewAdapter(ArrayList<ProjectModel> projects) {
        this.projects = projects;
    }

    @NonNull
    @Override
    public ProjectRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_card , parent , false);
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
