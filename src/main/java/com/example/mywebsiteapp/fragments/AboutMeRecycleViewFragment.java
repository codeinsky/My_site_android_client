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
public class AboutMeRecycleViewFragment extends Fragment {

    public AboutMeRecycleViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_me_recycle_view, container, false);
    }
}
