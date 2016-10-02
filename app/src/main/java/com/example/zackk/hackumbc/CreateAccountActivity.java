package com.example.zackk.hackumbc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CreateAccountActivity extends AppCompatActivity {
    public TextView logoName;
    public ImageView loginField;
    public ImageView emailField;
    public ImageView passwordField;
    public ImageView confirmPasswordField;
    public ImageView userIcon;
    public ImageView unlockedIcon;
    public ImageView lockedIcon;
    public ImageView emailIcon;
    public EditText usernameText;
    public EditText emailText;
    public EditText passwordText;
    public EditText confirmPasswordText;
    public TextView warningText;
    public Button createAccountButton;
    private FirebaseAuth mAuth;
    private String TAG = "";
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Firebase fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Setting up the necessities
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        // Setting up the UI and Code Connections
        logoName = (TextView) findViewById(R.id.logoName);
        loginField = (ImageView) findViewById(R.id.loginField);
        emailField = (ImageView) findViewById(R.id.emailField);
        passwordField = (ImageView) findViewById(R.id.passwordField);
        confirmPasswordField = (ImageView) findViewById(R.id.confirmPasswordField);
        userIcon = (ImageView) findViewById(R.id.userIcon);
        emailIcon = (ImageView) findViewById(R.id.mailIcon);
        unlockedIcon = (ImageView) findViewById(R.id.unlockedIcon);
        lockedIcon = (ImageView) findViewById(R.id.lockedIcon);
        usernameText = (EditText) findViewById(R.id.usernameText);
        emailText = (EditText) findViewById(R.id.emailText);
        passwordText = (EditText) findViewById(R.id.passwordField);
        confirmPasswordText = (EditText) findViewById(R.id.confirmPasswordText);
        createAccountButton = (Button) findViewById(R.id.createAccountButton);
        warningText = (TextView) findViewById(R.id.warningText);
        warningText.setText("");

        // Setup on Click Listener
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(passwordText.getText().equals(confirmPasswordText))) {
                    warningText.setText("Passwords Don't Match. Please Try Again!");
                } else {
                    mAuth.createUserWithEmailAndPassword(emailText.getText().toString(), passwordText.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            fb = new Firebase("https://hackersearch-5723c.firebaseio.com/");
                          Firebase fbchild = fb.child("user");
                            fbchild.setValue(emailText.getText().toString());
                            Intent login = new Intent(CreateAccountActivity.this, Login.class);
                            startActivity(login);
                            if(!task.isSuccessful()) {
                                warningText.setText("Invalid Input. Please Try Again");
                            }
                        }
                    });
                }

            }
        });

        // Firebase
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };


    }


    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }



}
