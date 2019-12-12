package com.example.practiceexampleforwipro.presenter;

import com.example.practiceexampleforwipro.interfaces.ApiCallContract;
import com.example.practiceexampleforwipro.model.DataModel;
import com.example.practiceexampleforwipro.repository.ApiCallRepository;
import com.example.practiceexampleforwipro.repository.ApiCallRepositoryCallback;

public class ApiCallPresenter implements ApiCallContract.ApiCallPresenter {

    ApiCallContract.ApiCallView apiCallView;

    public ApiCallPresenter(ApiCallContract.ApiCallView apiCallView) {
        this.apiCallView = apiCallView;
    }

    @Override
    public void hitApiCall() {
        ApiCallRepository.hitApi(new ApiCallRepositoryCallback() {
            @Override
            public void onResponseSuccess(DataModel response) {
                apiCallView.successResponse(response);
            }

            @Override
            public void onError(String failedMessage) {
                apiCallView.failResponse("Api called failed with : "+failedMessage);
            }
        });

    }
}
