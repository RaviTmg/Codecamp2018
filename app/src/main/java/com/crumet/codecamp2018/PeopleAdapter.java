package com.crumet.codecamp2018;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleViewHolder> {
    private  Context context;
    private List<TeamModel> teamModels;
    private int tab;

    public PeopleAdapter(Context context, List<TeamModel> teamModels, int tab) {
        this.context = context;
        this.teamModels = teamModels;
        this.tab = tab;
    }

    public PeopleAdapter(Context context, List<TeamModel> teamModels) {
        this.context = context;
        this.teamModels = teamModels;
    }

    @NonNull
    @Override
    public PeopleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_people,parent,false);
        return new PeopleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleViewHolder holder, final int position) {
        TeamModel eventModel = teamModels.get(position);
        holder.mTitle.setText(eventModel.getName());
        holder.mDetail.setText(eventModel.getShortDetail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                if (tab == 0) {
                    intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra("tab", tab);
                    intent.putExtra("pos", position);
                    context.startActivity(intent);
                }
                else
                    intent = new Intent(context,GuestDetailsActivity.class);

            }
        });
    }

    @Override
    public int getItemCount() {
        return teamModels.size();
    }
}
