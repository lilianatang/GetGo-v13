package com.example.getgo.uidesign;

import android.content.Context;
import android.util.Log;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.getgo.uidesign.ObjectClass.Student;
import com.example.getgo.uidesign.ObjectClass.Singleton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

/**
 * Created by Siham on 2018-03-18.
 */

class Single {
    private static Single singleton = null;
    public RequestQueue mRequestQueue;
    private static Context mCtx;
    public Student student = null;

    public Single(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();
        //getStudent();
        loadDepartments(AppConfig.URL_DEPARTMENT);
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            //Cache cache = new DiskBasedCache(getCacheDir(), )
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());

            loadDepartments(AppConfig.URL_DEPARTMENT);
        }
        return mRequestQueue;
    }

    public void loadDepartments(String stringURL){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET,stringURL , null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                       String string = response.toString();
                        Gson g = new GsonBuilder().setPrettyPrinting().create();
                        Student p3 = g.fromJson(string, Student.class);
                        Log.d("Student", "buildObject: " + p3.department.get(1).department_name);
                        student = new Student();
                        student.department = p3.department;
                        mRequestQueue.stop();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                    }
                });

        Singleton.getInstance(mCtx.getApplicationContext()).addToRequestQueue(jsonObjectRequest);
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

    public static synchronized Single getInstance(Context context) {
        if (singleton == null) {
            singleton = new Single(context);
        }
        return singleton;
    }

    public Student getStudent(){
        if (student == null) {
            loadDepartments(AppConfig.URL_DEPARTMENT);
        }
        return student;
    }
}
