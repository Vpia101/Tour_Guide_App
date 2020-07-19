package com.example.tourguideapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.widget.ListView;


import androidx.fragment.app.Fragment;


// In this case, the fragment displays simple text based on the page
public class DiningFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static DiningFragment newInstance(int page, String title) {
        DiningFragment fragmentFirst = new DiningFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    public DiningFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        ArrayList<CityAttraction> diningAttractionsList = new ArrayList<CityAttraction>();
        diningAttractionsList.add(new CityAttraction(getString(R.string.restaurant_1), getString(R.string.restaurant_1_address)));
        diningAttractionsList.add(new CityAttraction(getString(R.string.restaurant_2), getString(R.string.restaurant_2_address)));
        diningAttractionsList.add(new CityAttraction(getString(R.string.restaurant_3), getString(R.string.restaurant_3_address)));
        diningAttractionsList.add(new CityAttraction(getString(R.string.restaurant_4), getString(R.string.restaurant_4_address)));
        diningAttractionsList.add(new CityAttraction(getString(R.string.restaurant_5), getString(R.string.restaurant_5_address)));


        CityAttractionAdapter itemsAdapter = new CityAttractionAdapter(getContext(), diningAttractionsList);

        ListView listView = (ListView) rootView.findViewById(R.id.attraction_list_view);
        listView.setAdapter(itemsAdapter);

        return rootView;
    }

}


