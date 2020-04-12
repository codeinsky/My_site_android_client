package com.example.mywebsiteapp.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mywebsiteapp.R;
import com.example.mywebsiteapp.model.AboutMeModel;

public class AboutMeRecycleViewHolder extends RecyclerView.ViewHolder {

    private TextView id ;
    private TextView section;
    private TextView details;
    private TextView comment;

    public AboutMeRecycleViewHolder(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.about_me_id);
        section = itemView.findViewById(R.id.card_about_me_section);
        details = itemView.findViewById(R.id.card_about_me_details);
        comment = itemView.findViewById(R.id.card_about_me_comment);

    }

    public void  updateAboutMeRecycle(AboutMeModel aboutMeModel){
        id.setText(aboutMeModel.getId());
        section.setText(aboutMeModel.getSection());
        details.setText(aboutMeModel.getDetails());
        comment.setText(aboutMeModel.getComment());
    }
}
