package com.example.miwokapp;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link phrasesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class phrasesFragment extends Fragment {
private MediaPlayer mediaPlayer;
private AudioManager audiomanager;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public phrasesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment phrasesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static phrasesFragment newInstance(String param1, String param2) {
        phrasesFragment fragment = new phrasesFragment();
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
        //making the arraylist for storing the phrases with the japanese words
        ArrayList<word> phrases = new ArrayList<word>();
        phrases.add(new word("Eigo o hanasemasu ka.","Do you speak English?"));
        phrases.add(new word("Koko ni eigo o hanaseru hito wa imasu ka."," Does anyone here speak English?"));
        phrases.add(new word("Watashi wa nihongo ga sukoshi shika hanasemasen.","I only speak a little Japanese."));
        phrases.add(new word("O-namae wa nan desu ka. ","What is your name?"));
        phrases.add(new word("Watashi no namae wa Kaori desu. ","My name is Kaorii."));
        phrases.add(new word("O-genki desu ka.","How are you?"));
        phrases.add(new word("Genki desu.","I'm fine. Thank you"));
        phrases.add(new word("Oaidekite ureshī desu. ","I am very glad to meet you."));
        phrases.add(new word("Wakarimasen."," I don't understand."));
        phrases.add(new word("Nante iimashita ka."," What did you say?"));
        phrases.add(new word("Motto yukkuri hanashite kudasai.","Can you speak more slowly?"));
        phrases.add(new word("Yoku wakarimasu."," I understand you perfectly"));
        phrases.add(new word("Oha yō gozaimasu.","Good morning."));
        phrases.add(new word("Sumimasen."," I'm sorry."));
        phrases.add(new word("Dai jōbu desu.","That's all right"));
        phrases.add(new word("Konbanwa","Good Evening"));
        phrases.add(new word("Konnichiwa","Hello"));
        phrases.add(new word("Ohisashiburi desu ne","Long time no see"));
        phrases.add(new word("Yoku dekimashita ","Great job"));
        phrases.add(new word("Tanjoubi omedetou","Happy birthday"));
        phrases.add(new word("Ki o tsukete ","Be careful "));
        phrases.add(new word("Oyasumi nasai","Good night"));


        //making the arraylist adapter
        wordAdapter phraseadapter = new wordAdapter(getActivity(),phrases,R.color.category_phrases);
        ListView phraseview = (ListView)rootview.findViewById(R.id.list);
        phraseview.setAdapter(phraseadapter);
        return rootview;
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