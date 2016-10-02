package com.example.zackk.hackumbc;

import android.location.Location;
import android.location.LocationManager;
/**
 * Created by JideA on 10/2/2016.
 */

public class LocationTest {
    Locale.LocationResult locationResult = new Locale.LocationResult(){
        @Override
        public void gotLocation(Location location){
            //Got the location!
        }
    };
    Locale myLocation = new Locale();


}
