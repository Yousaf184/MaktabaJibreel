package com.example.yousafkhan.maktabajibreel.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yousafkhan.maktabajibreel.LocalManager;
import com.example.yousafkhan.maktabajibreel.R;

public class SearchResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String languageToLoad  = LocalManager.getAppLanguageFromSharedPrefs(this);
        LocalManager.loadLanguage(this, languageToLoad);

        setContentView(R.layout.activity_search_results);
    }
}
