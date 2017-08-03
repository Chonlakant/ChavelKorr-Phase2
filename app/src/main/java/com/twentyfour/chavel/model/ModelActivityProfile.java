package com.twentyfour.chavel.model;

/**
 * Created by Bas on 8/1/2017 AD.
 */

public class ModelActivityProfile {

    String title;
    String content;
    String time;
    String coverUrl;

    public ModelActivityProfile(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String content) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
}
