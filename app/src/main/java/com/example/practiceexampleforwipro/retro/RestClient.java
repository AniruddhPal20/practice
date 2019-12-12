package com.example.practiceexampleforwipro.retro;

import com.example.practiceexampleforwipro.apis.WebApisConstants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RestClient {

    public static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl("https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/")
//                    .baseUrl("https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/facts.json/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
