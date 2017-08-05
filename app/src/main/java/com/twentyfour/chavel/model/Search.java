package com.twentyfour.chavel.model;

/**
 * Created by Bas on 8/5/2017 AD.
 */

public class Search {

    String imageUrl;

    public Search(){

    }


    public Search(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
