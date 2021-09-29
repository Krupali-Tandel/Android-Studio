package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Family_Members extends AppCompatActivity {
private MediaPlayer mediaPlayer;//making the object of the mediaplayer class
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        //making the ArrayList for storing the family member data
        final ArrayList<word> family_members = new ArrayList<word>();
        family_members.add(new word("Otousan","Father ",R.drawable.family_father,R.raw.father));
        family_members.add(new word("Okaasan","Mother",R.drawable.family_mother,R.raw.mother));
        family_members.add(new word("Oniisan","Older Brother ",R.drawable.family_older_brother,R.raw.older_brother));
        family_members.add(new word("musuko","Son",R.drawable.family_son,R.raw.family_son));
        family_members.add(new word("musuko","daughter",R.drawable.family_daughter,R.raw.daughter));
        family_members.add(new word("ani ","older brother",R.drawable.family_older_brother,R.raw.older_brother));
        family_members.add(new word("otouto ","younger brother",R.drawable.family_younger_brother,R.raw.younger_brother));
        family_members.add(new word("ane","older sister",R.drawable.family_older_sister,R.raw.older_sister));
        family_members.add(new word("imouto ","younger sister",R.drawable.family_younger_sister,R.raw.younger_sister));
        family_members.add(new word("ojiisan","grandfather",R.drawable.family_grandfather,R.raw.grandpa));
        family_members.add(new word("obaasan","grandmother",R.drawable.family_grandmother,R.raw.grandma));
        family_members.add(new word("otto ","husband",R.drawable.family_father,R.raw.husband));
        family_members.add(new word(" tsuma ","wife",R.drawable.family_mother,R.raw.wife));


        //making the wordadapter object for the arrayadapter
        wordAdapter familyadapter = new wordAdapter(this,family_members,R.color.category_familymember);

        ListView familyview = (ListView)findViewById(R.id.list);

        familyview.setAdapter(familyadapter);
        familyview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word family = family_members.get(position);
               mediaPlayer=  MediaPlayer.create(Family_Members.this,family.getmMediaplayerid());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer m) {
                        releaseMediaPlayer();
                    }
                });
            }

        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
    //releasing the mediaplayer resources
    /**
     * Clean up the media player by releasing its resources.
     */
    private  void releaseMediaPlayer(){
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}