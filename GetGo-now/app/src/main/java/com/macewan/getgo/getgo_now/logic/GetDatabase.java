package com.macewan.getgo.getgo_now.logic;

import android.content.Context;
import android.graphics.LightingColorFilter;
import android.util.Log;

import com.google.gson.Gson;
import com.macewan.getgo.getgo_now.courses_drop_down.Course;
import com.macewan.getgo.getgo_now.logic.CourseLogic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;


/**
 * Created by I72600K on 3/21/2018.
 */

public class GetDatabase {
    public Conditions[] conditionsList;
    public ConditionLinks[] conditionLinksList;
    public Groups[] groupsList;
    public Course[] courseList;
    public Institutions[] institutionsList;
    public Departments[] departmentsList;

    public GetDatabase(String conditionJson, String linksJson, String groupsJson, String courseJson, String institutionJson, String departmentJson) {
        conditionsList = parseCondition(conditionJson);
        conditionLinksList = parseConditionLinks(linksJson);
        groupsList = parseGroups(groupsJson);
        courseList = parseCourses(courseJson);
        institutionsList = parseInstitutions(institutionJson);
        departmentsList = parseDepartments(departmentJson);
    }

    public static String parseJson(String json, String key) {
        JSONObject jsonOb;
        try {
            jsonOb = new JSONObject(json);
            String value = jsonOb.getString(key);
            return value;
        }
        catch (Exception e){
            Log.d("parseJson error",e.toString());
            return null;
        }
    }

    private static Conditions[] parseCondition(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Conditions[].class);
    }

    private static ConditionLinks[] parseConditionLinks(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, ConditionLinks[].class);
    }

    private static Groups[] parseGroups(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Groups[].class);
    }

    private static Course[] parseCourses(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Course[].class);
    }

    private static Institutions[] parseInstitutions(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Institutions[].class);
    }

    private static Departments[] parseDepartments(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Departments[].class);
    }

    public ArrayList<String> getDepartmentNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Departments dept: this.departmentsList) {
            names.add(dept.department_name);
        }
        return names;
    }

    public ArrayList<String> getInstitutionNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Institutions dept : this.institutionsList) {
            names.add(dept.school_name);
        }
        return names;
    }

    private String getUniversityName(String Uid) {
        for (Institutions uni : institutionsList) {
            if (uni.university_id.equals(Uid)) {
                return uni.school_name;
            }
        }
        return null;
    }


    public ArrayList<LogicResults> getResultbyFaculty(Context context, ArrayList<String> facultyList, HashMap<String,Integer> student) {
        ArrayList<LogicResults> results = new ArrayList<>();
        CourseLogic logic = new CourseLogic();
        for (String fac : facultyList) {
            for(Departments dept: departmentsList) {
                if (dept.department_name.equals(fac)) {
                    ArrayList result = logic.checkLogic(dept.university_id,dept.department_id,context,student);
                    LogicResults logicResults = new LogicResults(getUniversityName(dept.university_id),fac, result);
                    Log.d("Results: ", "getResultbyFaculty: " + result.toString());
                    results.add(logicResults);
                }
            }
        }
        return results;

    }

    public ArrayList<LogicResults> getResultbySchool(Context context, String school, HashMap<String,Integer> student) {
        ArrayList<LogicResults> results = new ArrayList<>();
        CourseLogic logic = new CourseLogic();

            String schoolID = new String();
            for (Institutions institution : institutionsList) {
                if (institution.school_name.equals(school)) {
                    schoolID = institution.university_id;
                }
            }
            for (Departments dept: departmentsList) {
                if (dept.university_id.equals(schoolID)) {
                    ArrayList result = logic.checkLogic(schoolID,dept.department_id,context,student);
                    LogicResults logicResults = new LogicResults(school, dept.department_name, result);
                    results.add(logicResults);
                }
            }
        return results;
    }

    public ArrayList<LogicResults> getResultbyBoth(Context context, String school, ArrayList<String> facultys, HashMap<String,Integer> student) {
        CourseLogic logic = new CourseLogic();
        ArrayList<LogicResults> results = new ArrayList<>();

        String schoolID = new String();
        for (Institutions institution : institutionsList) {
            if (institution.school_name.equals(school)) {
                schoolID = institution.university_id;
            }
        }
        for (String fac : facultys) {
            for (Departments dept : departmentsList) {
                if (dept.department_name.equals(fac) && dept.university_id.equals(schoolID)) {
                    ArrayList result = logic.checkLogic(dept.university_id, dept.department_id, context, student);
                    LogicResults logicResults = new LogicResults(school, fac, result);
                    results.add(logicResults);
                }
            }
        }


        return results;
    }

    public ArrayList<LogicResults> getAll(Context context, HashMap<String,Integer> student) {
        CourseLogic logic = new CourseLogic();
        ArrayList<LogicResults> results = new ArrayList<>();

        for (Institutions institution : institutionsList) {
            for (Departments dept: departmentsList) {
                if (dept.university_id.equals(institution.university_id)) {
                    ArrayList result = logic.checkLogic(dept.university_id, dept.department_id, context, student);
                    LogicResults logicResults = new LogicResults(institution.school_name, dept.department_name, result);
                    results.add(logicResults);
                }
            }
        }
        return results;
    }
}
