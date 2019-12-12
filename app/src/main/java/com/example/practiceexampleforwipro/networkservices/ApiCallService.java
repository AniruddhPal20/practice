package com.example.practiceexampleforwipro.networkservices;
import com.example.practiceexampleforwipro.model.DataModel;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
public interface ApiCallService {
    @GET("facts.json")
    Call<DataModel> initCall();
}
