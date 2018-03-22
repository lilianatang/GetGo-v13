package com.macewan.getgo.getgo_now.logic;

/**
 * Created by Michael on 2018-03-22.
 */

public class Departments {
    public String department_id;
    public String university_id;
    public String department_name;
    public String average_mark;

    public Departments(String id, String university, String department, String mark) {
        this.department_id = id;
        this.university_id = university;
        this.department_name = department;
        this.average_mark = mark;
    }

    public String getDepartmentId() {
        return department_id;
    }

    public String getUniversityId() {
        return university_id;
    }

    public String getDepartmentName() {
        return department_name;
    }

    public String  getAverageMark() {
        return average_mark;
    }

}
