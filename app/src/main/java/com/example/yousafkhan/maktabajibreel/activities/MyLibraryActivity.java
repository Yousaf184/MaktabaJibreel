package com.example.yousafkhan.maktabajibreel.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.yousafkhan.maktabajibreel.Models.ListViewItem;
import com.example.yousafkhan.maktabajibreel.R;
import com.example.yousafkhan.maktabajibreel.adapters.CustomAdapter;

import java.util.ArrayList;

public class MyLibraryActivity extends AppCompatActivity {

    private ListView myLibraryListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_library);

        myLibraryListview = findViewById(R.id.myLibrary_listview);

        fillListView();
    }

    private ArrayList<ListViewItem> getDataList() {
        ArrayList<ListViewItem> dataList = new ArrayList<>();

        for(int i=0; i<15; i++) {
            dataList.add(new ListViewItem(getResources().getString(R.string.hadees_sharif), R.drawable.bars));
        }

        return dataList;
    }

    private void fillListView() {
        ArrayList<ListViewItem> dataList = getDataList();
        CustomAdapter adapter = new CustomAdapter(this, dataList);
        myLibraryListview.setAdapter(adapter);
    }
}
