package com.example.practiceexampleforwipro.api;

import com.example.practiceexampleforwipro.model.DataModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

  @GET("facts.json")
  Call<DataModel> getList();
}
