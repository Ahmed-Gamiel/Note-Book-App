package com.example.viewpagerapp;

public class FirebaseModel {
    private String title , content,isTodo;
    public FirebaseModel() {

    }

    public FirebaseModel(String title, String content, String isTodo) {
        this.title = title;
        this.content = content;
        this.isTodo = isTodo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsTodo() {
        return isTodo;
    }

    public void setIsTodo(String isTodo) {
        this.isTodo = isTodo;
    }
}
