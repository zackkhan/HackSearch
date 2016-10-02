package com.example.zackk.hackumbc;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    private String TAG = "";

    private Firebase fb;
    public FirebaseAuth mAuth;
    public FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Setting up the necessities
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        // Setting up the UI and Code Connections
        logoName = (TextView) findViewById(R.id.logoName2);
        loginField = (ImageView) findViewById(R.id.loginField2);
        emailField = (ImageView) findViewById(R.id.emailField2);
        passwordField = (ImageView) findViewById(R.id.passworField2);
        confirmPasswordField = (ImageView) findViewById(R.id.confirmPasswordField2);
        userIcon = (ImageView) findViewById(R.id.userIcon2);
        emailIcon = (ImageView) findViewById(R.id.mailIcon2);
        unlockedIcon = (ImageView) findViewById(R.id.unlockedIcon2);
        lockedIcon = (ImageView) findViewById(R.id.lockedIcon2);
        usernameText = (EditText) findViewById(R.id.usernameText2);
        emailText = (EditText) findViewById(R.id.emailText2);
        passwordText = (EditText) findViewById(R.id.passworText2);
        confirmPasswordText = (EditText) findViewById(R.id.confirmPasswordText2);
        createAccountButton = (Button) findViewById(R.id.createAccountButton);
        Firebase.setAndroidContext(this);
        fb = new Firebase("https://hackersearch-5723c.firebaseio.com/");
        Typeface merkur = Typeface.createFromAsset(getAssets(), "Merkur.otf");
        Typeface oswald = Typeface.createFromAsset(getAssets(), "Oswald.ttf");
        logoName.setTypeface(merkur);
        emailText.setTypeface(oswald);
        passwordText.setTypeface(oswald);
        confirmPasswordText.setTypeface(oswald);
        usernameText.setTypeface(oswald);
        createAccountButton.setTypeface(oswald);

        // Setup on Click Listener
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (!(passwordText.getText().toString().equals(confirmPasswordText.getText().toString())))
               {
               } else {
                   mAuth.createUserWithEmailAndPassword(emailText.getText().toString(), passwordText.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Toast.makeText(CreateAccountActivity.this, "Logged In Success", Toast.LENGTH_SHORT).show();
                            User newUser = new User (emailText.getText().toString(),usernameText.getText().toString());
                          Firebase fbchild = fb.child("appUser");
                            fbchild.setValue(newUser);
                            Intent login = new Intent(CreateAccountActivity.this, Login.class);
                            startActivity(login);
                            if(!task.isSuccessful()) {
                                Toast.makeText(CreateAccountActivity.this, "Logged In Failed", Toast.LENGTH_SHORT).show();

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
