package com.example.zackk.hackumbc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HackathonListActivity extends AppCompatActivity {

    private Button mainButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackathon_list);

        mainButton = (Button) findViewById(R.id.main_button);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Button Clicked");
                Intent i = new Intent(HackathonListActivity.this, Login.class);
                startActivity(i);
            }
        });

        createHacksList();
    }

    protected void createHacksList() {

    }
}
