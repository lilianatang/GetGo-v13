package com.example.getgo.uidesign.ObjectClass;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Siham on 2018-03-18.
 */

public class Student {
    public ArrayList<HashMap<String,ArrayList<String>>> Institution;
    public HashMap<String,ArrayList<String>> Departments;

    public ArrayList <Departments>department;

    private Student student;

    public ArrayList<String> getDepartmentNames(){
        ArrayList<String> depList = new ArrayList<String>();
        for(int i = 0; i < this.department.size(); i++){
            depList.add(this.department.get(i).department_name);
        }
        return depList;
    }
}
