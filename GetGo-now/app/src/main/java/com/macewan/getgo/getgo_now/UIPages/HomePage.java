package com.macewan.getgo.getgo_now.UIPages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.*;
import android.util.Log;
import android.widget.*;

import android.view.View;
import android.content.*;

import com.macewan.getgo.getgo_now.Containers.*;
import com.macewan.getgo.getgo_now.ObjectClass.*;

import java.util.Arrays;
import java.util.List;
import java.util.*;

/**
 * Created by Siham on 2018-03-19.
 */
import com.macewan.getgo.getgo_now.R;
import com.macewan.getgo.getgo_now.courses_drop_down.CourseObject;
import com.macewan.getgo.getgo_now.logic.GetDatabase;
import com.macewan.getgo.getgo_now.logic.LogicDB;
import com.macewan.getgo.getgo_now.logic.LogicObject;

import android.view.View.OnClickListener;

public class HomePage extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView recyclerView2;
    ContainerAdapter adapter;
    ContainerAdapter adapter2;
    Singleton s;

    public List<DegreeContainer> containerList;
    public List<InstitutionContainer> schoolContainer;

    public List schools = Arrays.asList("University of Alberta",
            "Macewan University",
            "Kings University",
            "Concordia");

    List departments = Arrays.asList("University of Alberta",
            "Macewan University",
            "Kings University",
            "Concordia");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.homelayout);
        s = Singleton.getInstance(this.getBaseContext());

        HashMap<String, Integer> lst3;
        lst3 = CourseObject.getCourses(null);
        Log.d("IN HOME!!", "onClick: " + lst3.toString());

        LogicDB jsonData;

        jsonData  = LogicDB.getInstance(this.getBaseContext());
        String department2 = jsonData.logic_object.department;
        Log.d("DEPARTMENT STRING!!!", "onCreate: " + department2);

        GetDatabase db = new GetDatabase(jsonData.logic_object.conditions,jsonData.logic_object.condition_links,jsonData.logic_object.groups,jsonData.logic_object.courses,jsonData.logic_object.institution,jsonData.logic_object.department);


        //  departments = ca.getDepartmentNames();
        //Fill Both RecyclerViews
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        containerList = new ArrayList<>();
        for (int i = 0; i < departments.size(); i++) {
            containerList.add(
                    new DegreeContainer(departments.get(i).toString(), "Universty"));
        }

        schoolContainer = new ArrayList<>();
        for (int i = 0; i < schools.size(); i++) {
            schoolContainer.add(
                    new InstitutionContainer(schools.get(i).toString()));
        }

        //Assign to Adapter
        adapter = new ContainerAdapter(this, containerList, null);
        adapter2 = new ContainerAdapter(this, null, schoolContainer);
        recyclerView.setAdapter(adapter);
        recyclerView2.setAdapter(adapter2);

        //When button is clicked, go to new page.
        Button next = (Button) findViewById(R.id.searchButton);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(HomePage.this, SearchPage.class);
                startActivityForResult(myIntent, 1);
            }

        });
    }
}
