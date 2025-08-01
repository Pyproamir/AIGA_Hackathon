package com.example.aiga_hackathon.client.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aiga_hackathon.R;

import java.util.List;

public class MessageRecycleAdapter extends RecyclerView.Adapter<MessageRecycleAdapter.MessageViewHolder>{

    private List<MessageItem> messageItems;
    private LayoutInflater inflater;

    public MessageRecycleAdapter(Context context, List<MessageItem> messageItems) {
        this.messageItems = messageItems;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MessageRecycleAdapter.MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.message_item, parent, false); // replace with your layout ID
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        MessageItem messageItem = messageItems.get(position);

        holder.messageView.setMessageText(messageItem.getMessage());
        holder.messageView.setMessageTime(messageItem.getTime());
        holder.messageView.setIsAuthor(messageItem.getAuthorIsUser());
    }

    @Override
    public int getItemCount() {
        return messageItems.size();
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder{
        public MessageView messageView;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            messageView = itemView.findViewById(R.id.MessageView);
        }
    }
}
