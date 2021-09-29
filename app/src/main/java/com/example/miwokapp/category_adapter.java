package com.example.miwokapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import android.content.Context;

//making the class to populate the fragments
public class category_adapter extends FragmentPagerAdapter {

private Context mContext ;
    //    getting the acess of the super constructor
    public category_adapter(Context context , FragmentManager fm){
        super(fm);
        mContext = context;
    }
    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return mContext.getString(R.string.category_numbers);
        }
        else if(position == 1){
            return mContext.getString(R.string.category_colors);
        }
        else if(position == 2 ){
            return mContext.getString(R.string.category_phrases);
        }
        else {
            return mContext.getString(R.string.category_family);
        }
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new NumberFragment();
        }
        else if(position == 1){
            return  new ColorFragment();
        }
        else if(position == 2){
            return new phrasesFragment();
        }
        else {
            return  new familyMembersFragment();
        }

    }
}
