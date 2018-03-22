package com.macewan.getgo.getgo_now.logic;

/**
 * Created by Michael Zhao on 3/21/2018.
 */

public class Institutions {
    public String university_id;
    public String school_name;
    public String city;
    public String province;
    public String country;


    public Institutions(String id, String name) {
        this.university_id = id;
        this.school_name = name;
    }

    public String getId() {
        return university_id;
    }

    public String getName() {
        return school_name;
    }
}
