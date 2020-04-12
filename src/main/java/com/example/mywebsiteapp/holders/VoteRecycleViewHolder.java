package com.example.mywebsiteapp.holders;

import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mywebsiteapp.R;
import com.example.mywebsiteapp.model.VoteModel;

public class VoteRecycleViewHolder extends RecyclerView.ViewHolder {

    private TextView id;
    private TextView like;
    private TextView date;
    private TextView ip;
    public VoteRecycleViewHolder(@NonNull View itemView) {
        super(itemView);
        this.id = (TextView)itemView.findViewById(R.id.vote_id);
        this.like = (TextView)itemView.findViewById(R.id.vote_result);
        this.date = (TextView)itemView.findViewById(R.id.vote_date);
        this.ip = (TextView)itemView.findViewById(R.id.vote_ip);

    }

    public void updateVoteRecycleView(VoteModel voteModel){
        this.id.setText(String.valueOf(voteModel.getId()));
        if (voteModel.isLiked()) {
            this.like.setText("Like");
        }
        else{
            this.like.setText("Dislike");
        }
        this.date.setText(voteModel.getDate());
        this.ip.setText(voteModel.getIp());
    }
}
