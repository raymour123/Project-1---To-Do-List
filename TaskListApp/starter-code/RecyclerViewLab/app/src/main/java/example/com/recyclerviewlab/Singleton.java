package example.com.recyclerviewlab;

import java.util.ArrayList;

/**
 * Created by raymour on 7/8/16.
 */
public class Singleton {
    private static Singleton ourInstance = new Singleton();

    public ArrayList<CustomObject1> mArrayList;

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
        mArrayList = new ArrayList<>();
    }
}
