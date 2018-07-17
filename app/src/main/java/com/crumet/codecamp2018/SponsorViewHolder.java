package com.crumet.codecamp2018;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SponsorViewHolder extends RecyclerView.ViewHolder {
    ImageView img;
    TextView name, type;

    public SponsorViewHolder(@NonNull View v) {
        super(v);
        name = v.findViewById(R.id.sp_name);
        type = v.findViewById(R.id.sp_type);
        img = v.findViewById(R.id.sp_image);
    }
}
