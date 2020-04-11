package com.example.mywebsiteapp.holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mywebsiteapp.R;
import com.example.mywebsiteapp.model.VisitorModel;

public class VisitorRecycleViewHolder extends RecyclerView.ViewHolder {

    private TextView id;
    private TextView ip;
    private TextView comment;
    private TextView date;

    public VisitorRecycleViewHolder(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.card_visitor_id);
        ip = itemView.findViewById(R.id.card_visitor_comment);
        comment = itemView.findViewById(R.id.card_visitor_comment);
        date = itemView.findViewById(R.id.card_visitor_date);

    }

    public void updateView(VisitorModel visitorModel){
        id.setText(visitorModel.getId());
        ip.setText(visitorModel.getIp());
        comment.setText(visitorModel.getComment());
        date.setText(visitorModel.getDate());
    }


}
