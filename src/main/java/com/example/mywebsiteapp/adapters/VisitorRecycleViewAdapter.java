package com.example.mywebsiteapp.adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mywebsiteapp.R;
import com.example.mywebsiteapp.holders.VisitorRecycleViewHolder;
import com.example.mywebsiteapp.model.VisitorModel;
import java.util.ArrayList;

public class VisitorRecycleViewAdapter extends RecyclerView.Adapter<VisitorRecycleViewHolder> {

    ArrayList<VisitorModel> visitors;

    public VisitorRecycleViewAdapter(ArrayList<VisitorModel> visitors) {
        this.visitors = visitors;
    }

    @NonNull
    @Override
    public VisitorRecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.visitor_card , parent, false);
        return new VisitorRecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VisitorRecycleViewHolder holder, int position) {
        VisitorModel visitor = visitors.get(position);
        holder.updateView(visitor);

    }

    @Override
    public int getItemCount() {
        return visitors.size();
    }
}
