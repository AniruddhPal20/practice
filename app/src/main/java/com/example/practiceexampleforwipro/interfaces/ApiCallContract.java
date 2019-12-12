package com.example.practiceexampleforwipro.interfaces;

import com.example.practiceexampleforwipro.model.DataModel;

import org.json.JSONObject;

public interface ApiCallContract {
    interface ApiCallPresenter{
         void hitApiCall();
    }

    interface ApiCallView{
        void successResponse(DataModel response);
        void failResponse(String failMessage);
    }
}
