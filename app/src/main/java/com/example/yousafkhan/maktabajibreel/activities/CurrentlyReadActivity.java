package com.example.yousafkhan.maktabajibreel.activities;

import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.yousafkhan.maktabajibreel.LocalManager;
import com.example.yousafkhan.maktabajibreel.Models.ListViewItem;
import com.example.yousafkhan.maktabajibreel.R;
import com.example.yousafkhan.maktabajibreel.adapters.CustomAdapter;

import java.util.ArrayList;

public class CurrentlyReadActivity extends AppCompatActivity {

    private ListView currentReadListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String languageToLoad  = LocalManager.getAppLanguageFromSharedPrefs(this);
        LocalManager.loadLanguage(this, languageToLoad);

        setContentView(R.layout.activity_currently_read);

        currentReadListview = findViewById(R.id.current_readings_listview);

        fillListView();

        // set toolbar as actionbar
        Toolbar toolbar = findViewById(R.id.toolbar_currently_read);
        setSupportActionBar(toolbar);

        // add back button
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private ArrayList<ListViewItem> getDataList() {
        ArrayList<ListViewItem> dataList = new ArrayList<>();

        for(int i=0; i<15; i++) {
            dataList.add(new ListViewItem(getResources().getString(R.string.hadees_sharif), R.drawable.book));
        }

        return dataList;
    }

    private void fillListView() {
        ArrayList<ListViewItem> dataList = getDataList();
        CustomAdapter adapter = new CustomAdapter(this, dataList);
        currentReadListview.setAdapter(adapter);
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
