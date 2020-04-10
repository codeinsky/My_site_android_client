package com.example.mywebsiteapp.dialogFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.example.mywebsiteapp.R;
import com.example.mywebsiteapp.fragments.VoteRecycleViewFragment;

public class VotesReportDialogFragment extends DialogFragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.votes_dialog_fragment, container,false);
        FragmentManager fm = getChildFragmentManager();
        VoteRecycleViewFragment voteRecycleViewFragment = (VoteRecycleViewFragment)fm.findFragmentById(R.id.vote_report_fragment);
        if (voteRecycleViewFragment==null) {
            voteRecycleViewFragment = new VoteRecycleViewFragment();
            fm.beginTransaction().add(R.id.vote_report_fragment, voteRecycleViewFragment).commit();
        }

        Button close_dialog = (Button) view.findViewById(R.id.close_btn);
        close_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VotesReportDialogFragment.this.dismiss();
            }
        });
        return  view;
    }
}
