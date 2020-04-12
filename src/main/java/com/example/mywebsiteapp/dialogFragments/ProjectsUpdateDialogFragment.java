package com.example.mywebsiteapp.dialogFragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
        final EditText projectName = view.findViewById(R.id.project_name_input);
        final EditText projectComment = view.findViewById(R.id.project_comment_input);
        final EditText projectLinks = view.findViewById(R.id.projects_links_input);
        final EditText projectSystems = view.findViewById(R.id.projects_platfroms_input);
        Button createProjectBtn = (Button)view.findViewById(R.id.create_project_btn);
        createProjectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("TEST", "fire post request with new project");
                Log.v("TEST" , projectName.getText().toString() + " , " +
                                         projectComment.getText().toString() + " , " +
                                         projectLinks.getText().toString() + " , " +
                                         projectSystems.getText().toString());

            }
        });
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
