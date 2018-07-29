package com.example.dictionary;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import java.util.*;
import stanford.androidlib.SimpleActivity;

public class DictionaryActivity extends AppCompatActivity {

    private static final String[] WORDS = {
            "mediocre",       "UC Berkeley",
            "underachiever",  "Stanford A- student",
            "jerk",           "Marty Stepp",
            "defenestrate",   "to throw out of a window"
    };

    private Map<String, String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        dictionary = new HashMap<>();
        for (int i = 0; i < WORDS.length; i += 2) {
            dictionary.put(WORDS[i], WORDS[i + 1]);
        }

        ListView list = (ListView) findViewById(R.id.word_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(dictionary.keySet())
        );
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String word = parent.getItemAtPosition(position).toString();
                String defn = dictionary.get(word);
                toast(defn);
            }
        });
    }

    private void toast(String defn) {
    }
}



