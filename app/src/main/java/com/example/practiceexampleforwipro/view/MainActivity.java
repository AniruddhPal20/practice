package com.example.practiceexampleforwipro.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.practiceexampleforwipro.R;
import com.example.practiceexampleforwipro.adapter.ApiCallAdapter;
import com.example.practiceexampleforwipro.interfaces.ApiCallContract;
import com.example.practiceexampleforwipro.model.DataModel;
import com.example.practiceexampleforwipro.model.RowDataItem;
import com.example.practiceexampleforwipro.presenter.ApiCallPresenter;
import com.example.practiceexampleforwipro.utils.Helper;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ApiCallContract.ApiCallView {

    @BindView(R.id.header_name)
    TextView headerName;
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.progressbar)
    ProgressBar progressbar;
    @BindView(R.id.pullToRefresh)
    SwipeRefreshLayout pullToRefresh;
    private String TAG = "WIPRO";
    ApiCallContract.ApiCallPresenter apiCallPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        apiCallPresenter = new ApiCallPresenter(this);
        callApi();
        pullToRefreshData();
    }

    private void pullToRefreshData(){
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                callApi();
                pullToRefresh.setRefreshing(false);
            }
        });
    }


    private void callApi(){
        if (Helper.isConnected(this)) {
            progressbar.setVisibility(View.VISIBLE);
            apiCallPresenter.hitApiCall();
        } else {
            Helper.makeText(this, getString(R.string.str_no_internet), 1);
        }
    }
    @Override
    public void successResponse(DataModel response) {
        progressbar.setVisibility(View.GONE);
        Helper.v(TAG, "Success  response :::: " + response);
        if (response != null) {
            String strheaderName = response.getTitle();
            if (!TextUtils.isEmpty(strheaderName)) {
                headerName.setText(strheaderName);
            }

            ArrayList<RowDataItem> itemList = response.getRows();
            if (itemList != null) {
                if (itemList.size() > 0) {
                    ApiCallAdapter adapter = new ApiCallAdapter(MainActivity.this, itemList);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                    recycleView.setLayoutManager(linearLayoutManager);
                    recycleView.setAdapter(adapter);
                }
            }
        }
    }

    @Override
    public void failResponse(String failMessage) {
        progressbar.setVisibility(View.GONE);
        Helper.v(TAG, "Error response :::: " + failMessage);
    }
}
