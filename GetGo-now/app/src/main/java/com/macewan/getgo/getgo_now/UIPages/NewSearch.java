package com.macewan.getgo.getgo_now.UIPages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.macewan.getgo.getgo_now.Containers.ContainerAdapter;
import com.macewan.getgo.getgo_now.Containers.DegreeContainer;
import com.macewan.getgo.getgo_now.ObjectClass.Results;
import com.macewan.getgo.getgo_now.R;
import com.macewan.getgo.getgo_now.logic.GetDatabase;
import com.macewan.getgo.getgo_now.logic.LogicDB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siham on 2018-04-12.
 */

public class NewSearch  extends Activity{

        private AutoCompleteTextView autoCompleteTextViewD;
        private AutoCompleteTextView autoCompleteTextViewS;
        public ArrayAdapter<String> adapter_list;
        Button add;
        RecyclerView recyclerView;
        public List<DegreeContainer> containerList = new ArrayList<DegreeContainer>();
        ContainerAdapter adapter;
        Button enter;
        ArrayList<String> degree_names = new ArrayList<>();
        ArrayList<String> school_names = new ArrayList<>();
        LogicDB jsonData;
        GetDatabase db;
        String what = "degree";

        @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.newsearch);

            //button initialize
            add = findViewById(R.id.add);
            enter = findViewById(R.id.explore);

            //get recyclerView reference
            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            autoCompleteTextViewD = findViewById(R.id.degreeTextView);
            autoCompleteTextViewS = findViewById(R.id.schoolTextView);

            //Retrieve data from singleton to db
            jsonData  = LogicDB.getInstance(this.getBaseContext());
            db = new GetDatabase(jsonData.logic_object.conditions,jsonData.logic_object.condition_links,jsonData.logic_object.groups,jsonData.logic_object.courses,jsonData.logic_object.institution,jsonData.logic_object.department);
            db.getInstitutionNames();

            add.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    addContainer(autoCompleteTextViewS.getText().toString(),autoCompleteTextViewD.getText().toString());

                }
            });

            //Fill dropDown: Default is Degree list
            adapter_list = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item);
            adapter_list.addAll(db.getDepartmentNames());
            autoCompleteTextViewD.setAdapter(adapter_list);

            //Fill dropDown: Default is Degree list
            adapter_list = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item);
            adapter_list.addAll(db.getInstitutionNames());
            autoCompleteTextViewS.setAdapter(adapter_list);

            //When enter is clicked, go to new page
            enter.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(NewSearch.this, Results.class);
                    intent.putExtra("degree_string", degree_names);
                    intent.putExtra("school_string", school_names);
                    startActivity(intent);
                }
            });

        }

    /*
    private void sendToLogic() {
        Log.d("ArrayList", "sendToLogic: " + degree_names);
        HashMap<String, Integer> marks;
        marks = CourseObject.getCourses(null);
        Log.d("Marks", "sendToLogic: " + marks);
        this.getBaseContext();

        ArrayList<LogicResults> list = db.getResultbyFaculty(this.getBaseContext(), degree_names, marks);

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
        public void addContainer(String school, String degree){
            DegreeContainer temp = new DegreeContainer(degree,null);
            if(containerList.contains(temp.getTitle())){
                return;
            }
            else{
                if(what == "degree"){
                    degree_names.add(degree);
                    containerList.add(temp);
                    adapter = new ContainerAdapter(this, containerList, null);
                    recyclerView.setAdapter(adapter);
                    autoCompleteTextViewD.setText("");
                }
                else if(what == "school"){
                    school_names.add(degree);
                    containerList.add(temp);
                    adapter = new ContainerAdapter(this, containerList, null);
                    recyclerView.setAdapter(adapter);
                    autoCompleteTextViewD.setText("");
                }
            }
        }
}
