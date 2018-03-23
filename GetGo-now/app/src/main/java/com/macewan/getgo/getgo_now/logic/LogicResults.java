package com.macewan.getgo.getgo_now.logic;

import java.util.ArrayList;

/**
 * Created by Michael on 2018-03-22.
 */

public class LogicResults {
    String university_name;
    String faculty_name;
    ArrayList results;

    public LogicResults(String uni, String fac, ArrayList res) {
        university_name = uni;
        faculty_name = fac;
        results = res;
    }

}
