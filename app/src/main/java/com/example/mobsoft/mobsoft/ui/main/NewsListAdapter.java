package com.example.mobsoft.mobsoft.ui.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.mobsoft.mobsoft.model.News;

/**
 * Created by mobsoft on 2017. 04. 21..
 */

public class NewsListAdapter extends ArrayAdapter<News> {
    public NewsListAdapter(Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
