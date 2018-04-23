package com.macewan.getgo.getgo_now.courses_drop_down;

import java.util.HashMap;
import android.util.Log;

/**
 * Created by Siham on 2018-03-21.
 */

public class CourseObject {

    public static HashMap<String, Integer> lst = null;

    public static synchronized HashMap<String, Integer> getCourses(HashMap<String, Integer> lst1) {

        if (lst == null){
            lst = lst1;
        }
        return lst;
    }

    public static synchronized HashMap<String, Integer> update(HashMap<String, Integer> lst2){
        Log.d("CourseObject","lst2"+lst2.toString());
        lst = lst2;
        Log.d("CourseObject", "lst"+lst.toString());
        return lst;
    }
}
