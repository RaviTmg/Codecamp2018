package com.crumet.codecamp2018;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Field;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SponsorAdapter extends RecyclerView.Adapter<SponsorViewHolder> {

    private Context context;
    private List<SponsorModel> sponsorModels;

    public SponsorAdapter(Context context, List<SponsorModel> eventList) {
        this.context = context;
        this.sponsorModels = eventList;
    }

    @NonNull
    @Override
    public SponsorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sponsor, parent, false);
        return new SponsorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SponsorViewHolder holder, int position) {
        SponsorModel sponsorModel = sponsorModels.get(position);
        holder.name.setText(sponsorModel.getName());
        holder.type.setText(sponsorModel.getType());

        holder.img.setImageDrawable(context.getResources().getDrawable(sponsorModel.getIcon()));

    }

    static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int getItemCount() {
        return sponsorModels.size();
    }
}
