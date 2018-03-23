package com.macewan.getgo.getgo_now.logic;

import java.util.ArrayList;

/**
 * Created by Michael on 2018-03-22.
 */

public class LogicResults {
    public String university_name;
    public String faculty_name;
    public ArrayList results;

    public String getUniversity_name() {
        return university_name;
    }

    public String getFaculty_name() {
        return faculty_name;
    }

    public String getResults() {
        String set = "";
        int i;
        int count = 1;
        ArrayList res = (ArrayList) results.get(0);
        for(i = 0; i < res.size(); i++){
            String temp = "Missing Condition " + count + ": "+res.get(i).toString();
            set = set + temp +"\n" ;
            count++;
        }
        if(results.get(1).equals(false)){
            set = set + "Didn't Meet the Average Mark Required";
        }
        else{
            set = set + "Meets Required Mark";
        }

        return set;
    }

    public LogicResults(String uni, String fac, ArrayList res) {
        university_name = uni;
        faculty_name = fac;
        results = res;
    }

}
