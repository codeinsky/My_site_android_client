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
import com.example.mywebsiteapp.model.AboutMeModel;
import com.example.mywebsiteapp.services.AboutMeService;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutMeRecycleViewFragment extends Fragment {
    public AboutMeRecycleViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_me_recycle_view, container, false);
        RecyclerView aboutMeRecycleView = (RecyclerView)view.findViewById(R.id.about_me_view_recycle);
        aboutMeRecycleView.setHasFixedSize(true);
        AboutMeRecycleViewAdapter aboutMeRecycleViewAdapter = new AboutMeRecycleViewAdapter(
               AboutMeService.aboutMeModelsServer
        );

        aboutMeRecycleView.setAdapter(aboutMeRecycleViewAdapter);
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        aboutMeRecycleView.setLayoutManager(lm);

        return  view;
    }


}
