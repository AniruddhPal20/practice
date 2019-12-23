package com.example.practiceexampleforwipro.main.presenter;

import android.app.Activity;
import com.example.practiceexampleforwipro.api.ApiInterface;
import com.example.practiceexampleforwipro.base.presenter.MVPPresenter;
import com.example.practiceexampleforwipro.main.view.MainMVPView;

interface MainMVPPresenter<V extends MainMVPView> extends MVPPresenter<V> {

  void callAPI(Activity activity,ApiInterface apiService);
}
