package com.example.tourguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.List;
import android.widget.LinearLayout;

public class CityAttractionAdapter extends ArrayAdapter<CityAttraction> {

    private ArrayList<CityAttraction> mCityAttractionsList;

    public CityAttractionAdapter(Context context, ArrayList<CityAttraction> attractions) {
        super(context, 0, attractions);
        mCityAttractionsList = attractions;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        CityAttraction cityAttraction = getItem(position);

        TextView tvAttractionName = (TextView) listItemView.findViewById(R.id.attraction_name);
        tvAttractionName.setText(cityAttraction.getName());

        TextView tvAttractionAddress = (TextView) listItemView.findViewById(R.id.attraction_address);
        tvAttractionAddress.setText(cityAttraction.getAddress());

        LinearLayout imageContainer = (LinearLayout) listItemView.findViewById(R.id.image_container);
        if ( cityAttraction.hasImage() ) {
            ImageView ivAttractionLogo = (ImageView) listItemView.findViewById(R.id.logo);
            ivAttractionLogo.setImageResource(cityAttraction.getImageResourceId());
            imageContainer.setVisibility(View.VISIBLE);
        } else {
            imageContainer.setVisibility(View.GONE);
        }

        return listItemView;
    }
}