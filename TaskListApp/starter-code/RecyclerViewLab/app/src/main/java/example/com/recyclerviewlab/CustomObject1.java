package example.com.recyclerviewlab;

import java.util.ArrayList;

/**
 * Created by raymour on 7/5/16.
 */
public class CustomObject1 {
    private String taskTitle;
    private String taskColor;
    public ArrayList<CustomObject2> items;

    public CustomObject1(String mTaskTitle, String mTaskColor) {
        taskTitle = mTaskTitle;
        taskColor = mTaskColor;
        items = new ArrayList<CustomObject2>();
    }




    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public void setTaskColor(String taskColor) {
        this.taskColor = taskColor;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public String getTaskColor() {
        return taskColor;
    }

}



