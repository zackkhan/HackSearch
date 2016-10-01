package com.example.zackk.hackumbc;
import java.util.ArrayList;


/**
 * Created by JideA on 10/1/2016.
 */

public class Hackathon
{
    private int z = 0;
    private double latitude;
    private double longitude;
    private String name;
    private String date;
    private String pn;
    private String pd;
    Projects proj = new Projects(pn, pd);
    ArrayList projectArray = new ArrayList<Projects>();


    public Hackathon(double a, double o, String n, String d, Projects p)
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
}
