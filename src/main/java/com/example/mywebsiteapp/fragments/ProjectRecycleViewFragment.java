package com.example.mywebsiteapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mywebsiteapp.R;

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
        return  view;
    }
}
