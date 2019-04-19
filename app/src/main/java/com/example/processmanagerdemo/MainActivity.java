package com.example.processmanagerdemo;

import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ListActivity;
import android.content.Context;
import android.net.TrafficStats;
import android.os.Bundle;
import android.view.View;
//import android.widget.com.example.processmanagerdemo.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Process;


public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// Get running processes
        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        List<RunningAppProcessInfo> runningProcesses = manager.getRunningAppProcesses();
        if (runningProcesses != null && runningProcesses.size() > 0) {
// Set data to the list adapter
            setListAdapter(new ListAdapter(this, runningProcesses));
        } else {
// In case there are no processes running (not a chance :))
            Toast.makeText(getApplicationContext(), "No application is running", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // Get UID of the selected process
        int uid = ((RunningAppProcessInfo)getListAdapter().getItem(position)).uid;

        String processName = ((RunningAppProcessInfo)getListAdapter().getItem(position)).processName;
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        activityManager.killBackgroundProcesses(processName);

        // Display data
        Toast.makeText(getApplicationContext(), "UID " + uid + ", Process Name: " + processName + " killed if running. It should restart on click.", Toast.LENGTH_LONG).show();

       // kill process in same package
        int pid = ((RunningAppProcessInfo)getListAdapter().getItem(position)).pid;
        Process.sendSignal(pid, Process.SIGNAL_KILL); // or Process.killProcess(pid);
    }
}
