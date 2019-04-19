package com.example.processmanagerdemo;

import java.util.List;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.ActivityManager;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.processmanagerdemo.R;

public class ListAdapter extends ArrayAdapter<RunningAppProcessInfo> {
    // List context
    private final Context context;
    // List values
    private final List<RunningAppProcessInfo> values;
    public ListAdapter(Context context, List<RunningAppProcessInfo> values) {
        super(context, R.layout.activity_main, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_main, parent, false);
        TextView appName = (TextView) rowView.findViewById(R.id.appNameText);
        int pid = getItem(position).pid;
        appName.setText("Name: " + values.get(position).processName + ", PID: " + pid);
        return rowView;
    }
}
