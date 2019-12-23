package com.example.practiceexampleforwipro.main.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.practiceexampleforwipro.R;
import com.example.practiceexampleforwipro.adapter.ApiCallAdapter;
import com.example.practiceexampleforwipro.api.ApiClient;
import com.example.practiceexampleforwipro.api.ApiInterface;
import com.example.practiceexampleforwipro.base.view.BaseActivity;
import com.example.practiceexampleforwipro.main.presenter.MainPresenter;
import com.example.practiceexampleforwipro.model.DataModel;
import com.example.practiceexampleforwipro.model.RowDataItem;
import com.example.practiceexampleforwipro.utils.CommonDataUtility;
import java.util.ArrayList;

public class MainActivity extends BaseActivity implements MainMVPView {

  @BindView(R.id.header_name)
  TextView headerName;
  @BindView(R.id.recycleView)
  RecyclerView recycleView;
  @BindView(R.id.progressbar)
  ProgressBar progressbar;
  @BindView(R.id.pullToRefresh)
  SwipeRefreshLayout pullToRefresh;

  private MainPresenter<MainMVPView> presenter;
  private ApiInterface apiService;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    presenter = new MainPresenter<>();
    presenter.onAttach(this);

    initUI();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    presenter.onDetach();
  }

  public void failResponse(String message) {
    System.out.println("onFail error --> " + message);
  }

  @Override public void showLoading() {
    progressbar.setVisibility(View.VISIBLE);
  }

  @Override public void hideLoading() {
    progressbar.setVisibility(View.GONE);
  }

  @Override public void displayData(DataModel dataModel) {

    if (dataModel != null) {
      String title = dataModel.getTitle();
      if (!TextUtils.isEmpty(title)) {
        headerName.setText(title);
      }

      ArrayList<RowDataItem> itemList = dataModel.getRows();
      if (itemList != null) {
        if (itemList.size() > 0) {
          ApiCallAdapter adapter = new ApiCallAdapter(MainActivity.this, itemList);
          recycleView.setAdapter(adapter);
        }
      }
    }
  }

  private void initUI() {

    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
    recycleView.setLayoutManager(linearLayoutManager);

    if (CommonDataUtility.isConnected(this)) {
      apiService =
          ApiClient.getClient().create(ApiInterface.class);
      presenter.callAPI(MainActivity.this, apiService);
    } else {
      CommonDataUtility.makeText(this, getString(R.string.str_no_internet), 1);
    }

    pullToRefreshData();
  }

  private void pullToRefreshData() {

    pullToRefresh.setOnRefreshListener(() -> {
      presenter.callAPI(MainActivity.this, apiService);
      pullToRefresh.setRefreshing(false);
    });
  }
}
