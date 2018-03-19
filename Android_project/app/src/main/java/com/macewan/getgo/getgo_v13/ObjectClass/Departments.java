package com.macewan.getgo.getgo_v13.ObjectClass;

/**
 * Created by Siham on 2018-03-18.
 */

public class Departments {

   int department_id;
   int university_id;
   public String department_name;
   int average_mark;
   String description;

    public Departments(int department_id, int university_id, String department_name, int average_mark, String description) {
        this.department_id = department_id;
        this.university_id = university_id;
        this.department_name = department_name;
        this.average_mark = average_mark;
        this.description = description;
    }
}
