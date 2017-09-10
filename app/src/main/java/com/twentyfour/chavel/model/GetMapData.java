package com.twentyfour.chavel.model;

/**
 * Created by Bas on 9/9/2017 AD.
 */

public class GetMapData {
    double latitude;
    double longitude;

    public GetMapData(){

    }

    public GetMapData(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}

