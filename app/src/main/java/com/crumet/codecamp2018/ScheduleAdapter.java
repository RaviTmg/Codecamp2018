package com.crumet.codecamp2018;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crumet.codecamp.EventModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleViewHolder> {
    private List<EventModel> eventList;
    private Context context;

    public ScheduleAdapter(List<EventModel> eventList, Context context) {
        this.eventList = eventList;
        this.context = context;
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_timeline,viewGroup,false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ScheduleViewHolder holder, int i) {
        EventModel eventModel = eventList.get(i);
        holder.mTitle.setText(eventModel.getTitle());
        holder.mTime.setText(eventModel.getTime());


        if (i == 0){
            holder.timelineView.setStartLine(Color.rgb(0,0,0), 1);
            holder.timelineView.setMarker(context.getResources().getDrawable(R.drawable.ic_marker_inactive),
                    ContextCompat.getColor(context, R.color.colorAccent));
        }else if(i == 3){
            holder.timelineView.setMarker(context.getResources().getDrawable(R.drawable.ic_marker_active),
                    ContextCompat.getColor(context, R.color.colorAccent));
        }
        else if (i == eventList.size()-1){
            holder.timelineView.setEndLine(Color.rgb(0,0,0), 2);
            holder.timelineView.setMarker(context.getResources().getDrawable(R.drawable.ic_marker_inactive),
                    ContextCompat.getColor(context, R.color.colorAccent));
        }

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}
