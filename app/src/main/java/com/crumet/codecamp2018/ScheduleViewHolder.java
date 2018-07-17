package com.crumet.codecamp2018;

import android.view.View;
import android.widget.TextView;

import com.github.vipulasri.timelineview.TimelineView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ScheduleViewHolder extends RecyclerView.ViewHolder {
    TimelineView timelineView;
    TextView mTitle, mTime;

    public ScheduleViewHolder(@NonNull View v) {
        super(v);
        timelineView = v.findViewById(R.id.time_marker);
        mTime = v.findViewById(R.id.time);
        mTitle = v.findViewById(R.id.title);
    }
}
