package com.example.yousafkhan.maktabajibreel.activities;

import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.yousafkhan.maktabajibreel.LocalManager;
import com.example.yousafkhan.maktabajibreel.R;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String languageToLoad  = LocalManager.getAppLanguageFromSharedPrefs(this);
        LocalManager.loadLanguage(this, languageToLoad);

        setContentView(R.layout.activity_about_us);

        // set toolbar as actionbar
        Toolbar toolbar = findViewById(R.id.toolbar_about_us);
        setSupportActionBar(toolbar);

        // add back button
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    // take back to home activity when back icon on toolbar is clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
