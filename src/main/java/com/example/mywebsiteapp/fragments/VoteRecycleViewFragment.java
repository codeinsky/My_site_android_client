package com.example.mywebsiteapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mywebsiteapp.R;
import com.example.mywebsiteapp.adapters.VoteRecycleViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class VoteRecycleViewFragment extends Fragment {

    public VoteRecycleViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vote_recycle_view, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycle_view_vote_report);
        recyclerView.setHasFixedSize(true);
        VoteRecycleViewAdapter adapter = new VoteRecycleViewAdapter();
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        return  view ;
    }
}
