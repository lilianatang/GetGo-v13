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
import com.macewan.getgo.getgo_now.logic.GetDatabase;

import org.json.JSONObject;

import static com.macewan.getgo.getgo_now.logic.GetDatabase.parseJson;

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
        getInstitution();
        getCourse();

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
                        String parsedstring = parseJson(string,"conditions");
                        logic_object.conditions = parsedstring;
                        Log.d("Conditions", "string " + parsedstring);
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
                        String parsedstring = parseJson(string,"condition_links");
                        logic_object.condition_links = parsedstring;
                        Log.d("Condition links", "string " + parsedstring);

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
    // fills logic_object with ConditionLinks
    public void getInstitution(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, AppConfig.URL_INSTITUTION, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        String string = response.toString();
                        String parsedstring = parseJson(string,"institution");
                        logic_object.institution = parsedstring;
                        Log.d("Institution", "string " + parsedstring);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Institution Error", "Cannot Make Request" + error );
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
                        String parsedstring = parseJson(string,"groups");
                        logic_object.groups = parsedstring;
                        Log.d("Groups", "string " + parsedstring);

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
                        String parsedstring = parseJson(string,"department");
                        logic_object.department = parsedstring;
                        Log.d("Department", "string " + parsedstring);

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
                        String parsedstring = parseJson(string,"course");
                        logic_object.courses = parsedstring;
                        Log.d("Courses", "string " + parsedstring);

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
