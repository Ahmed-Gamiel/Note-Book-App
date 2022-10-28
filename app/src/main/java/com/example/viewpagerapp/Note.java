package com.example.viewpagerapp;
import com.google.gson.annotations.SerializedName;

public class Note {
    @SerializedName("title")
    String title;
    @SerializedName("body")
    String body;

    public Note(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
