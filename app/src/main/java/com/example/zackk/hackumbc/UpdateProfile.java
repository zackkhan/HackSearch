package com.example.zackk.hackumbc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.firebase.client.Firebase;


public class UpdateProfile extends AppCompatActivity {
private Firebase fb;
    private Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        Firebase.setAndroidContext(this);
        b = (Button) findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fb = new Firebase("https://hackersearch-5723c.firebaseio.com/");
                Firebase fbchild = fb.child("Displayname");
                fbchild.setValue("Zack");
            }
        });






    }

}
