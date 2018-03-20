package com.example.getgo.uidesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.widget.Button;
import android.content.Intent;

import com.macewan.getgo.getgo_v13.ObjectClass.Departments;

import java.util.ArrayList;
import java.util.Arrays;
import android.view.View;

import com.macewan.getgo.getgo_v13.Containers.ContainerAdapter;
import com.macewan.getgo.getgo_v13.Containers.DegreeContainer;
import com.macewan.getgo.getgo_v13.Containers.InstitutionContainer;
import com.macewan.getgo.getgo_v13.ObjectClass.Singleton;
import com.macewan.getgo.getgo_v13.UIHelpers.activity_main;

import java.util.List;

public class HomePage extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView recyclerView2;
    ContainerAdapter adapter;
    ContainerAdapter adapter2;

    public List<DegreeContainer> containerList;
    public List<InstitutionContainer> schoolContainer;

    public List schools = Arrays.asList("University of Alberta",
            "Macewan University",
            "Kings University",
            "Concordia");

    List departments =  Arrays.asList("University of Alberta",
            "Macewan University",
            "Kings University",
            "Concordia");

    Singleton s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homelayout);
        s = Singleton.getInstance(this.getBaseContext());


             //Open Singleton Reference
            if (s.student != null) {
                Departments d = s.student.department.get(0);
                departments = (List) s.student.department;
                Log.d("departments", "onCreate: " + departments);
            }

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
                    Intent myIntent = new Intent(MainActivity.this, activity_main.class);
                    startActivityForResult(myIntent, 1);
                }

            });
        }
}
