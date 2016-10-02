package com.example.zackk.hackumbc;

/**
 * Created by JideA on 10/1/2016.
 */

public class Projects
{
    Hackathon h;
    String name = null;
    String description = null;
    public Projects(String n, String d)
    {
        name = n;
        description = d;
    }

    public void setName(String x)
    {
        name = x;
    }

    public void setDescription(String x)
    {
        description = x;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }
}
