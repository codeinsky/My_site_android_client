package com.example.mywebsiteapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mywebsiteapp.R;
import com.example.mywebsiteapp.adapters.AboutMeRecycleViewAdapter;
import com.example.mywebsiteapp.adapters.ProjectRecycleViewAdapter;
import com.example.mywebsiteapp.services.ProjectsService;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectRecycleViewFragment extends Fragment {

    public ProjectRecycleViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_project_recycle_view, container, false);
        RecyclerView projectsRecycleViews =  (RecyclerView) view.findViewById(R.id.projects_view_recycle);
        projectsRecycleViews.setHasFixedSize(true);
        ProjectRecycleViewAdapter projectRecycleViewAdapter = new ProjectRecycleViewAdapter(ProjectsService.getInstance().getProjects());
        projectsRecycleViews.setAdapter(projectRecycleViewAdapter);
        LinearLayoutManager lm = new LinearLayoutManager(container.getContext());
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        projectsRecycleViews.setLayoutManager(lm);
        return  view;
    }
}
