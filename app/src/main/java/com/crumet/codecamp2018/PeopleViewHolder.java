package com.crumet.codecamp2018;

import android.view.View;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class PeopleViewHolder extends RecyclerView.ViewHolder {
     TextView mTitle, mDetail;
     MaterialCardView cardView;
    PeopleViewHolder(@NonNull View itemView) {
        super(itemView);
        mTitle = itemView.findViewById(R.id.pople_name);
        mDetail = itemView.findViewById(R.id.people_short_detail);
        cardView = itemView.findViewById(R.id.card_people);
    }
}
