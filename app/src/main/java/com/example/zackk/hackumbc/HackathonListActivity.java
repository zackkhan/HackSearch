package com.example.zackk.hackumbc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class HackathonListActivity extends AppCompatActivity {

    private Button mainButton;
    public ArrayList<Hackathon> hacks;
    public RecyclerView recyclerView;
    public TextView logoTag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackathon_list);
        System.out.println("lists");
        hacks = Login.hackList;
        //createHacksList();
        recyclerView = (RecyclerView)findViewById(R.id.cards);
        logoTag = (TextView) findViewById(R.id.logoTag);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        CardHolder adapter = new CardHolder(getApplicationContext(),hacks);
        recyclerView.setAdapter(adapter);
    }

    /*protected void createHacksList() {
        mainButton = (Button) findViewById(R.id.main_button);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Button Clicked");
                Intent i = new Intent(HackathonListActivity.this, Login.class);
                startActivity(i);
            }
        });

    }*/
}
