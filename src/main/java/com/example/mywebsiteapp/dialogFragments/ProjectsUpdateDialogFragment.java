package com.example.mywebsiteapp.dialogFragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mywebsiteapp.R;
import com.example.mywebsiteapp.activities.MainActivity;
import com.example.mywebsiteapp.fragments.AboutMeRecycleViewFragment;
import com.example.mywebsiteapp.fragments.ProjectRecycleViewFragment;
import com.example.mywebsiteapp.services.ProjectsService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ProjectsUpdateDialogFragment extends DialogFragment {
    final String baseUrl = "http://10.0.2.2:8181";
    final String createProject = "/android/setproject";
    final String projectFragmentTag = "projectFragmentTag";
    public ProjectsUpdateDialogFragment projectsUpdateDialogFragment = this;
    private EditText projectName;
    private EditText projectComment;
    private EditText projectLinks;
    private EditText projectSystems;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.projects_update_dialog_fragment , container , false);
        ProjectsService.getInstance().getProjectSFromServer(getContext() , this);
        FragmentManager fm = getChildFragmentManager();
        ProjectRecycleViewFragment projectRecycleViewFragment = (ProjectRecycleViewFragment) fm.findFragmentById(R.id.projects_fragment);
        if (projectRecycleViewFragment==null){
            ProjectRecycleViewFragment projectFragment = new ProjectRecycleViewFragment();
            fm.beginTransaction().add(R.id.projects_fragment , projectFragment , projectFragmentTag).commit();
        }
        projectName = view.findViewById(R.id.project_name_input);
        projectComment = view.findViewById(R.id.project_comment_input);
        projectLinks = view.findViewById(R.id.projects_links_input);
        projectSystems = view.findViewById(R.id.projects_platfroms_input);
        Button createProjectBtn = (Button)view.findViewById(R.id.create_project_btn);
        createProjectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url =  baseUrl + createProject;
                JSONObject projectBody = new JSONObject();
                try {
                    projectBody.put("id", null);
                    projectBody.put("name" , projectName.getText().toString());
                    projectBody.put("system",projectSystems.getText().toString());
                    projectBody.put("comment", projectComment.getText().toString());
                    projectBody.put("links" , projectLinks.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.v("TEST", "fire post request with new project");
                Log.v("TEST" , projectName.getText().toString() + " , " +
                                         projectComment.getText().toString() + " , " +
                                         projectLinks.getText().toString() + " , " +
                                         projectSystems.getText().toString());

                JsonObjectRequest createProject = new JsonObjectRequest(Request.Method.POST, url, projectBody, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.v("TEST" , "Project created");
                        clearInputs();
                        Toast.makeText(getContext(), "New project created" , Toast.LENGTH_SHORT).show();
                        ProjectsService.getInstance().getProjectSFromServer(getContext() , projectsUpdateDialogFragment);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("TEST" , "Project creation failed" + error.getMessage());
                        clearInputs();
                        Toast.makeText(getContext() , "Project create failed", Toast.LENGTH_SHORT).show();
                        ProjectsService.getInstance().getProjectSFromServer(getContext() , projectsUpdateDialogFragment);
                    }
                })
                {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String,String> params = new HashMap<String, String>();
                        params.put("Content-Type" , "application/json");
                        params.put("Authorization" , MainActivity.key + MainActivity.jwt);
                        return  params;
                    }
                };
                Volley.newRequestQueue(getContext()).add(createProject);

            }
        });
        Button closeProjectBtn = (Button)view.findViewById(R.id.projects_update_close_btn);
        closeProjectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProjectsUpdateDialogFragment.this.dismiss();
                ProjectsService.projectsFromServer.clear();
            }
        });
        return view;
    }

    public void onDataReceived(){
        Log.v("TEST" , "data has come");
        ProjectRecycleViewFragment projectFragment = (ProjectRecycleViewFragment) getChildFragmentManager().findFragmentByTag(projectFragmentTag);
        getChildFragmentManager().beginTransaction()
                .detach(projectFragment)
                .attach(projectFragment)
                .commit();
    }

    private void clearInputs(){
        projectName.setText("");
        projectComment.setText("");
        projectLinks.setText("");
        projectSystems.setText("");
    }




}
