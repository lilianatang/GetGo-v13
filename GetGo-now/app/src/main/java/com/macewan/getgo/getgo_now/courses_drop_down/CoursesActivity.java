package com.macewan.getgo.getgo_now.courses_drop_down;
import com.macewan.getgo.getgo_now.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import com.macewan.getgo.getgo_now.UIPages.*;
import com.macewan.getgo.getgo_now.logic.LogicDB;
import com.macewan.getgo.getgo_now.logic.LogicObject;
import com.macewan.getgo.getgo_now.helper.*;
import com.macewan.getgo.getgo_now.activity.*;
import com.macewan.getgo.getgo_now.R;
import com.macewan.getgo.getgo_now.helper.SQLiteHandler;
import com.macewan.getgo.getgo_now.helper.SessionManager;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView.Validator;
import android.text.TextUtils;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author: Siham and Liliana
 *
 * This Class will contain references to the list of courses
 * and can also place other lists of data information we need for logic.
 */

public class CoursesActivity extends AppCompatActivity implements OnClickListener {

    /* for Log Out */
    private SQLiteHandler db;
    private SessionManager session;
    /*These values are being referenced from the xml files*/
    private Button btnAdd;
    private Button btnDelete;
    private Button btnSubmit;
    private ListView lv;
    private AutoCompleteTextView course_box;
    private EditText mark_box;
    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;
    public ArrayAdapter<String> adapter_classes;
    ArrayList<String> Classes;
    int positionDelete = -1;
    HashMap<String, Integer>lst =  new HashMap<String, Integer>();
    public void check_marks_validility(EditText mark_box){
        String marks = mark_box.getText().toString();
        // make sure the mark box is not empty
        if (TextUtils.isEmpty(marks)){
            mark_box.setError("This field cannot be empty");
            return;
        }

        //
        else if (TextUtils.isDigitsOnly(marks)){
            mark_box.setError("This field only accepts a numeric value as input");
            return;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //initializing the product list
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        //Calls Singleton to fill dropdown menu
        adapter_classes = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item);
        new Singleton(adapter_classes).execute();

        //Load DB in LogicClass
        LogicDB caa = LogicDB.getInstance(this.getBaseContext());
        String department = caa.logic_object.department;

        autoCompleteTextView.setAdapter(adapter_classes);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list);

        //Assigning variables to the list_box, the marks text box and the add button
        course_box = findViewById(R.id.autoCompleteTextView);
        mark_box = findViewById(R.id.editText);
        check_marks_validility(mark_box);
        btnDelete = findViewById(R.id.delete);
        btnDelete.setOnClickListener(this);
        btnAdd = findViewById(R.id.add_button);
        btnAdd.setOnClickListener(this);
        btnSubmit = findViewById(R.id.submit_button);
        btnSubmit.setOnClickListener(this);

        lv = findViewById(R.id.listView);

        //On click, Saves the position of the click in the list view
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // list.remove(position);
                positionDelete = position;
            }
        });

        lv.setAdapter(adapter);


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
                        Intent intent2 = new Intent(CoursesActivity.this, CoursesActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_center_focus:
                        Intent intent3 = new Intent(CoursesActivity.this, MainActivity.class);
                        startActivity(intent3);
                        break;
                }


                return false;
            }
        });
    }

    /**
     * Logging out the user. Will set isLoggedIn flag to false in shared
     * preferences Clears the user data from sqlite users table
     * */
    private void logoutUser() {
        session.setLogin(false);

        db.deleteUsers();

        // Launching the login activity
        Intent intent = new Intent(CoursesActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
        //update the dictionary
    public HashMap after_add(String course, int mark){

        lst.put(course, mark);
        return lst;
    }

    public HashMap after_delete(String course, HashMap dict){
        course.trim();
        Log.d("Send to Search", "deleting: |" + course.trim() + "|");
        dict.remove(course.trim());
        Log.d("Send to Search", "New after removed: " + dict);
        return dict;
    }

    //When buttton is clicked, joins the strings and places in tex box
    public void onClick(View v) {
        String my_var;
        HashMap<String, Integer> courses_marks = new HashMap<>();
        String course_name = course_box.getText().toString();
        check_marks_validility(mark_box);
        String course_mark = mark_box.getText().toString();

        switch (v.getId()){
            //Add button clicked
            case R.id.add_button:
                // have to make sure this one is an integer (what happens if user enters a string in mark box => it scratches on me - Liliana)
                int marks = Integer.parseInt(mark_box.getText().toString());
                if (course_name.length() > 0 && course_mark.length() > 0) {
                    String join = course_name + "    " + course_mark + "%";
                    courses_marks = after_add(course_name, marks);
                    adapter.add(join);
                    mark_box.setText("");
                    course_box.setText("");

                    Log.d("list_tag", "In List:  " + adapter.getItem(0));
                }
                break;
                //Delete button clicked, call remove
            case R.id.delete:
                if(positionDelete >=0) {
                    String line = list.get(positionDelete);
                    Log.d("Send to Search", "line to split: " + line);
                    String[] l = line.split(" ");
                    String n = "";
                    for (int i = 0; i < l.length - 2; i++) {
                        n = n + " " + l[i];
                    }
                    Log.d("Send to Search", "New Line: " + n);
                    list.remove(positionDelete);
                    Log.d("Send to Search", "Removing: " + n);
                    after_delete(n, lst);
                    adapter.notifyDataSetChanged();
                }
                break;

            case R.id.submit_button:

                HashMap<String, Integer> lst3;
                lst3 = CourseObject.update(lst);

                Log.d("Send to Search", "onClick1: " + lst.toString());
                Log.d("Send to Search", "onClick2: " + lst3.toString());

                Intent myIntent = new Intent(CoursesActivity.this, New_Search.class);
                startActivityForResult(myIntent, 1);
                break;
        }
    }
}
