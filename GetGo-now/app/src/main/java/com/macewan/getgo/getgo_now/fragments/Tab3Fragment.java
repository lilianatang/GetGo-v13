package com.macewan.getgo.getgo_now.fragments;

import com.macewan.getgo.getgo_now.R;
import com.macewan.getgo.getgo_now.adapter.Card;
import com.macewan.getgo.getgo_now.adapter.CustomListAdapter;


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


public class Tab3Fragment extends Fragment {
    private static final String TAG = "Tab2Fragment";

    private ListView mListView;
    private TextView developers;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3_layout,container,false);

        developers = (TextView) view.findViewById(R.id.list_of_developers);
        developers.setTextSize(28);
        developers.setTextColor(ContextCompat.getColor(getContext(), R.color.titleColor));
        developers.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);

        mListView = (ListView) view.findViewById(R.id.listView);

        ArrayList<Card> list = new ArrayList<>();

        list.add(new Card("drawable://" + R.drawable.liliana, "Liliana Quyen Tang"));
        list.add(new Card("drawable://" + R.drawable.michael, "Michael Zhao"));
        list.add(new Card("drawable://" + R.drawable.siham, "Siham Salah"));

        CustomListAdapter adapter = new CustomListAdapter(getActivity(), R.layout.card_layout_main, list);
        mListView.setAdapter(adapter);

        return view;
    }
}