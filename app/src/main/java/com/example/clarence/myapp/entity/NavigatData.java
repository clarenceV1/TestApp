package com.example.clarence.myapp.entity;

/**
 * Created by clarence on 16/6/19.
 */
public class NavigatData {
    private String className;
    private String title;

    public NavigatData(String title, String className) {
        this.className = className;
        this.title = title;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
