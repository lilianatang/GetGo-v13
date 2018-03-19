package com.macewan.getgo.getgo_v13.UIPages;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.macewan.getgo.getgo_v13.Containers.ContainerAdapter;
import com.macewan.getgo.getgo_v13.Containers.DegreeContainer;
import com.macewan.getgo.getgo_v13.ObjectClass.Results;
import com.macewan.getgo.getgo_v13.ObjectClass.Singleton;
import com.macewan.getgo.getgo_v13.ObjectClass.Student;
import com.example.getgo.uidesign.R;
import android.view.View.*;
import android.view.*;
//import com.example.getgo.uidesign.Singlet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siham on 2018-03-16.
 */

public class SearchPage extends Activity{

    private AutoCompleteTextView autoCompleteTextView;
    public ArrayAdapter<String> adapter_degrees;
    Student student = null;
    Button degree;
    Button school;
    Button city;
    RecyclerView recyclerView;
    public List<DegreeContainer> containerList = new ArrayList<DegreeContainer>();
    ContainerAdapter adapter;
    Button enter;
    List <String> names = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchall);

        //button initialize
        degree = findViewById(R.id.degree_button);
        school = findViewById(R.id.institution_button);
        city = findViewById(R.id.city_button);
        enter = findViewById(R.id.explore);

        //get recyclerView reference
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Call singleton for degree list
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        Singleton s = Singleton.getInstance((this.getBaseContext()));
        student = s.student;

        //Fill dropDown with Degree list
        adapter_degrees = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item);
        adapter_degrees.addAll(student.getDepartmentNames());
        autoCompleteTextView.setAdapter(adapter_degrees);

        //When enter button is clicked, create a container
        autoCompleteTextView.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {

                    addContainer(autoCompleteTextView.getText().toString());
                    return true;
                }
                return false;
            }
        });

        enter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(activity_main.this, Results.class);
                intent.putExtra("list", names.toString());
                startActivity(intent);
            }
        });
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.degree_button:
                adapter_degrees.addAll(student.getDepartmentNames());
                autoCompleteTextView.setAdapter(adapter_degrees);
        }
    }

    public void addContainer(String name){
        DegreeContainer temp = new DegreeContainer(name,null);
        if(containerList.contains(temp)){
            return;
        }
        else{
            names.add(name);
            containerList.add(temp);
            adapter = new ContainerAdapter(this, containerList, null);
            recyclerView.setAdapter(adapter);
            autoCompleteTextView.setText("");
        }
    }
}
