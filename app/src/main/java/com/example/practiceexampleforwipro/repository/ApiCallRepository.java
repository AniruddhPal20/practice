package com.example.practiceexampleforwipro.repository;
import com.example.practiceexampleforwipro.model.DataModel;
import com.example.practiceexampleforwipro.networkservices.ApiCallService;
import com.example.practiceexampleforwipro.retro.RestClient;
import com.example.practiceexampleforwipro.utils.Helper;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCallRepository {

    static String tag = "ApiCallRepository";

    public static void hitApi(final ApiCallRepositoryCallback repositoryCallback)
    {
         ApiCallService ls = RestClient.getRetrofitInstance().create(ApiCallService.class);
        try {
            Call<DataModel> hitApi = ls.initCall();
            hitApi.enqueue(new Callback<DataModel>() {
                @Override
                public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                    Helper.v(tag,"Repo body["+response.body()+"]");
                    Helper.v(tag,"Repo toString["+response.toString()+"]");
                    Helper.v(tag,"Repo message["+response.message()+"]");
                    Helper.v(tag,"Repo raw["+response.raw()+"]");
                    if (response.isSuccessful()) {
                        repositoryCallback.onResponseSuccess(response.body());
                    } else {
                        repositoryCallback.onError("Something went wrong");
                    }
                }

                @Override
                public void onFailure(Call<DataModel> call, Throwable t) {
                    repositoryCallback.onError("Failure:some thing went wrong toString["+ t.toString()+"]");
                    repositoryCallback.onError("Failure:some thing went wrong getMessage["+ t.getMessage()+"]");
                }
            });
        }catch(Exception ex){
            repositoryCallback.onError("Exception : something went wrong");
        }
    }
}
