package com.macewan.getgo.getgo_now.logic;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.macewan.getgo.getgo_now.ObjectClass.Singleton;
import com.macewan.getgo.getgo_now.app.AppConfig;

import org.json.JSONObject;

/**
 * Created by Siham on 2018-03-22.
 */

public class LogicDB {

    private static LogicDB logic_db = null;
    public static LogicObject logic_object = null;
    public static Context mCxt = null;

    public LogicDB(Context mCxtt){
        logic_object = new LogicObject();
        mCxt = mCxtt;
        getConditions();
        getConditionLinks();
        getDepartment();
        getGroups();
    }

    public static synchronized LogicDB getInstance(Context mCxt){
        if(logic_db == null){
            logic_db = new LogicDB(mCxt);
        }
        return logic_db;
    }

    // Makes a JsonObject and get request that is added to the que in singleton
    // fills logic_object with Condition
    public void getConditions(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, AppConfig.URL_CONDITION , null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Gson g = new GsonBuilder().setPrettyPrinting().create();
                        String string = response.toString();
                        Log.d("Conditions", "string " + string);

                        logic_object.conditions = string;
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Conditions Error", "Cannot Make Request" );

                    }
                });
        Singleton.getInstance(mCxt);
        Singleton.addToRequestQueue(jsonObjectRequest);
    }

    // Makes a JsonObject and get request that is added to the que in singleton
    // fills logic_object with ConditionLinks
    public void getConditionLinks(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, AppConfig.URL_CONDITION_LINK , null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        String string = response.toString();
                        logic_object.condition_links = string;
                        Log.d("Condition links", "string " + string);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Condition Links Error", "Cannot Make Request" + error );
                    }
                });

        Singleton.addToRequestQueue(jsonObjectRequest);
    }

    // Makes a JsonObject and get request that is added to the que in singleton
    // fills logic_object with Condition
    public void getGroups(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, AppConfig.URL_GROUP , null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        String string = response.toString();
                        Log.d("Groups", "string " + string);
                        logic_object.groups = string;

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Groups Error", "Cannot Make Request" + error );
                    }
                });

        Singleton.addToRequestQueue(jsonObjectRequest);
    }

    // Makes a JsonObject and get request that is added to the que in singleton
    // fills logic_object with Condition
    public void getDepartment(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, AppConfig.URL_DEPARTMENT , null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        String string = response.toString();
                        Log.d("Department", "string " + string);
                        logic_object.department = string;

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Department", "Cannot Make Request" + error );
                    }
                });

        Singleton.addToRequestQueue(jsonObjectRequest);
    }

    public void getCourse(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, AppConfig.URL_COURSE , null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        String string = response.toString();
                        Log.d("Courses", "string " + string);
                        logic_object.courses = string;

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Courses", "Cannot Make Request" + error );
                    }
                });

        Singleton.addToRequestQueue(jsonObjectRequest);
    }
}
