package com.afroplatypus.olinia;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    private ListView mMessageRecyclerView;
    private MessageAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setIcon(R.mipmap.ic_launcher);

        LayoutInflater inflator = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.chat_bar, null);

        actionBar.setCustomView(v);


        mMessageRecyclerView = (ListView) findViewById(R.id.list);
        messageAdapter = new MessageAdapter(this, R.layout.message, R.id.msg);
        showMessages((ArrayList<Message>) getIntent().getExtras().get("messages"));
        mMessageRecyclerView.setAdapter(messageAdapter);
    }

    private void showMessages(ArrayList<Message> messages) {
        for (int i = 0; i < messages.size(); ++i) {
            messageAdapter.add(messages.get(i));
        }
    }
}
