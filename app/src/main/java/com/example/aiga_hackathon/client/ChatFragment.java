package com.example.aiga_hackathon.client;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aiga_hackathon.R;
import com.example.aiga_hackathon.client.chat.ChatView;
import com.example.aiga_hackathon.client.chat.MessageItem;
import com.example.aiga_hackathon.client.chat.MessageRecycleAdapter;
import com.example.aiga_hackathon.client.drop_down_list.chats.ChatItem;
import com.example.aiga_hackathon.client.drop_down_list.chats.ChatRecyclerAdapter;
import com.example.aiga_hackathon.client.story_view.StoryAdapter;
import com.example.aiga_hackathon.client.story_view.StoryItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatFragment extends Fragment {

    private RecyclerView storyLent;
    private StoryAdapter storyAdapter;
    private StoryAdapter.OnStoryClickListener onStoryClickListener;

    private RecyclerView chatLent;
    private ChatRecyclerAdapter chatAdapter;
    private ChatRecyclerAdapter.OnChatClickListener onChatClickListener;



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

        List<MessageItem> messageItemsTest = new ArrayList<MessageItem>();
        messageItemsTest.add(new MessageItem(
                "Hello",
                new Time(12, 12, 00),
                false
                ));

        BottomNavigationView navBar = requireActivity().findViewById(R.id.client_bottom_nav);

        LinearLayout fragmentFullscreen = view.findViewById(R.id.ChatLayout);

        FrameLayout storyFullscreen = view.findViewById(R.id.story_fullscreen_container);
        ImageView storyImage = view.findViewById(R.id.story_image);
        ProgressBar progressBar = view.findViewById(R.id.story_progress);

        FrameLayout chatFullscreen = view.findViewById(R.id.chat_fullscreen_container);
        ChatView chatView = view.findViewById(R.id.ChatView);

        chatView.setBackButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storyFullscreen.setVisibility(View.GONE);
                chatFullscreen.setVisibility(View.GONE);
                fragmentFullscreen.setVisibility(View.VISIBLE);
                navBar.setVisibility(View.VISIBLE);
            }
        });

        storyLent = view.findViewById(R.id.StoryLent);
        storyLent.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        onChatClickListener = new ChatRecyclerAdapter.OnChatClickListener() {
            @Override
            public void onChatClickListener(ChatItem chatItem, int position) {
                MessageRecycleAdapter messageRecycleAdapter = new MessageRecycleAdapter(
                        getContext(),
                        messageItemsTest
                );

                chatItem.numberOfNewMessages = "0";
                chatAdapter.notifyDataSetChanged();

                chatView.setChatPFP(chatItem.pfp);
                chatView.setUserName(chatItem.userName);
                chatView.setMessagesRecyclerAdapter(messageRecycleAdapter);

                fragmentFullscreen.setVisibility(View.GONE);
                navBar.setVisibility(View.GONE);
                chatFullscreen.setVisibility(View.VISIBLE);
            }
        };

        chatLent = view.findViewById(R.id.ChatLent);
        chatLent.setLayoutManager(new LinearLayoutManager(getContext()));

        onStoryClickListener = new StoryAdapter.OnStoryClickListener() {
            @Override
            public void onStoryClick(StoryItem storyItem, int position) {
                if(position == 0) return;

                navBar.setVisibility(View.GONE);
                fragmentFullscreen.setVisibility(View.GONE);
                storyImage.setImageDrawable(ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.amir));

                storyFullscreen.setAlpha(0f);
                storyFullscreen.setVisibility(View.INVISIBLE); // Сначала невидим

                storyFullscreen.post(() -> {
                    storyFullscreen.setTranslationY(-storyFullscreen.getHeight());
                    storyFullscreen.setVisibility(View.VISIBLE);

                    storyFullscreen.animate()
                            .translationY(0f)
                            .alpha(1f)
                            .setDuration(400)
                            .setInterpolator(new FastOutLinearInInterpolator())
                            .start();
                });


                progressBar.setProgress(0);
                ObjectAnimator animator = ObjectAnimator.ofInt(progressBar, "progress", 0, 100);
                animator.setDuration(3000);
                animator.start();

                new Handler().postDelayed(() -> {
                    fragmentFullscreen.setVisibility(View.VISIBLE);
                    navBar.setVisibility(View.VISIBLE);
                    storyFullscreen.setVisibility(View.GONE);
                }, 3000);
            }
        };

        SetStories();
        SetChatItems();



    }

    private void SetStories(){
        ArrayList<StoryItem> storyItems = new ArrayList<>();
        storyItems.add(new StoryItem(getContext(), "Your Story", R.drawable.plus_icon, false));

        storyAdapter = new StoryAdapter(
                getContext(),
                storyItems,
                onStoryClickListener
        );
        storyLent.setAdapter(storyAdapter);
    }

    private void SetChatItems(){
        List<ChatItem> chatItems = new ArrayList<>();

        chatItems.add(new ChatItem(
                ContextCompat.getDrawable(getContext(), R.drawable.ic_trainer),
                "Amir",
                "Hello",
                "1",
                "Today"));

        chatAdapter = new ChatRecyclerAdapter(
                getContext(),
                chatItems,
                onChatClickListener
        );


        chatLent.setAdapter(chatAdapter);
    }
}