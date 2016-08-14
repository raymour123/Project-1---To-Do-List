package com.example.raymour.tasklistapp2;

/**
 * Created by raymour on 8/13/16.
 */
public class TaskListItem {
    public String title;
    public String description;

    public TaskListItem(String title, String description){
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
}
