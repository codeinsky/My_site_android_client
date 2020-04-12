package com.example.mywebsiteapp.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mywebsiteapp.R;
import com.example.mywebsiteapp.model.ProjectModel;

public class ProjectRecycleViewHolder extends RecyclerView.ViewHolder {

    private TextView id ;
    private TextView name;
    private TextView comment;
    private TextView links;
    private TextView system;
    public ProjectRecycleViewHolder(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.card_project_id);
        name = itemView.findViewById(R.id.card_project_name);
        comment = itemView.findViewById(R.id.card_project_comment);
        links = itemView.findViewById(R.id.card_project_link);
        system = itemView.findViewById(R.id.card_project_system);

    }

    public void updateProjectCardView(ProjectModel projectModel){
        id.setText(projectModel.getId());
        name.setText(projectModel.getName());
        comment.setText(projectModel.getComment());
        links.setText(projectModel.getLinks());
        system.setText(projectModel.getSystem());
    }
}
