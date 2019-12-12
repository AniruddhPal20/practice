package com.example.practiceexampleforwipro.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class DataModel implements Serializable {
    @SerializedName("title")
    String title;

    @SerializedName("rows")
    ArrayList<RowDataItem> rows;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<RowDataItem> getRows() {
        return rows;
    }

    public void setRows(ArrayList<RowDataItem> rows) {
        this.rows = rows;
    }
}
