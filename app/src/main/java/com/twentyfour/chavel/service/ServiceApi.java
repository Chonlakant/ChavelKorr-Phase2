package com.twentyfour.chavel.service;

import com.twentyfour.chavel.model.Test;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ServiceApi {

    @GET("2.2/answers?order=desc&sort=activity&site=stackoverflow")
    Call<Test> getAllFilms();


}
