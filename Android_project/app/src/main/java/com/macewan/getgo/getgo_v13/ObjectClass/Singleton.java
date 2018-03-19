package com.macewan.getgo.getgo_v13.ObjectClass;

import android.content.Context;
import android.util.Log;

import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.macewan.getgo.getgo_v13.login.app.AppConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

/**
 * Created by Siham on 2018-03-18.
 */

public class Singleton {

    private static Singleton singleton = null;
    private RequestQueue mRequestQueue = null;
    private static Context mCtx;
    public static Student student = null;

    private Singleton(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();
        loadDepartments(AppConfig.URL_DEPARTMENT);

    }

    public static synchronized Singleton getInstance(Context context) {
        if (singleton == null) {
            singleton = new Singleton(context);
        }
        return singleton;
    }

        //Builds a requestQueue if none not already made.
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    //Build Student Reference
    public void loadDepartments(String stringURL){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET,stringURL , null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        buildObject(response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                    }
                });

       addToRequestQueue(jsonObjectRequest);
    }

    public void buildObject(String string){

        Gson g = new GsonBuilder().setPrettyPrinting().create();
        Student p3 = g.fromJson(string, Student.class);
        Log.d("Student", "buildObject: " + p3.department.get(1).department_name);
       student = new Student();
       student.department = p3.department;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
/*
    public Student getStudent(){
        if (student == null) {
            loadDepartments(AppConfig.URL_DEPARTMENT);
        }
        return student;
    }*/
}
