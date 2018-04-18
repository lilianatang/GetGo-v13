package com.macewan.getgo.getgo_now.fragments;

import com.macewan.getgo.getgo_now.R;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class Tab1Fragment extends Fragment {

    private TextView app_name;
    private TextView app_description;
    private TextView app_tech;

    private TextView tech;
    private TextView tech1;
    private TextView tech2;
    private TextView tech3;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout,container,false);
        app_name = (TextView) view.findViewById(R.id.tab1_name);
        app_name.setTextSize(28);
        app_name.setTextColor(ContextCompat.getColor(getContext(), R.color.titleColor));
        app_name.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);


        app_description = (TextView) view.findViewById(R.id.app_description);
        app_description.setTextSize(18);
        app_description.setTextColor(ContextCompat.getColor(getContext(), R.color.description));

        app_tech = (TextView) view.findViewById(R.id.tech_description);
        app_tech.setTextSize(18);
        app_tech.setTextColor(ContextCompat.getColor(getContext(), R.color.description));
        app_tech.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC);

        tech = (TextView) view.findViewById(R.id.tech_description1);
        tech.setTextSize(15);
        tech.setTextColor(ContextCompat.getColor(getContext(), R.color.tech));
        tech.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);


        tech1 = (TextView) view.findViewById(R.id.tech_description2);
        tech1.setTextSize(15);
        tech1.setTextColor(ContextCompat.getColor(getContext(), R.color.tech));

        tech2 = (TextView) view.findViewById(R.id.tech_description3);
        tech2.setTextSize(15);
        tech2.setTextColor(ContextCompat.getColor(getContext(), R.color.tech));

        tech3 = (TextView) view.findViewById(R.id.tech_description4);
        tech3.setTextSize(15);
        tech3.setTextColor(ContextCompat.getColor(getContext(), R.color.tech));

        return view;
    }
}