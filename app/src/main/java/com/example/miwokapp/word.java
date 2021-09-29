package com.example.miwokapp;

public class word {
    private String mmiwok_translation;
    private String mdefault_translation;
    private int mImageResourceId ;
    private int mMediaplayerid ;


    //making the constructor of the class
    public word(String mmiwok_translation,String mdefault_translation,int mMediaplayerid){
        this.mmiwok_translation = mmiwok_translation;
        this.mdefault_translation = mdefault_translation;
        this.mMediaplayerid = mMediaplayerid;


    }
    //we have overloaded the method
    public word(String mmiwok_translation, String mdefault_translation, int mImageResourceId ,int mMediaplayerid){
        this.mmiwok_translation = mmiwok_translation;
        this.mdefault_translation = mdefault_translation;
        this.mImageResourceId = mImageResourceId;
        this.mMediaplayerid = mMediaplayerid;
    }

    public word(String mmiwok_translation, String mdefault_translation){
        this.mmiwok_translation = mmiwok_translation;
        this.mdefault_translation = mdefault_translation;
        this.mImageResourceId = mImageResourceId;

    }

    //making the method for the translation of the words
    public String getMmiwok_translation(){
        return mmiwok_translation;
    }

    public String getMdefault_translation(){
        return mdefault_translation;
    }

    public  int getmImageResourceId(){
        return mImageResourceId;
    }
    public int getmMediaplayerid(){
        return mMediaplayerid;
    }


}
