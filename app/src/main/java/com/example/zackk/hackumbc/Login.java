package com.example.zackk.hackumbc;

import android.graphics.Typeface;
import android.media.Image;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.R.attr.id;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import static android.R.attr.password;

public class Login extends AppCompatActivity {

    private Button signInButton;
    private Button createAccount;
    private TextView logoName;
    private ImageView profilePic;
    private ImageView usernameField;
    private ImageView lockedIcon;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "";
    public String email;
    public String password;
    private EditText username;
    private EditText passw;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Necessary to Connect Code to UI
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Connecting the UI to the variables
        signInButton = (Button) findViewById(R.id.signInButton);
        createAccount = (Button) findViewById(R.id.createAccountButton);
        username = (EditText) findViewById(R.id.usernameTexts);
        usernameField =(ImageView) findViewById(R.id.usernameField);
        passw = (EditText) findViewById(R.id.passwordTexts);
        logoName = (TextView) findViewById(R.id.logoName);
        profilePic = (ImageView) findViewById(R.id.profileIcon);
        lockedIcon = (ImageView) findViewById(R.id.lockedIcon);


        Typeface merkur = Typeface.createFromAsset(getAssets(), "Merkur.otf");
        Typeface oswald = Typeface.createFromAsset(getAssets(), "Oswald.ttf");
        Typeface lang = Typeface.createFromAsset(getAssets(), "Lantinghei.ttc");
        logoName.setTypeface(merkur);
        createAccount.setTypeface(oswald);
        username.setTypeface(oswald);
        passw.setTypeface(oswald);
        signInButton.setTypeface(lang);



        // On-Click Listeners
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signInWithEmailAndPassword(username.getText().toString(), passw.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Intent go = new Intent(Login.this, LoadingScreen.class);
                        startActivity(go);
                        if (!task.isSuccessful()) {
                            Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(Login.this, CreateAccountActivity.class);
                startActivity(go);
                System.out.println("Login");
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