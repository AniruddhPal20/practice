package com.example.practiceexampleforwipro.base.presenter;

import com.example.practiceexampleforwipro.base.view.MVPView;

public class BasePresenter<V extends MVPView> implements MVPPresenter<V> {

  private V view;

  @Override public void onAttach(V mvpView) {
    this.view = mvpView;
  }

  @Override public void onDetach() {
    view = null;
  }

  @Override public V getView() {
    return view;
  }
}
