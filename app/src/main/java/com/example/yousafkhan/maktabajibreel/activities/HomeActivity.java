package com.example.yousafkhan.maktabajibreel.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.yousafkhan.maktabajibreel.LocalManager;
import com.example.yousafkhan.maktabajibreel.R;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    private MenuItem englishLangMenuItem;
    private MenuItem urduLangMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String languageToLoad  = LocalManager.getAppLanguageFromSharedPrefs(this);
        LocalManager.loadLanguage(this, languageToLoad);

        setContentView(R.layout.activity_home);

        NavigationView navigationDrawer = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);

        // set toolbar as ActionBar
        Toolbar toolbar = findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);

        // set navigation drawer icon on actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        navigationDrawer.setNavigationItemSelectedListener(this);
    }

    public void open(View v) {
        Intent i = new Intent(this, BookmarkActivity.class);
        startActivity(i);
    }


    // navigation drawer item selected listener
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        // make the menu item persist the highlight
        menuItem.setChecked(true);

        // close the navigation drawer when item is clicked
        drawerLayout.closeDrawers();

        switch (menuItem.getItemId()) {
            case R.id.nav_current_readings:
                openActivity(CurrentlyReadActivity.class);
                break;
            case R.id.nav_detailed_search:
                openActivity(DetailedSearchActivity.class);
                break;
            case R.id.nav_settings:
                openActivity(SettingsActivity.class);
                break;
            case R.id.nav_bookmark:
                openActivity(BookmarkActivity.class);
                break;
            case R.id.nav_my_libray:
                openActivity(MyLibraryActivity.class);
                break;
            case R.id.nav_about_us:
                openActivity(AboutUsActivity.class);
                break;
        }

        return false;
    }

    // opens new activity when any item in navigation drawer is selected
    private void openActivity(Class activityClass) {
        Intent newActivity = new Intent(this, activityClass);
        startActivity(newActivity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.language_menu, menu);

        englishLangMenuItem = menu.findItem(R.id.english_language);
        urduLangMenuItem = menu.findItem(R.id.urdu_langauge);

        String currentAppLanguage = LocalManager.getAppLanguageFromSharedPrefs(this);

        if(currentAppLanguage.equals("") || currentAppLanguage.equals("en")) {
            englishLangMenuItem.setChecked(true);
        } else {
            urduLangMenuItem.setChecked(true);
        }

        return true;
    }

    // open navigation drawer when menu icon on actionbar is tapped
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String currentAppLanguage;

        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;

            case R.id.english_language:
                currentAppLanguage  = LocalManager.getAppLanguageFromSharedPrefs(this);

                if(currentAppLanguage.equals("ur")) {
                    urduLangMenuItem.setChecked(false);
                    item.setChecked(true);
                    LocalManager.saveAppLanguage(this, "en");
                    recreate();
                }

                return true;

            case R.id.urdu_langauge:
                currentAppLanguage  = LocalManager.getAppLanguageFromSharedPrefs(this);

                if(currentAppLanguage.equals("en")) {
                    englishLangMenuItem.setChecked(false);
                    item.setChecked(true);
                    LocalManager.saveAppLanguage(this, "ur");
                    recreate();
                }

                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
