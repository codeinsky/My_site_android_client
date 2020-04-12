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
import com.example.mywebsiteapp.fragments.ProjectRecycleViewFragment;

public class ProjectsUpdateDialogFragment extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.projects_update_dialog_fragment , container , false);
        FragmentManager fm = getChildFragmentManager();
        ProjectRecycleViewFragment projectRecycleViewFragment = (ProjectRecycleViewFragment) fm.findFragmentById(R.id.projects_fragment);
        if (projectRecycleViewFragment==null){
            ProjectRecycleViewFragment projectFragment = new ProjectRecycleViewFragment();
            fm.beginTransaction().add(R.id.projects_fragment , projectFragment).commit();
        }

        Button closeProjectBtn = (Button)view.findViewById(R.id.projects_update_close_btn);
        closeProjectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProjectsUpdateDialogFragment.this.dismiss();
            }
        });
        return view;
    }
}
