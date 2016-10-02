package com.example.zackk.hackumbc;
import java.util.ArrayList;

public class Hackathon {

    String hackName;
    String webURL;
    String imageURL;
    String startDate;
    String endDate;
    String addressLocality;
    String addressRegion;
    ArrayList<Projects> projectsList = new ArrayList<Projects>();

    public Hackathon(String hackName){
        this.hackName = hackName;
    }

    @Override
    public String toString(){
        return "Name: " + hackName +
                "\nURL: " + webURL +
                "\nimg URL: " + imageURL +
                "\nstart date: " + startDate +
                "\nend date: " + endDate +
                "\naddress locality: " + addressLocality +
                "\naddress region: " + addressRegion;
    }
    public void addProject (Projects p)
    {
        projectsList.add(p);
    }


    public void setWebURL(String webURL){
        this.webURL = webURL;
    }

    public void setImageURL(String imageURL){
        this.imageURL = imageURL;
    }

    public void setStartDate(String startDate){
        this.startDate = startDate;
    }

    public void setEndDate(String endDate){
        this.endDate = endDate;
    }

    public void setAddressLocality(String addressLocality){
        this.addressLocality = addressLocality;
    }

    public void setAddressRegion(String addressRegion){
        this.addressRegion = addressRegion;
    }
}
