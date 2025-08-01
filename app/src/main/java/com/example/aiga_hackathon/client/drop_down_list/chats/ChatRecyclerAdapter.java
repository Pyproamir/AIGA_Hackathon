package com.example.aiga_hackathon.client.drop_down_list.chats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aiga_hackathon.R;

import java.util.List;

public class ChatRecyclerAdapter extends RecyclerView.Adapter<ChatRecyclerAdapter.ChatViewHolder> {
    private List<ChatItem> chatItems;
    private LayoutInflater inflater;

    public ChatRecyclerAdapter(Context context, List<ChatItem> chatItems) {
        this.chatItems = chatItems;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.chat_item, parent, false); // replace with your layout ID
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        ChatItem chatItem = chatItems.get(position);

        holder.chatItemView.setPFP(chatItem.pfp);
        holder.chatItemView.setUserName(chatItem.userName);
        holder.chatItemView.setMessage(chatItem.message);
        holder.chatItemView.setDateLastMessageArriveTextView(chatItem.dateLastMessageArrive);
        holder.chatItemView.setNumberOfNewMessagesTextView(chatItem.numberOfNewMessages);
    }

    @Override
    public int getItemCount() {
        return chatItems.size();
    }

    public static class ChatViewHolder extends RecyclerView.ViewHolder {
        public ChatItemView chatItemView;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            chatItemView = itemView.findViewById(R.id.ChatItemView);
        }
    }
}

