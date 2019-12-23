package com.example.practiceexampleforwipro.main.view;

import com.example.practiceexampleforwipro.base.view.MVPView;
import com.example.practiceexampleforwipro.model.DataModel;

public interface MainMVPView extends MVPView {

  void displayData(DataModel dataModel);

  void failResponse(String message);
}
