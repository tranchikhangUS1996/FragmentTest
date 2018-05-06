package com.tranchikhang.fragmenttest;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class StopwatchFragment extends Fragment implements View.OnClickListener {
    private int seconds;
    private boolean running;
    private boolean wasRunning;

    public StopwatchFragment() {
        seconds = 0;
        running = false;
        wasRunning = false;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
    }

    public void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    public void onResume() {
        super.onResume();
        if(wasRunning) {
            running = true;
        }
    }
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_stopwatch,container,false);
        Button bStart = (Button) layout.findViewById(R.id.start);
        Button bStop = (Button) layout.findViewById(R.id.stop);
        Button bReset = (Button) layout.findViewById(R.id.reset);
        bStart.setOnClickListener(this);
        bStop.setOnClickListener(this);
        bReset.setOnClickListener(this);
        runtimer(layout);
        return layout;
    }

    private void onClickStart(View view) {
        running = true;
    }
    private void onClickStop(View view) {
        running = false;
    }
    private void onClickReset(View view) {
        running = false;
        seconds = 0;
    }
    private void runtimer(View layout) {
        final TextView timeView = (TextView) layout.findViewById(R.id.time);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.start:
                onClickStart(view);
                break;
            case R.id.stop:
                onClickStop(view);
                break;
            case R.id.reset:
                onClickReset(view);
                break;
            default:
                break;
        }
    }
}
