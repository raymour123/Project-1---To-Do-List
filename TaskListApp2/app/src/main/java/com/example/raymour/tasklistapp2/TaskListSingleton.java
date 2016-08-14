package com.example.raymour.tasklistapp2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raymour on 8/13/16.
 */
public class TaskListSingleton {
    private static TaskListSingleton sTaskListSingleton = null;
    private static List<TaskList> taskLists;

    private TaskListSingleton(){
        taskLists = new ArrayList<>();
    }

    public static TaskListSingleton getInstance(){
        if(sTaskListSingleton == null)
            sTaskListSingleton= new TaskListSingleton();
        return sTaskListSingleton;
    }

    public void addTaskList(TaskList taskList){
        taskLists.add(taskList);
    }
    public List<TaskList> getTaskLists(){
        return taskLists;
    }
}
