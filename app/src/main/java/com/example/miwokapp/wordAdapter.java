package com.example.miwokapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class wordAdapter extends ArrayAdapter<word> {
    private int mbackground_color;
    public wordAdapter(Activity context, ArrayList<word> numbers,int mbackground_color){
        super(context,0,numbers);
        this.mbackground_color = mbackground_color;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);//inflate means to read the XML file to translate them in the java code
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        word currentword = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwoktext = (TextView) listItemView.findViewById(R.id.list_miwok_items);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwoktext.setText(currentword.getMmiwok_translation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaulttext  = (TextView) listItemView.findViewById(R.id.default_items);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaulttext.setText(currentword.getMdefault_translation());

        //adding the image view for displaying the image on the screen
        ImageView imageview = (ImageView) listItemView.findViewById(R.id.image);
 //getting the image id
        int k = currentword.getmImageResourceId();
        boolean b = (k!=0);
        if(b == true){
            imageview.setImageResource(currentword.getmImageResourceId());
            imageview.setVisibility(View.VISIBLE);
        }
        else {
            imageview.setVisibility(View.GONE);
        }
        LinearLayout back_Color = (LinearLayout) listItemView.findViewById(R.id.container);
       int color1 = ContextCompat.getColor(getContext(),mbackground_color);
       back_Color.setBackgroundColor(color1);

        return listItemView;
    }
}
