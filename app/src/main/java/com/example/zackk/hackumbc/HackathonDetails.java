package com.example.zackk.hackumbc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.onClick;

public class HackathonDetails extends AppCompatActivity {
    public TextView hackName;
    public TextView Date;
    public TextView city;
    public TextView site;
public Button b;
    private Button noTeam;
    private Button haveTeam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackathon_details);
        hackName = (TextView) findViewById(R.id.hackName);
        haveTeam = (Button) findViewById(R.id.haveTeam);
        hackName.setText(Login.hackList.get(HackathonListActivity.chosenHackathon).hackName.toString());
        Date = (TextView) findViewById(R.id.Date);
        Date.setText(Login.hackList.get(HackathonListActivity.chosenHackathon).startDate.toString());
       city= (TextView) findViewById(R.id.city);
       city.setText(Login.hackList.get(HackathonListActivity.chosenHackathon).addressLocality.toString());
        site = (TextView) findViewById(R.id.site);
        site.setText(Login.hackList.get(HackathonListActivity.chosenHackathon).webURL.toString());

        


        noTeam = (Button) findViewById(R.id.noTeam);
        noTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(HackathonDetails.this, JoinProject.class);
                startActivity(x);
            }
        });
        haveTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent y = new Intent(HackathonDetails.this, CreateProject.class);
                startActivity(y);
            }
        });

    }
}
