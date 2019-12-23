package com.example.practiceexampleforwipro.base.presenter;

import com.example.practiceexampleforwipro.base.view.MVPView;

public interface MVPPresenter<V extends MVPView> {

  void onAttach(V mvpView);

  void onDetach();

  V getView();
}
