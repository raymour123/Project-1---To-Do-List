package com.example.raymour.tasklistapp2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raymour on 8/13/16.
 */
public class TaskList {
    private String mTitle;
    private List<TaskListItem> mTaskListItem;

    public TaskList(String title){
        mTitle = title;
        mTaskListItem = new ArrayList<>();
    }

    @Override
    public String toString(){
        return mTitle;
    }

    public String getTitle(){
        return mTitle;
    }

    public List<TaskListItem> getTaskListitems(){
        return mTaskListItem;
    }


}
