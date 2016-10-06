package com.example.zackk.hackumbc;

import android.graphics.Typeface;

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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Login extends AppCompatActivity {

    private Button signInButton;
    private Button createAccount;
    private TextView logoName;
    private ImageView profilePic;
    private ImageView usernameField;
    private ImageView passwordField;
    private ImageView lockedIcon;
    public FirebaseAuth mAuth;
    public FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "";
    public String email;
    public String password;
    private EditText username;
    private EditText passw;
    private String x;
    public static int CurrentHackathon;


<<<<<<< HEAD
    static ArrayList<Hackathon> hackList = new ArrayList<Hackathon>();
=======
    public static ArrayList<Hackathon> hackList;
>>>>>>> master
    String hackHTML;
    String hackurl = "https://mlh.io/seasons/s2016/events";

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
        passwordField = (ImageView) findViewById(R.id.passworField2);



        Typeface merkur = Typeface.createFromAsset(getAssets(), "Merkur.otf");
        Typeface oswald = Typeface.createFromAsset(getAssets(), "Oswald.ttf");
        Typeface lang = Typeface.createFromAsset(getAssets(), "Lantinghei.ttc");
        logoName.setTypeface(merkur);
        createAccount.setTypeface(oswald);
        username.setTypeface(oswald);
        passw.setTypeface(oswald);
        signInButton.setTypeface(oswald);

        // Execute Hackathon Load
        final AsyncTask<String, Void, String> execute = new RetrieveFeedTask().execute();




<<<<<<< HEAD

=======
>>>>>>> master
        // On-Click Listeners
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                mAuth.signInWithEmailAndPassword(username.getText().toString(), passw.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        createHackathons(hackHTML);
                        Intent go = new Intent(Login.this, HackathonListActivity.class);
                        startActivity(go);
                        Toast.makeText(Login.this, "Login PAssed", Toast.LENGTH_SHORT).show();
=======
<<<<<<< HEAD
                createHackathons(hackHTML);
                search("hack");

                mAuth.signInWithEmailAndPassword(username.getText().toString(), passw.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Intent go = new Intent(Login.this, HackathonListActivity.class);
                        startActivity(go);
=======
                mAuth.signInWithEmailAndPassword(username.getText().toString(), passw.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       // Intent go = new Intent(Login.this, LoadingScreen.class);
                        //startActivity(go);
>>>>>>> zackkhan/master
>>>>>>> master
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
               // System.out.println("Login");
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

    public void createHackathons(String html){
        for (int i = 0;i < html.length() - 16;i++){
            String construct = "";
            if (html.substring(i, i + 16).equals("itemprop=\"name\">")){
                i += 16;
                while(!html.substring(i, i + 1).equals("<")){
                    construct += html.substring(i, i + 1);
                    i++;
                }
                hackList.add(new Hackathon(construct));
            }
        }
        fillHackathonFields(hackHTML);
        for (Hackathon name:hackList){
            System.out.println(name);
        }
    }
    public void fillHackathonFields(String html){
        int elementIndex = -1;
        int srcCount = 0;
        for (int i = 0;i < html.length() - 36;i++){
            if (html.substring(i, i + 13).equals("event-wrapper")){
                elementIndex++;
                i += 13;
            }
            if (elementIndex > -1){
                if (html.substring(i, i + 9).equals("<a href=\"")){
                    String construct = "";
                    i += 9;
                    while(!html.substring(i, i + 1).equals("\"")){
                        construct += html.substring(i, i + 1);
                        i++;
                    }
                    hackList.get(elementIndex).setWebURL(construct);
                }
                if (html.substring(i, i + 5).equals("src=\"")){
                    srcCount++;
                    if (srcCount == 2){
                        srcCount = 0;
                        String construct = "";
                        i += 5;
                        while(!html.substring(i, i + 1).equals("\"")){
                            construct += html.substring(i, i + 1);
                            i++;
                        }
                        hackList.get(elementIndex).setImageURL(construct);
                    }
                }
                if (html.substring(i, i + 36).equals("<meta itemprop=\"startDate\" content=\"")){
                    String construct = "";
                    i += 36;
                    while(!html.substring(i, i + 1).equals("\"")){
                        construct += html.substring(i, i + 1);
                        i++;
                    }
                    hackList.get(elementIndex).setStartDate(construct);
                }
                if (html.substring(i, i + 34).equals("<meta itemprop=\"endDate\" content=\"")){
                    String construct = "";
                    i += 34;
                    while(!html.substring(i, i + 1).equals("\"")){
                        construct += html.substring(i, i + 1);
                        i++;
                    }
                    hackList.get(elementIndex).setEndDate(construct);
                }
                if (html.substring(i, i + 33).equals("<span itemprop=\"addressLocality\">")){
                    String construct = "";
                    i += 33;
                    while(!html.substring(i, i + 1).equals("<")){
                        construct += html.substring(i, i + 1);
                        i++;
                    }
                    hackList.get(elementIndex).setAddressLocality(construct);
                }
                if (html.substring(i, i + 31).equals("<span itemprop=\"addressRegion\">")){
                    String construct = "";
                    i += 31;
                    while(!html.substring(i, i + 1).equals("<")){
                        construct += html.substring(i, i + 1);
                        i++;
                    }
                    hackList.get(elementIndex).setAddressRegion(construct);
                }

            }
        }
    }

    protected static void search(String stringSearch){
        int len = stringSearch.length();
        for (Hackathon hackathon: hackList){
            String testString = hackathon.toString();
            System.out.println("found" + testString);
            for(int i = 0;i < testString.length();i++){
                if(testString.substring(i,i + len).toLowerCase().equals(stringSearch.toLowerCase())){

                }
            }
        }
    }

    private class RetrieveFeedTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            URL url;
            HttpURLConnection connection; // actual connection to web page
            BufferedReader BR; // read from web page
            String line; // An individual line of the web page HTML
            String result = ""; // A long string containing all the HTML
            try {
                url = new URL(hackurl);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("User-Agent", "Mozilla/5.0");
                connection.setRequestMethod("GET");
                BR = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = BR.readLine()) != null) {
                    result += line;
                }
                BR.close();
            } catch (Exception e) {
                Log.d("help", "d");
                e.printStackTrace();
            }
            hackHTML = result;
            return result;
        }
    }

}