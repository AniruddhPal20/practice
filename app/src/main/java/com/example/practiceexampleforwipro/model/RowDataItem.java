package com.example.practiceexampleforwipro.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
public class RowDataItem implements Serializable {
    @SerializedName("title")
    String title;

    @SerializedName("description")
    String description;

    @SerializedName("imageHref")
    String imageHref;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageHref() {
        return imageHref;
    }

    public void setImageHref(String imageHref) {
        this.imageHref = imageHref;
    }
}
