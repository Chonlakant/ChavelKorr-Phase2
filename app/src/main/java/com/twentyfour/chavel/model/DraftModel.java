package com.twentyfour.chavel.model;

/**
 * Created by Bas on 9/7/2017 AD.
 */

public class DraftModel {
    String title;
    String details;
    String lat;
    String lang;
    String urlImage;

    public DraftModel(){

    }

    public DraftModel(String title, String details, String lat, String lang, String urlImage) {
        this.title = title;
        this.details = details;
        this.lat = lat;
        this.lang = lang;
        this.urlImage = urlImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
