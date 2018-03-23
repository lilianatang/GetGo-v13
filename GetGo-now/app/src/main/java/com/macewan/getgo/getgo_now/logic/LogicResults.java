package com.macewan.getgo.getgo_now.logic;

import java.util.ArrayList;

/**
 * Created by Michael on 2018-03-22.
 */

public class LogicResults {
    public String university_name;
    public String faculty_name;
    public ArrayList results;

    public LogicResults(String uni, String fac, ArrayList res) {
        university_name = uni;
        faculty_name = fac;
        results = res;
    }

}
