package com.example.aiga_hackathon.client.events;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.aiga_hackathon.R;
import com.example.aiga_hackathon.client.HomeFragment;
import com.example.aiga_hackathon.client.trainer_list.TrainerListModel;

import java.util.ArrayList;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventsViewHolder> {

    private HomeFragment context; // Context -> HomeFragment
    private List<EventModel> eventList;
    private EventViewModel eventViewModel;

    public EventAdapter(HomeFragment context, List<EventModel> eventList, EventViewModel eventViewModel) { // Context -> HomeFragment
        this.context = context;
        this.eventList = eventList;
        this.eventViewModel = eventViewModel;
    }

    @NonNull
    @Override
    public EventsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false);
        return new EventsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsViewHolder holder, int position) {
        EventModel model = eventList.get(position);
        String liveStr;
        if(model.isLive()){
            liveStr = "Live";
        }else{
            liveStr = "";}
        holder.eventLive.setText(liveStr);

        if (model.isRegisterOpen()) {
            Glide.with(context)
                    .load(R.drawable.ic_register)
                    .into(holder.eventRegister);
        } else {
            holder.eventRegister.setImageDrawable(null); // or use placeholder
        }

        Glide.with(context)
                .load(model.getImageUrlEvent()) // must be url from internet
                .into(holder.eventImage);
        holder.eventName.setText(model.getNameEvent());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public void setEvents(List<EventModel> event){
        this.eventList = new ArrayList<>(event);
        notifyDataSetChanged();
    }

}

class EventsViewHolder extends RecyclerView.ViewHolder{
    ImageView eventImage, eventRegister;
    TextView eventName, eventLive;

    public EventsViewHolder(@NonNull View itemView) {
        super(itemView);
        eventImage = itemView.findViewById(R.id.iv_event_image);
        eventLive = itemView.findViewById(R.id.tx_event_live);
        eventRegister = itemView.findViewById(R.id.ib_event_register);
        eventName = itemView.findViewById(R.id.tx_event_name);
    }
}