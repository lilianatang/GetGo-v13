package com.macewan.getgo.getgo_now.fragments;

import com.macewan.getgo.getgo_now.R;
import com.macewan.getgo.getgo_now.adapter.*;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab2Fragment";

    private ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_layout,container,false);
        mListView = (ListView) view.findViewById(R.id.listView);

        ArrayList<Card> list = new ArrayList<>();

        list.add(new Card("drawable://" + R.drawable.arizona_dessert, "Arizona Dessert"));
        list.add(new Card("drawable://" + R.drawable.bamf1, "Bamf"));
        list.add(new Card("drawable://" + R.drawable.colorado_mountains, "Colorado Mountains"));
        list.add(new Card("drawable://" + R.drawable.cork, "Cork"));
        list.add(new Card("drawable://" + R.drawable.davenport_california, "DavenPort California"));
        list.add(new Card("drawable://" + R.drawable.denmark_austrailia, "Denmark Austrailia"));
        list.add(new Card("drawable://" + R.drawable.foggy_iceland, "Foggy Iceland"));
        list.add(new Card("drawable://" + R.drawable.havasu_falls, "Havasu Falls"));
        list.add(new Card("drawable://" + R.drawable.hawaii_rainforest, "Hawaii RainForest"));
        list.add(new Card("drawable://" + R.drawable.newfoundland_ice, "NewFoundLand Ice"));
        list.add(new Card("drawable://" + R.drawable.oregon_greens, "Oregon Greens"));
        list.add(new Card("drawable://" + R.drawable.yosemite, "Yosemite"));

        CustomListAdapter adapter = new CustomListAdapter(getActivity(), R.layout.card_layout_main, list);
        mListView.setAdapter(adapter);

        return view;
    }
}