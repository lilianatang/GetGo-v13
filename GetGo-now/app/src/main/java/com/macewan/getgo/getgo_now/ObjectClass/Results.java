package com.macewan.getgo.getgo_now.ObjectClass;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.macewan.getgo.getgo_now.Containers.ContainerAdapter;
import com.macewan.getgo.getgo_now.Containers.DegreeContainer;
import com.macewan.getgo.getgo_now.Containers.LogicAdapter;
import com.macewan.getgo.getgo_now.Containers.LogicContainer;
import com.macewan.getgo.getgo_now.R;
import com.macewan.getgo.getgo_now.courses_drop_down.CourseObject;
import com.macewan.getgo.getgo_now.logic.GetDatabase;
import com.macewan.getgo.getgo_now.logic.LogicDB;
import com.macewan.getgo.getgo_now.logic.LogicResults;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Siham on 2018-03-19.
 */

public class Results extends Activity {

    public Singleton s;
    LogicDB jsonData;
    GetDatabase db;
    public List<LogicContainer> containerList = new ArrayList<LogicContainer>();
    ArrayList<String> degree_names;
    ArrayList<String> school_names;
    LogicAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_logic);
        s = Singleton.getInstance(this.getBaseContext());

        //Get Database Class Reference
        jsonData  = LogicDB.getInstance(this.getBaseContext());
        db = new GetDatabase(jsonData.logic_object.conditions,jsonData.logic_object.condition_links,jsonData.logic_object.groups,jsonData.logic_object.courses,jsonData.logic_object.institution,jsonData.logic_object.department);

        //get recyclerView reference
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        degree_names = bundle.getStringArrayList("degree_string");
        school_names = bundle.getStringArrayList("school_string");

        Log.d("degreeString", "sendToLogic: " + degree_names);
        Log.d("schoolString","sendToLogic"  + school_names);
        HashMap<String, Integer> marks;
        marks = CourseObject.getCourses(null);
        HashMap<String, Integer> lst3;
        lst3 = CourseObject.getCourses(null);
        Log.d("Mark!!", "onClick: " + lst3.toString());
        Log.d("Marks", "sendToLogic: " + marks);
        this.getBaseContext();
        ArrayList<LogicResults> list = new ArrayList<LogicResults>();

        //Check the strings depending on which one is selected.
        if(degree_names.size() == 0 && school_names.size() == 0) {
            Log.d("Nothing to Display", "Empty Strings");
        }
        else if(degree_names.size() != 0 && school_names.size() != 0){
            list = db.getResultbyBoth(this.getBaseContext(), school_names, degree_names, marks);
        }
        else if(school_names.size() != 0){
            list = db.getResultbySchool(this.getBaseContext(), school_names, marks);
        }
        else if(degree_names.size() != 0){
            list = db.getResultbyFaculty(this.getBaseContext(), degree_names, marks);
        }

        adapter = new LogicAdapter(this.getBaseContext(), list);
        recyclerView.setAdapter(adapter);
    }
/*
    public void addContainer(String name){
        adapter = new LogicAdapter(this.getBaseContext(), containerList);
        recyclerView.setAdapter(adapter);
    }*/
}
