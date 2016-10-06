package com.example.zackk.hackumbc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.zackk.hackumbc.R.id.logoTag;

public class ProjectListActivity extends AppCompatActivity {
    public ArrayList<Projects> projectse = new ArrayList<Projects>();
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_list);
        Projects x = new Projects("RC Car Hack", "Building an RC Car to drive itself");
        projectse.add(x);
        recyclerView = (RecyclerView)findViewById(R.id.projects);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),1);
        recyclerView.setLayoutManager(layoutManager);
        ProjectListHolder adapter = new ProjectListHolder(getApplicationContext(),projectse);
       // System.out.println("HELLO" + hacks.get(0).hackName);
        recyclerView.setAdapter(adapter);
    }
}
