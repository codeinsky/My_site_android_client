package com.example.mywebsiteapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mywebsiteapp.R;
import com.example.mywebsiteapp.holders.VoteRecycleViewHolder;
import com.example.mywebsiteapp.model.VoteModel;

import java.util.ArrayList;

public class VoteRecycleViewAdapter extends RecyclerView.Adapter<VoteRecycleViewHolder> {
    private ArrayList<VoteModel> votes;

    public VoteRecycleViewAdapter(ArrayList<VoteModel> vote) {
        this.votes = vote;
    }

    @NonNull
    @Override
    public VoteRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View voteCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.vote_card, parent, false);
        return new VoteRecycleViewHolder(voteCard);
    }

    @Override
    public void onBindViewHolder(@NonNull VoteRecycleViewHolder holder, int position) {
        VoteModel voteModel = votes.get(position);
        holder.updateVoteRecycleView(voteModel);

    }

    @Override
    public int getItemCount() {
      return   votes.size();
    }
}
