package com.example.miwokapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NumberFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NumberFragment extends Fragment {
    private MediaPlayer mediaPlayer;//making the global mediaplayer object
    private AudioManager audioManager;// making the global audio manager
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NumberFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NumberFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NumberFragment newInstance(String param1, String param2) {
        NumberFragment fragment = new NumberFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.word_list, container, false);

        //inorder to referenced the Context we have to make the object
        //Initializing the variables for audio focus and playback management
        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
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
        wordAdapter adapter = new wordAdapter(getActivity(),number, R.color.category_number);
        //finding the list view from the number.xml file
        ListView listitem = (ListView) rootview.findViewById(R.id.list);
        listitem.setAdapter(adapter);
        listitem.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //playing the right audio file when the item is been clicked so obtaiing the position of the item
                word numbers = number.get(position);
                mediaPlayer = MediaPlayer.create(getActivity(), numbers.getmMediaplayerid());
                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer();
                    }
                });
            }
        });
        return rootview;
    }
    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
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