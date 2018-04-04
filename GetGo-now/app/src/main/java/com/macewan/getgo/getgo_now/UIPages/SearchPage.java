package com.macewan.getgo.getgo_now.UIPages;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.macewan.getgo.getgo_now.Containers.ContainerAdapter;
import com.macewan.getgo.getgo_now.Containers.DegreeContainer;
import com.macewan.getgo.getgo_now.ObjectClass.Results;
import com.macewan.getgo.getgo_now.ObjectClass.Singleton;
import com.macewan.getgo.getgo_now.ObjectClass.Student;
import com.macewan.getgo.getgo_now.R;
import android.view.View.*;
import android.view.*;
//import com.example.getgo.uidesign.Singlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.macewan.getgo.getgo_now.ObjectClass.Student;
import com.macewan.getgo.getgo_now.courses_drop_down.CourseObject;
import com.macewan.getgo.getgo_now.logic.GetDatabase;
import com.macewan.getgo.getgo_now.logic.LogicDB;
import com.macewan.getgo.getgo_now.logic.LogicResults;

/**
 * Created by Siham on 2018-03-16.
 *
 * Search Page: This is where the searchbar functionality is. Loads item in
 *  the dropdown based on which button is clicked on. When enter is clicked, it
 *  sends the chosen names to the logic which displays on the results page.
 */

public class SearchPage extends Activity{

    private AutoCompleteTextView autoCompleteTextView;
    public ArrayAdapter<String> adapter_list;
    Button degree;
    Button school;
    Button city;
    RecyclerView recyclerView;
    public List<DegreeContainer> containerList = new ArrayList<DegreeContainer>();
    ContainerAdapter adapter;
    Button enter;
    ArrayList<String> names = new ArrayList<>();
    LogicDB jsonData;
    GetDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchlayout);

        //button initialize
        degree = findViewById(R.id.degree_button);
        school = findViewById(R.id.institution_button);
        city = findViewById(R.id.city_button);
        enter = findViewById(R.id.explore);

        //get recyclerView reference
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        //Retrieve data from singleton to db
        jsonData  = LogicDB.getInstance(this.getBaseContext());
        db = new GetDatabase(jsonData.logic_object.conditions,jsonData.logic_object.condition_links,jsonData.logic_object.groups,jsonData.logic_object.courses,jsonData.logic_object.institution,jsonData.logic_object.department);
        db.getInstitutionNames();

        //When enter button is clicked, create a container and add to list
        autoCompleteTextView.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    addContainer(autoCompleteTextView.getText().toString());
                    return true;
                }
                return false;
            }
        });

        //Fill dropDown: Default is Degree list
        adapter_list = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item);
        adapter_list.addAll(db.getDepartmentNames());
        autoCompleteTextView.setAdapter(adapter_list);

        //When enter is clicked, go to new page
        enter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(SearchPage.this, Results.class);
                intent.putExtra("string", names);
                startActivity(intent);
            }
        });

        //When school is clicked, refill dropdown
        school.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(adapter_list != null)
                    adapter_list.clear();
                adapter_list.addAll(db.getInstitutionNames());
                autoCompleteTextView.setAdapter(adapter_list);
            }
        });

        //When degree is clicked go to new page
        degree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(adapter_list != null)
                    adapter_list.clear();
                adapter_list.addAll(db.getDepartmentNames());
                autoCompleteTextView.setAdapter(adapter_list);
            }
        });
    }

    /*
    private void sendToLogic() {
        Log.d("ArrayList", "sendToLogic: " + names);
        HashMap<String, Integer> marks;
        marks = CourseObject.getCourses(null);
        Log.d("Marks", "sendToLogic: " + marks);
        this.getBaseContext();

        ArrayList<LogicResults> list = db.getResultbyFaculty(this.getBaseContext(), names, marks);

        Log.d("Logic Results!!!!", "sendToLogic: " + list.get(0).faculty_name);
    }*/

    /*
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.degree_button:
                adapter_list = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item);
                adapter_list.addAll(student.getDepartmentNames());
                autoCompleteTextView.setAdapter(adapter_list);
        }
    }*/

    //When Called, fills container With name of Selected items
    public void addContainer(String name){
        DegreeContainer temp = new DegreeContainer(name,null);
        if(containerList.contains(temp.getTitle())){
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
