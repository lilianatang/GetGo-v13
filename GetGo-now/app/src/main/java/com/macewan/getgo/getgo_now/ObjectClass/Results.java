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
    ArrayList<String> names;
    LogicAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_logic);
        s = Singleton.getInstance(this.getBaseContext());

        jsonData  = LogicDB.getInstance(this.getBaseContext());
        db = new GetDatabase(jsonData.logic_object.conditions,jsonData.logic_object.condition_links,jsonData.logic_object.groups,jsonData.logic_object.courses,jsonData.logic_object.institution,jsonData.logic_object.department);

//get recyclerView reference
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        names = bundle.getStringArrayList("string");

        Log.d("ArrayList", "sendToLogic: " + names);
        HashMap<String, Integer> marks;
        marks = CourseObject.getCourses(null);
        Log.d("Marks", "sendToLogic: " + marks);
        this.getBaseContext();

        ArrayList<LogicResults> list = db.getResultbyFaculty(this.getBaseContext(), names, marks);

        adapter = new LogicAdapter(this.getBaseContext(), list);
        recyclerView.setAdapter(adapter);
    }
/*
    public void addContainer(String name){
        adapter = new LogicAdapter(this.getBaseContext(), containerList);
        recyclerView.setAdapter(adapter);
    }*/
}
