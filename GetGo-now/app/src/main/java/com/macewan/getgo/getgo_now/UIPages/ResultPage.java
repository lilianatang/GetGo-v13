package com.macewan.getgo.getgo_now.UIPages;

import android.app.Activity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import com.macewan.getgo.getgo_now.UIPages.*;
import com.macewan.getgo.getgo_now.courses_drop_down.CoursesActivity;
import com.macewan.getgo.getgo_now.logic.LogicDB;
import com.macewan.getgo.getgo_now.logic.*;
import com.macewan.getgo.getgo_now.app.*;
import com.macewan.getgo.getgo_now.helper.*;
import com.macewan.getgo.getgo_now.activity.*;
import com.macewan.getgo.getgo_now.R;
import android.content.Intent;
import android.os.Bundle;
import com.macewan.getgo.getgo_now.helper.*;
import com.macewan.getgo.getgo_now.helper.SessionManager;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView.Validator;
import android.text.TextUtils;
import android.util.Log;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import com.macewan.getgo.getgo_now.ObjectClass.Singleton;
import com.macewan.getgo.getgo_now.R;
import com.macewan.getgo.getgo_now.courses_drop_down.CourseObject;
import com.macewan.getgo.getgo_now.logic.GetDatabase;
import com.macewan.getgo.getgo_now.logic.LogicDB;
import com.macewan.getgo.getgo_now.logic.LogicResults;

public class ResultPage extends Activity {
    /* for Log Out */
    private SQLiteHandler db1;
    private SessionManager session;
    private ExpandableListView expandableListView;
    private ExpandableListAdapter adapter;
    private ArrayList<String> degree_names = new ArrayList<>();
    private ArrayList<String> school_names = new ArrayList<>();
    private HashMap<String, Integer> marks;
    public Singleton s;
    LogicDB jsonData;
    GetDatabase db;
    HashMap<String, ArrayList<String>> searchHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        s = Singleton.getInstance(this.getBaseContext());

        //Get Database Class Reference
        jsonData  = LogicDB.getInstance(this.getBaseContext());
        db = new GetDatabase(jsonData.logic_object.conditions,jsonData.logic_object.condition_links,jsonData.logic_object.groups,jsonData.logic_object.courses,jsonData.logic_object.institution,jsonData.logic_object.department);

        marks = CourseObject.getCourses(null);
        Log.d("Marks", "sendToLogic: " + marks);
        this.getBaseContext();

        expandableListView = findViewById(R.id.simple_expandable_listview);

        // Setting group indicator null for custom indicator
        expandableListView.setGroupIndicator(null);
        searchHash = (HashMap<String, ArrayList<String>>)getIntent().getSerializableExtra("Hash");

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
                        logoutUser();
                        break;

                    case R.id.ic_books:
                        Intent intent2 = new Intent(ResultPage.this, CoursesActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_center_focus:
                        Intent intent3 = new Intent(ResultPage.this, MainActivity.class);
                        startActivity(intent3);
                        break;
                }


                return false;
            }
        });
        setItems();
        setListener();

    }

    // Setting headers and childs to expandable listview
    void setItems() {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        this.getBaseContext();
        ArrayList<LogicResults> list = new ArrayList<LogicResults>();

        Iterator it = searchHash.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            ArrayList<String> facList = (ArrayList<String>)pair.getValue();
            if (pair.getKey().equals("All")) {
                if (facList.contains("All")) {
                    list.addAll(db.getAll(this.getBaseContext(),marks));
                }
                else {
                    list.addAll(db.getResultbyFaculty(this.getBaseContext(), facList, marks));
                }
            }
            else {
                if (facList.contains("All")) {
                    list.addAll(db.getResultbySchool(this.getBaseContext(), (String)pair.getKey(), marks));
                }
                else {
                    list.addAll(db.getResultbyBoth(this.getBaseContext(), (String)pair.getKey(), facList, marks));
                }
            }

        }

        //Send Hash to Logic Here -->
        Log.d("Hash Map", "setItems: " + searchHash);

        //Check the strings depending on which one is selected.
        /*
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

        }*/
        ArrayList<String> schoolHeader = new ArrayList<>();
        for (LogicResults result : list) {
            if (!schoolHeader.contains(result.university_name)) {
                schoolHeader.add(result.university_name);
            }
        }

        for (String school : schoolHeader) {
            List<String> resultString = new ArrayList<>();
            for (LogicResults result : list) {
                if (result.university_name.equals(school)) {
                    StringBuilder container = new StringBuilder();
                    container.append("Faculty: "+result.faculty_name+"\n");
                    if(result.results.get(0) == null) {
                        if(result.results.get(1).equals(true)) {
                            container.append("All requirements met.");
                        }
                        else {
                            container.append("All courses met, however average was not met.");
                        }
                    }
                    else {
                        for (Object condition : (ArrayList)result.results.get(0)) {
                            container.append("Unmet Condition: "+ condition.toString()+"\n");
                        }
                    }
                    resultString.add(container.toString());
                }
            }
            hashMap.put(school,resultString);
        }



        adapter = new ExpandableListAdapter(ResultPage.this, schoolHeader, hashMap);

        // Setting adpater over expandablelistview
        expandableListView.setAdapter(adapter);
    }
    /**
     * Logging out the user. Will set isLoggedIn flag to false in shared
     * preferences Clears the user data from sqlite users table
     * */
    private void logoutUser() {
        session.setLogin(false);

        db1.deleteUsers();

        // Launching the login activity
        Intent intent = new Intent(ResultPage.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    // Setting different listeners to expandablelistview
    void setListener() {

        // This listener will show toast on group click
        expandableListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView listview, View view,
                                        int group_pos, long id) {

                Toast.makeText(ResultPage.this,
                        "You clicked : " + adapter.getGroup(group_pos),
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // This listener will expand one group at one time
        // You can remove this listener for expanding all groups
        expandableListView
                .setOnGroupExpandListener(new OnGroupExpandListener() {

                    // Default position
                    int previousGroup = -1;

                    @Override
                    public void onGroupExpand(int groupPosition) {
                        if (groupPosition != previousGroup)

                            // Collapse the expanded group
                            expandableListView.collapseGroup(previousGroup);
                        previousGroup = groupPosition;
                    }

                });

        // This listener will show toast on child click
        /*expandableListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView listview, View view,
                                        int groupPos, int childPos, long id) {
                Toast.makeText(
                        ResultPage.this,
                        "You clicked : " + adapter.getChild(groupPos, childPos),
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });*/
    }
}
