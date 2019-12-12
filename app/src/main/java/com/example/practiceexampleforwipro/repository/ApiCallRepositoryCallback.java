package com.example.practiceexampleforwipro.repository;

import com.example.practiceexampleforwipro.model.DataModel;

import org.json.JSONObject;

public interface ApiCallRepositoryCallback {
    public void onResponseSuccess(DataModel response);
    public void onError(String msg);
}
