package com.macewan.getgo.getgo_now.Containers;

import java.util.ArrayList;

/**
 * Created by Siham on 2018-03-15.
 */

public class DegreeContainer {

    private String title;
    private String definition;
    private ArrayList<String> degreeList;

    public DegreeContainer(String title, String definition, ArrayList<String> list) {
        this.title = title;
        this.definition = definition;
        this.degreeList = list;
    }

    public String getTitle() {
        return title;
    }

    public String getDefinition() {
        return definition;
    }

    public ArrayList<String> getList() {
        return degreeList;
    }
}
