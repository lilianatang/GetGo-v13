package com.macewan.getgo.getgo_now.logic;

import com.google.gson.Gson;
import com.macewan.getgo.getgo_now.courses_drop_down.Course;

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

    public GetDatabase(String conditionJson, String linksJson, String groupsJson, String courseJson, String institutionJson) {
        conditionsList = parseCondition(conditionJson);
        conditionLinksList = parseConditionLinks(linksJson);
        groupsList = parseGroups(groupsJson);
        courseList = parseCourses(courseJson);
        institutionsList = parseInstitutions(institutionJson);
    }

    private static String parseJson(String json, String key) {
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
        Conditions[] conditions = gson.fromJson(json, Conditions[].class);

        return conditions;
    }

    private static ConditionLinks[] parseConditionLinks(String json) {
        Gson gson = new Gson();
        ConditionLinks[] links = gson.fromJson(json, ConditionLinks[].class);

        return links;
    }

    private static Groups[] parseGroups(String json) {
        Gson gson = new Gson();
        Groups[] groups = gson.fromJson(json, Groups[].class);

        return groups;
    }

    private static Course[] parseCourses(String json) {
        Gson gson = new Gson();
        Course[] courses = gson.fromJson(json, Course[].class);

        return courses;
    }

    private static Institutions[] parseInstitutions(String json) {
        Gson gson = new Gson();
        Institutions[] institutions = gson.fromJson(json, Institutions[].class);

        return institutions;
    }
}
