package com.macewan.getgo.getgo_now.Containers;

import java.util.ArrayList;

/**
 * Created by Siham on 2018-03-19.
 */

public class LogicContainer {

    public String university_name;
    public String faculty_name;
    public ArrayList results;

    public LogicContainer(String university_name, String faculty_name, ArrayList results) {
        this.university_name = university_name;
        this.faculty_name = faculty_name;
        this.results = results;
    }
}
