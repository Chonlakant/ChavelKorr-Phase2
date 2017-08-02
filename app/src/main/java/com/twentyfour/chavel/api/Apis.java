package com.twentyfour.chavel.api;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twentyfour.chavel.service.ServiceApi;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apis {

    private static final long CACHE_SIZE = 10 * 1024 * 1024;    // 10 MB

    private static Retrofit retrofit2 = null;
    public static String BASE_URL = "https://api.stackexchange.com/";

    public static ServiceApi getApis() {

//        Gson gson = new GsonBuilder()
//                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//                .create();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
//                .addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
//                .addInterceptor(proideOffileCacheIntercaptor)
//                .addNetworkInterceptor(new CacheInterceptor())
//                .cache(provideCache())
//                .cache(new Cache(MyApplication.getAppContext().getCacheDir(), CACHE_SIZE))
                .build();


        // Set the custom client when building adapter
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();


        return retrofit.create(ServiceApi.class);
    }


    public static class CacheInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            Response response1 = response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    //cache for 30 days
                    .header("Cache-Control", "max-age=" + 3600 * 24 * 30)
                    .build();
            return response1;
        }
    }


    public static Retrofit getClient() {
        if (retrofit2 == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();


            retrofit2 = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

        }
        return retrofit2;
    }
}