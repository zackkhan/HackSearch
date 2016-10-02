package com.example.zackk.hackumbc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateProject extends AppCompatActivity {
    private EditText newHackName;
    private EditText newHackDescription;
    private Button newProjectButton;
    public Projects newProject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_project);
        newHackName = (EditText) findViewById(R.id.newHackName);
        newHackDescription = (EditText) findViewById(R.id.newProjectDescription);
        newProjectButton = (Button) findViewById(R.id.newProjectButton);
        newProjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newProject = new Projects (newHackName.getText().toString(), newHackDescription.getText().toString());
                Login.hackList.get(HackathonListActivity.chosenHackathon).addProject(newProject);
               // Intent p = new Intent(CreateProject.this, )
            }

        });

    }
}
