package com.twentyfour.chavel.model;

/**
 * Created by Bas on 9/13/2017 AD.
 */

public class Location {
    String contry;
    String city;

    public Location(){

    }

    public Location(String contry, String city) {
        this.contry = contry;
        this.city = city;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
