package com.example.practiceexampleforwipro.main.presenter;

import android.app.Activity;
import android.util.Log;
import com.example.practiceexampleforwipro.R;
import com.example.practiceexampleforwipro.api.ApiInterface;
import com.example.practiceexampleforwipro.base.presenter.BasePresenter;
import com.example.practiceexampleforwipro.main.view.MainMVPView;
import com.example.practiceexampleforwipro.model.DataModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter<V extends MainMVPView> extends BasePresenter<V>
    implements MainMVPPresenter<V> {

  @Override public void callAPI(Activity activity,ApiInterface apiService) {

    getView().showLoading();

    Call<DataModel> call = apiService.getList();
    call.enqueue(new Callback<DataModel>() {
      @Override
      public void onResponse(Call<DataModel> call, Response<DataModel> response) {
        getView().showLoading();
        System.out.println("getUsersList Response --> " + response.body());
        getView().displayData(response.body());
      }

      @Override
      public void onFailure(Call<DataModel> call, Throwable t) {
        // Log error here since request failed
        Log.e("", t.toString());
        getView().hideLoading();
        getView().failResponse(activity.getResources().getString(R.string.str_api_error));
      }
    });
  }
}
