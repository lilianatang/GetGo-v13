package com.macewan.getgo.getgo_now.UIPages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import java.util.Iterator;
import com.macewan.getgo.getgo_now.Containers.ContainerAdapter;
import com.macewan.getgo.getgo_now.Containers.DegreeContainer;
import com.macewan.getgo.getgo_now.R;
import com.macewan.getgo.getgo_now.activity.LoginActivity;
import com.macewan.getgo.getgo_now.activity.MainActivity;
import com.macewan.getgo.getgo_now.courses_drop_down.CoursesActivity;
import com.macewan.getgo.getgo_now.helper.BottomNavigationViewHelper;
import com.macewan.getgo.getgo_now.logic.GetDatabase;
import com.macewan.getgo.getgo_now.logic.LogicDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Siham on 2018-04-18.
 */

public class New_Search extends Activity {

    private AutoCompleteTextView autoCompleteDegree;
    private AutoCompleteTextView autoCompleteSchool;
    public ArrayAdapter<String> adapter_list;
    public ArrayAdapter<String> adapter_list2;
    Button add;
    Button school;
    Button city;
    RecyclerView recyclerView;
    HashMap<String, ArrayList<String>> MainHash = new HashMap<>();

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
        setContentView(R.layout.new_search);

        //button initialize
        add = findViewById(R.id.add);
        enter = findViewById(R.id.enter);

        //get recyclerView reference
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        autoCompleteDegree = findViewById(R.id.Degree);
        autoCompleteSchool = findViewById(R.id.Institution);

        //Retrieve data from singleton to db
        jsonData  = LogicDB.getInstance(this.getBaseContext());
        db = new GetDatabase(jsonData.logic_object.conditions,jsonData.logic_object.condition_links,jsonData.logic_object.groups,jsonData.logic_object.courses,jsonData.logic_object.institution,jsonData.logic_object.department);
        db.getInstitutionNames();

        //Fill DropDown
        adapter_list = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item);
        adapter_list2 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item);
        adapter_list.addAll(db.getDepartmentNames());
        adapter_list.add("All");
        autoCompleteDegree.setAdapter(adapter_list);

        adapter_list2.addAll(db.getInstitutionNames());
        adapter_list2.add("All");
        autoCompleteSchool.setAdapter(adapter_list2);


        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                addContainer(autoCompleteDegree.getText().toString(), autoCompleteSchool.getText().toString());
            }
        });

        //When enter is clicked, go to new page, Send Hash TO Result Page
        enter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(New_Search.this, ResultPage.class);
                intent.putExtra("Hash", MainHash);
                startActivity(intent);
            }
        });

        // Bottom Navigation
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_arrow:
                        Intent intent0 = new Intent(New_Search.this, LoginActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.ic_books:
                        Intent intent2 = new Intent(New_Search.this, CoursesActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_center_focus:
                        Intent intent3 = new Intent(New_Search.this, MainActivity.class);
                        startActivity(intent3);
                        break;
                }


                return false;
            }
        });


    }
    //Add the hash to the container and view
    public void addToView() {
        Iterator it = MainHash.entrySet().iterator();
        List<DegreeContainer> containerList = new ArrayList<DegreeContainer>();
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry) it.next();
            DegreeContainer temp = new DegreeContainer(pair.getKey().toString(), null, (ArrayList<String>) pair.getValue());
            containerList.add(temp);
        }
        adapter = new ContainerAdapter(this, containerList, null);
        recyclerView.setAdapter(adapter);
    }

    //Check to see if the container is already added then call addview
    public void addContainer(String Degree, String School) {

            ArrayList<String> DegreeList = new ArrayList<>();
            if (MainHash.containsKey(School)) {
                DegreeList = MainHash.get(School);
                if (DegreeList.contains(Degree)) {
                    Log.d("AddContainer", "Contains Degree: " + Degree);
                } else {
                    DegreeList.add(Degree);
                    MainHash.put(School, DegreeList);
                }
            } else {
                DegreeList.add(Degree);
                MainHash.put(School, DegreeList);
                autoCompleteDegree.setText("");
            }
            addToView();
            Log.d("Hash Map", "addContainer: " + MainHash);
        }
}
