package com.example.zackk.hackumbc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lyft.lyftbutton.LyftButton;
import com.lyft.lyftbutton.RideParams;
import com.lyft.lyftbutton.RideTypeEnum;
import com.lyft.networking.ApiConfig;

import static android.R.attr.onClick;

public class HackathonDetails extends AppCompatActivity {
    public TextView hackName;
    public TextView Date;
    public TextView city;
    public TextView site;
    public static int currHackathon;
    public static double lat;
    public static double longi;
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

        currHackathon = HackathonListActivity.chosenHackathon;
        lyftMeUp();


        ApiConfig apiConfig = new ApiConfig.Builder()
                .setClientId("your_client_id")
                .setClientToken("your_client_token")
                .build();

        LyftButton lyftButton = (LyftButton) findViewById(R.id.lyft_button);
        lyftButton.setApiConfig(apiConfig);

        RideParams.Builder rideParamsBuilder = new RideParams.Builder()
                .setPickupLocation(39.253772, -76.714279)
                .setDropoffLocation(lat, longi);
        rideParamsBuilder.setRideTypeEnum(RideTypeEnum.CLASSIC);

        lyftButton.setRideParams(rideParamsBuilder.build());
        lyftButton.load();
        


        noTeam = (Button) findViewById(R.id.noTeam);
        noTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HackathonDetails.this, "This feature is yet to be implemented!", Toast.LENGTH_LONG).show();
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

    public  void lyftMeUp() {
        if(currHackathon == 0) {
            lat = 29.720477;
            longi = -95.396287;
        } else if (currHackathon == 1) {
            lat = 28.602380;
            longi = -81.198880;
        } else if (currHackathon == 2) {
            lat = 44.044152;
            longi = -123.072584;
        }
    }



}
