package com.example.yousafkhan.maktabajibreel.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yousafkhan.maktabajibreel.Models.ListViewItem;
import com.example.yousafkhan.maktabajibreel.R;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<ListViewItem> {

    public CustomAdapter(Context context, ArrayList<ListViewItem> dataList) {
        super(context, 0, dataList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext())
                                        .inflate(R.layout.listview_row, parent, false);

            holder = new ViewHolder();
            holder.rowIconImg = convertView.findViewById(R.id.listview_row_icon);
            holder.rowText = convertView.findViewById(R.id.currently_read_book_title);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ListViewItem item = getItem(position);

        holder.rowIconImg.setImageResource(item.getIconID());
        holder.rowText.setText(item.getTitle());

        return convertView;
    }

    private static class ViewHolder {
        private ImageView rowIconImg;
        private TextView rowText;
    }
}
