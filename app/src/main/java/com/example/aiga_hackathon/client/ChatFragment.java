package com.example.aiga_hackathon.client;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aiga_hackathon.R;
import com.example.aiga_hackathon.client.drop_down_list.chats.ChatItem;
import com.example.aiga_hackathon.client.drop_down_list.chats.ChatRecyclerAdapter;
import com.example.aiga_hackathon.client.story_view.StoryAdapter;
import com.example.aiga_hackathon.client.story_view.StoryItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ChatFragment() {}

    public static ChatFragment newInstance(String param1, String param2) {
        ChatFragment fragment = new ChatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView storyLent = view.findViewById(R.id.StoryLent);
        storyLent.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<StoryItem> storyItems = new ArrayList<>();
        storyItems.add(new StoryItem(getContext(), "Your Story", R.drawable.ic_plus, false));
        storyItems.add(new StoryItem(getContext(), "Argyn", R.drawable.amir));
        storyItems.add(new StoryItem(getContext(), "Aligaziz", R.drawable.amir));
        storyItems.add(new StoryItem(getContext(), "Eyrsal", R.drawable.amir));
        storyItems.add(new StoryItem(getContext(), "Ibrahim", R.drawable.amir));
        storyItems.add(new StoryItem(getContext(), "Maga", R.drawable.amir));
        storyItems.add(new StoryItem(getContext(), "Adele", R.drawable.amir));

        StoryAdapter storyAdapter = new StoryAdapter(getContext(), storyItems);
        storyLent.setAdapter(storyAdapter);

        RecyclerView chatLent = view.findViewById(R.id.ChatLent);
        List<ChatItem> chatItems = new ArrayList<>();

        chatItems.add(new ChatItem(
                ContextCompat.getDrawable(getContext(), R.drawable.ic_trainer),
                "Amir",
                "I wanna ask you out",
                "1",
                "Today"));

        chatItems.add(new ChatItem(
                ContextCompat.getDrawable(getContext(), R.drawable.auditory),
                "Aligaziz",
                "WHATZ UP",
                "1",
                "Today"));

        chatItems.add(new ChatItem(
                ContextCompat.getDrawable(getContext(), R.drawable.amir),
                "Yersal",
                "Го вало",
                "99",
                "Today"));

        chatItems.add(new ChatItem(
                ContextCompat.getDrawable(getContext(), R.drawable.amir),
                "Magzhan",
                "I love Valo",
                "12",
                "Today"));

        chatItems.add(new ChatItem(
                ContextCompat.getDrawable(getContext(), R.drawable.amir),
                "Cyboo2010",
                "I love Valo",
                "2",
                "Today"));

        chatItems.add(new ChatItem(
                ContextCompat.getDrawable(getContext(), R.drawable.amir),
                "Arsen",
                "Almaty is world capital",
                "1",
                "Today"));

        ChatRecyclerAdapter chatAdapter = new ChatRecyclerAdapter(
                getContext(),
                chatItems
        );

        chatLent.setLayoutManager(new LinearLayoutManager(getContext()));
        chatLent.setAdapter(chatAdapter);

    }
}