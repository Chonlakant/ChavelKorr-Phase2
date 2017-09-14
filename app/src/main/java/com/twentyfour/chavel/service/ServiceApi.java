package com.twentyfour.chavel.service;

import com.twentyfour.chavel.model.HomeFeed;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ServiceApi {


    @FormUrlEncoded
    @POST("public/v1/listRoutesFeed")
    Call<HomeFeed> getFeedHome(@Field("user_id") String user_id,@Field("latitude") String latitude,@Field("longitude") String longitude);



}
