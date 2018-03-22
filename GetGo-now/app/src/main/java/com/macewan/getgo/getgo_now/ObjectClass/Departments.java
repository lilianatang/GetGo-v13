package com.macewan.getgo.getgo_now.ObjectClass;

/**
 * Created by Siham on 2018-03-18.
 */

public class Departments {

   public int department_id;
   public int university_id;
   public String department_name;
   public int average_mark;
   public String description;

    public Departments(int department_id, int university_id, String department_name, int average_mark, String description) {
        this.department_id = department_id;
        this.university_id = university_id;
        this.department_name = department_name;
        this.average_mark = average_mark;
        this.description = description;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public int getUniversity_id() {
        return university_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public int getAverage_mark() {
        return average_mark;
    }

    public String getDescription() {
        return description;
    }
}
