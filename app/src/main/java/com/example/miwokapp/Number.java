package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Number extends AppCompatActivity {
    private MediaPlayer mediaPlayer;//making the global mediaplayer object
    private AudioManager audioManager;// making the global audio manager

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        Context context = getApplicationContext();//inorder to referenced the Context we have to make the object
        //Initializing the variables for audio focus and playback management
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        //making the arraylist to store the numbers
        final ArrayList<word> number = new ArrayList<word>();
        //first we have to make the object and then add to the arraylist
//        word w = new word("one","lutti");
//        number.add(w);

        //there is the more precise way of doing this
        number.add(new word("ichi", "One", R.drawable.number_one, R.raw.number_one));
        number.add(new word("ni", "Two", R.drawable.number_two, R.raw.number_two));
        number.add(new word("san", "Three", R.drawable.number_three, R.raw.number_three));
        number.add(new word("yon", "Four", R.drawable.number_four, R.raw.number_four));
        number.add(new word("go", "Five", R.drawable.number_five, R.raw.number_five));
        number.add(new word("roku", "Six ", R.drawable.number_six, R.raw.number_six));
        number.add(new word("nana", "Seven ", R.drawable.number_seven, R.raw.number_seven));
        number.add(new word("ku", "Eight ", R.drawable.number_eight, R.raw.number_eight));
        number.add(new word("juu", "Nine", R.drawable.number_nine, R.raw.number_nine));
        number.add(new word("rei", "Ten", R.drawable.number_ten, R.raw.number_ten));


        //making the view to display on the screen
//        LinearLayout numbers_root_view = (LinearLayout) findViewById(R.id.number_root_view);
        //making the array adapter for the recycling view
        wordAdapter adapter = new wordAdapter(this, number, R.color.category_number);
        //finding the list view from the number.xml file
        ListView listitem = (ListView) findViewById(R.id.list);
        listitem.setAdapter(adapter);
        listitem.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //playing the right audio file when the item is been clicked so obtaiing the position of the item
                word numbers = number.get(position);
                mediaPlayer = MediaPlayer.create(Number.this, numbers.getmMediaplayerid());
                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
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
    private void releaseMediaPlayer() {
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