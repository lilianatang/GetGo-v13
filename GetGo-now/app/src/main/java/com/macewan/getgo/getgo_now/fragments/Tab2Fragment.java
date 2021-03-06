package com.macewan.getgo.getgo_now.fragments;

import com.macewan.getgo.getgo_now.R;
import com.macewan.getgo.getgo_now.adapter.*;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab2Fragment";

    private ListView mListView;
    private TextView institutions;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_layout,container,false);

        institutions = (TextView) view.findViewById(R.id.list_of_institutions);
        institutions.setTextSize(28);
        institutions.setTextColor(ContextCompat.getColor(getContext(), R.color.titleColor));
        institutions.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);

        mListView = (ListView) view.findViewById(R.id.listView);

        ArrayList<Card> list = new ArrayList<>();

        list.add(new Card("drawable://" + R.drawable.macewan, "MacEwan University"));
        list.add(new Card("drawable://" + R.drawable.uofa, "University of Alberta"));
        list.add(new Card("drawable://" + R.drawable.king, "King's University"));
        list.add(new Card("drawable://" + R.drawable.concordia, "Concordia University"));

        CustomListAdapter adapter = new CustomListAdapter(getActivity(), R.layout.card_layout_main, list);
        mListView.setAdapter(adapter);

        return view;
    }
}