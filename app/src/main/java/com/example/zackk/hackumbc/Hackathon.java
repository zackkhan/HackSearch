package com.example.zackk.hackumbc;


/**
 * Created by JideA on 10/1/2016.
 */

public class Hackathon
{
    private double latitude;
    private double longitude;
    private String name;
    private String date;
   Projects proj = new Projects
    
    public Hackathon(double a, double o, String n, String d)
    {
        double latitude = a;
        double longitude = o;
        String name = n;
        String date = d;
    }

    /*
    Sets the variable inside this object to latitude, longitude, name, and date.
    */

    public void setLat(int x)
    {
        latitude = x;
    }

    public void setLon(int x)
    {
        longitude = x;
    }

    public void setName(String x)
    {
        name = x;
    }

    public void setDate(String x)
    {
        date = x;
    }

    /*
     Return statements to return the latitude, longitude, name, and date as well as all the information.
    */

    public double getLatitude()
    {
        return latitude;
    }
    public double getLongitude()
    {
        return longitude;
    }
    public String getName()
    {
        return name;
    }
    public String getDate()
    {
        return date;
    }

    /*
    Shows the attributes of the project in the console. Can be modified and duplicated to show
    elements separately.
     */

    public String toString()
    {
        for (x = 0, x )
        return "Project: " +
    }
    public int numberOfProjects()
    {
        while (proj)
    }
}
