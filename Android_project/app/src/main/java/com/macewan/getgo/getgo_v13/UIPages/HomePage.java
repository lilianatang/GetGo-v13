package com.macewan.getgo.getgo_v13.UIPages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.macewan.getgo.getgo_v13.*;
import com.macewan.getgo.getgo_v13.Containers.*;
import com.macewan.getgo.getgo_v13.ObjectClass.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Siham on 2018-03-19.
 */
import com.macewan.getgo.getgo_v13.R;
import android.view.View.OnClickListener;

public class HomePage extends AppCompatActivity{

    RecyclerView recyclerView;
    RecyclerView recyclerView2;
    ContainerAdapter adapter;
    ContainerAdapter adapter2;
    Singleton s;

    public List<DegreeContainer> containerList;
    public List<InstitutionContainer> schoolContainer;

    public List schools = Arrays.asList("University of Alberta",
            "Macewan University",
            "Kings University",
            "Concordia");

    List departments =  Arrays.asList("University of Alberta",
            "Macewan University",
            "Kings University",
            "Concordia");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.homelayout);
    }

}
