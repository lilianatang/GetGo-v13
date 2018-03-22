package com.macewan.getgo.getgo_now.logic;

import com.google.gson.Gson;
import com.macewan.getgo.getgo_now.courses_drop_down.Course;
import java.util.ArrayList;
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
            System.out.print("parseJson error");
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
}
