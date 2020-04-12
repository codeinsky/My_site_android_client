package com.example.mywebsiteapp.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mywebsiteapp.R;
import com.example.mywebsiteapp.holders.AboutMeRecycleViewHolder;
import com.example.mywebsiteapp.model.AboutMeModel;

import java.util.ArrayList;


public class AboutMeRecycleViewAdapter extends RecyclerView.Adapter<AboutMeRecycleViewHolder> {
    ArrayList<AboutMeModel> aboutMes;

    public AboutMeRecycleViewAdapter(ArrayList<AboutMeModel> aboutMes) {
        this.aboutMes = aboutMes;
    }

    @NonNull
    @Override
    public AboutMeRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.aboute_me_card , parent, false);
        final TextView id = view.findViewById(R.id.about_me_id);
        final TextView deleteAboutMe = (TextView)view.findViewById(R.id.delete_about_me);
        deleteAboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("TEST" , "delete " + id.getText().toString());
            }
        });
        return new AboutMeRecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AboutMeRecycleViewHolder holder, int position) {
        AboutMeModel aboutMe = aboutMes.get(position);
        holder.updateAboutMeRecycle(aboutMe);

    }

    @Override
    public int getItemCount() {
        return aboutMes.size();
    }
}
