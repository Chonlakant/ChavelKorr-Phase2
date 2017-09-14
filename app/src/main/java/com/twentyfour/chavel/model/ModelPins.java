package com.twentyfour.chavel.model;

import org.parceler.Parcel;

/**
 * Created by Bas on 8/1/2017 AD.
 */

@Parcel
public class ModelPins {

    String pins;
    String titlePins;
    String coverUrl;

    public ModelPins(){

    }

    public ModelPins(String pins, String titlePins, String coverUrl) {
        this.pins = pins;
        this.titlePins = titlePins;
        this.coverUrl = coverUrl;
    }

    public String getPins() {
        return pins;
    }

    public void setPins(String pins) {
        this.pins = pins;
    }

    public String getTitlePins() {
        return titlePins;
    }

    public void setTitlePins(String titlePins) {
        this.titlePins = titlePins;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
}
