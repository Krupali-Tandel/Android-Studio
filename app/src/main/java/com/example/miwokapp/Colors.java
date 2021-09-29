package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {
private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //making the arraylist for the colors to be displayed

        final ArrayList<word> colors = new ArrayList<word>();
        colors.add(new word("Aka","Red",R.drawable.color_red,R.raw.red));
        colors.add(new word("Shiro","White",R.drawable.color_white,R.raw.white));
        colors.add(new word("Kuro","Black",R.drawable.color_black,R.raw.black));
        colors.add(new word("Kiiro","Yellow",R.drawable.color_mustard_yellow,R.raw.yellow));
        colors.add(new word("Midori","Green",R.drawable.color_green,R.raw.green));
        colors.add(new word("Chairo","Brown",R.drawable.color_brown,R.raw.brown));
        colors.add(new word("Haiiro","Gray ",R.drawable.color_gray,R.raw.gray));

       //seting up the list adapter
       //making the object of the wordapdapter
        wordAdapter coloradapter = new wordAdapter(this,colors,R.color.category_color);
        ListView colorsview = (ListView)findViewById(R.id.list);
        colorsview.setAdapter(coloradapter);
        colorsview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word color = colors.get(position);
                mediaPlayer= MediaPlayer.create(Colors.this,color.getmMediaplayerid());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                });
            }
        });

    }

    // to release the resources when the user clicks the home button
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