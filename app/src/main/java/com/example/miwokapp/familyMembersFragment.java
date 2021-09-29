package com.example.miwokapp;

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
 * Use the {@link familyMembersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class familyMembersFragment extends Fragment {
private MediaPlayer mediaPlayer;
private AudioManager audioManager;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public familyMembersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment familyMembersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static familyMembersFragment newInstance(String param1, String param2) {
        familyMembersFragment fragment = new familyMembersFragment();
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
        View rootview =  inflater.inflate(R.layout.word_list, container, false);
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
        wordAdapter familyadapter = new wordAdapter(getActivity(),family_members,R.color.category_familymember);

        ListView familyview = (ListView)rootview.findViewById(R.id.list);

        familyview.setAdapter(familyadapter);
        familyview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word family = family_members.get(position);
                mediaPlayer=  MediaPlayer.create(getActivity(),family.getmMediaplayerid());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer m) {
                        releaseMediaPlayer();
                    }
                });
            }

        });

        return rootview ;
    }
    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
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