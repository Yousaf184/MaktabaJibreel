package com.example.yousafkhan.maktabajibreel.Models;

public class ListViewItem {

    private int iconID;
    private String title;

    public ListViewItem(String title, int iconID) {
        this.title = title;
        this.iconID = iconID;
    }

    public int getIconID() {
        return iconID;
    }

    public String getTitle() {
        return title;
    }
}
