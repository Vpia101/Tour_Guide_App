package com.example.tourguideapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


// In this case, the fragment displays simple text based on the page
public class ShoppingFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static ShoppingFragment newInstance(int page, String title) {
        ShoppingFragment fragmentFirst = new ShoppingFragment();
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
    public ShoppingFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        ArrayList<CityAttraction> shoppingAttractionsList = new ArrayList<CityAttraction>();
        shoppingAttractionsList.add(new CityAttraction(getString(R.string.shopping_1), getString(R.string.shopping_1_address)));
        shoppingAttractionsList.add(new CityAttraction(getString(R.string.shopping_2), getString(R.string.shopping_2_address)));
        shoppingAttractionsList.add(new CityAttraction(getString(R.string.shopping_3), getString(R.string.shopping_3_address)));
        shoppingAttractionsList.add(new CityAttraction(getString(R.string.shopping_4), getString(R.string.shopping_4_address)));
        shoppingAttractionsList.add(new CityAttraction(getString(R.string.shopping_5), getString(R.string.shopping_5_address)));

        CityAttractionAdapter itemsAdapter = new CityAttractionAdapter(getContext(), shoppingAttractionsList);

        ListView listView = (ListView) rootView.findViewById(R.id.attraction_list_view);
        listView.setAdapter(itemsAdapter);

        return rootView;
    }
}


