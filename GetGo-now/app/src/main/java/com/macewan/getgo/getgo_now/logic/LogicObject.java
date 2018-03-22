package com.macewan.getgo.getgo_now.logic;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.macewan.getgo.getgo_now.ObjectClass.*;
import com.macewan.getgo.getgo_now.app.AppConfig;
import com.macewan.getgo.getgo_now.courses_drop_down.Course;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Siham on 2018-03-22.
 */

public class LogicObject {

    public static String conditions;
    public static String condition_links;
    public static String groups;
    public static String courses;
    public static String department;
    public static String institution;
/*
    public ArrayList<String> getDepartmentNames(){
        ArrayList<String> nameList = new ArrayList<String>();
        for(int i = 0; i < this.department.size(); i++){
            nameList.add(this.department.get(i).department_name);
        }
        return nameList;
    }*/

}
