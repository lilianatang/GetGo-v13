package com.macewan.getgo.getgo_now.logic;

/**
 * Created by Michael Zhao on 3/1/2018.
 * Class for checking logic.
 */

import android.content.Context;
import com.macewan.getgo.getgo_now.courses_drop_down.Course;

import java.util.HashMap;
import java.lang.String;
import java.util.ArrayList;

public class CourseLogic {
    public ArrayList checkLogic (String institution, String department, Context context, HashMap<String,Integer> student) {
        LogicDB jsonData = LogicDB.getInstance(context);
        GetDatabase db = new GetDatabase(jsonData.logic_object.conditions,jsonData.logic_object.condition_links,jsonData.logic_object.groups,jsonData.logic_object.courses,jsonData.logic_object.institution,jsonData.logic_object.department);

        int average = 0;
        ArrayList<String> condId;
        ArrayList<ArrayList<String>> links = new ArrayList<>();
        ArrayList<ArrayList<String>> courses = new ArrayList<>();
        ArrayList<ArrayList<String>> courseNames = new ArrayList<>();
        condId = getConditionId(institution,department,db.conditionsList);
        for (String id: condId) {
            links.add(getLinks(id, db.conditionLinksList));
        }

        for (ArrayList list : links) {
            ArrayList<String> groupCourses = new ArrayList<>();
            for (Object group : list) {
                groupCourses.addAll(getGroups(institution, group.toString(), db.groupsList));
            }
            courses.add(groupCourses);
        }


        for (ArrayList list : courses) {
            ArrayList<String> names = new ArrayList<>();
            for (Object id : list) {
                if (getCourses(id.toString(), db.courseList) != null) {
                    names.add(getCourses(id.toString(), db.courseList));
                }
            }
            courseNames.add(names);
        }
        for (Departments dept : db.departmentsList) {
            if (dept.department_id.equals(department)) {
                average = Integer.parseInt(dept.average_mark);
            }
        }


        //Call to the checkCourse function, it will either return null which means the student meet the requirements, an arrayList containing all the
        //condition that they failed, or a arrayList containing an average which means they failed the average requirement.
        ArrayList check = checkCourse(student, courseNames, average);
        return check;
    }


    private static ArrayList<String> getConditionId(String institution, String department,Conditions[] conditionList) {
        ArrayList<String> condId = new ArrayList<>();
        for (Conditions cond : conditionList){
            if (cond.institution_id.equals(institution) && cond.department_id.equals(department)){
                condId.add(cond.id);
            }
        }
        return condId;
    }

    private static ArrayList<String> getLinks(String condId, ConditionLinks[] linkList) {

        ArrayList<String> condGroup = new ArrayList<>();
        for (ConditionLinks link : linkList){
            if (link.condition_id.equals(condId)) {
                condGroup.add(link.condition_group);
            }
        }
        return condGroup;
    }

    private static ArrayList<String> getGroups(String institution, String group, Groups[] groupList) {
        ArrayList<String> courses = new ArrayList<>();
        for (Groups groups : groupList) {
            if (groups.institution_id.equals(institution) && groups.group.equals(group)) {
                courses.add(groups.course_id);
            }
        }
        return courses;
    }


    private static String getCourses(String id, Course[] courseList) {
        for (Course course: courseList) {
            if (course.course_id.equals(id)) {
                return course.course_name;
            }
        }
        return null;
    }


    public static ArrayList checkCourse (HashMap<String, Integer> student, ArrayList<ArrayList<String>> faculty, int average){
        HashMap<String, Integer> thisStudent;
        ArrayList<Integer> courseMarks = new ArrayList<>();
        thisStudent = (HashMap<String, Integer>)student.clone();
        ArrayList<ArrayList<String>> failedConditions = new ArrayList<ArrayList<String>>();
        for (ArrayList courseList : faculty) {
            boolean found = false;
            for (Object course : courseList){
                if (thisStudent.get(course) != null){
                    courseMarks.add(thisStudent.get(course));
                    thisStudent.remove(course);
                    found = true;
                    break;
                }
            }
            if(!found){
                failedConditions.add(courseList);
            }
        }
        if (!failedConditions.isEmpty()){
            return failedConditions;
        }
        if(calculateAverage(courseMarks) >= average){
            return null;
        }
        ArrayList<Integer> requiredAverage = new ArrayList<>();
        requiredAverage.add(average);
        return requiredAverage;
    }

    private static double calculateAverage(ArrayList<Integer> marks){
        int sum = 0;
        if(!marks.isEmpty()){
            for (int mark: marks){
                sum += mark;
            }
            return sum/marks.size();
        }
        return sum;
    }
}