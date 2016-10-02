package com.example.zackk.hackumbc;

/**
 * Created by zackk on 10/2/2016.
 */

public class User {
   public String email;
    String username;
    Projects currentProject;
    public User(String emaill, String usernamee) {
       email = emaill;
        username = usernamee;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String inputEmail)
    {
        email = inputEmail;
    }
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String inputUsername)
    {
       username = inputUsername;
    }


}
