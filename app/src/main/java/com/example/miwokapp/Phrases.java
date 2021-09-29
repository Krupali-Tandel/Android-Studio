package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

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
        wordAdapter phraseadapter = new wordAdapter(this,phrases,R.color.category_phrases);
        ListView phraseview = (ListView)findViewById(R.id.list);
        phraseview.setAdapter(phraseadapter);



    }
}