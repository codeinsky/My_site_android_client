package com.example.mywebsiteapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mywebsiteapp.R;
import com.example.mywebsiteapp.adapters.VisitorRecycleViewAdapter;
import com.example.mywebsiteapp.services.VisitorService;

/**
 * A simple {@link Fragment} subclass.
 */
public class VisitorRecycleViewFragment extends Fragment {

    public VisitorRecycleViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_visitor_recycle_view, container, false);
        RecyclerView visitorReportRecycleView = (RecyclerView) view.findViewById(R.id.visitor_view_recycle_report);
        visitorReportRecycleView.setHasFixedSize(true);
        VisitorRecycleViewAdapter visitorRecycleViewAdapter = new VisitorRecycleViewAdapter(VisitorService.getInstance().getVisitors());
        visitorReportRecycleView.setAdapter(visitorRecycleViewAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        visitorReportRecycleView.setLayoutManager(linearLayoutManager);
        return view;

    }
}
