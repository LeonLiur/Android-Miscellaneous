package com.example.spamclickr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Clicker extends AppCompatActivity {

    private TextView clickCounter;
    private TextView showTime;
    private Button clicker;
    private Button reset;
    private boolean started;
    private int counter;
    private long timeLeft = 15000;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicker);

        clickCounter = (TextView) findViewById(R.id.clickCounter);
        showTime = (TextView) findViewById(R.id.showTime);
        clicker = (Button) findViewById(R.id.buttonClick);
        reset = (Button) findViewById(R.id.buttonReset);
        started = false;
        counter = 0;
    }

    private void showTime() {
        while(timeLeft>=0){
            String time = "00:" + timeLeft/1000;
            showTime.setText(time);
        }
        timer.cancel();
        clicker.setEnabled(false);
    }

    public void onClick(View view){
        if(started){
            counter ++;
            clickCounter.setText(Integer.toString(counter));
        }else{
            started = true;
            clicker.setText("Click me!");
            CountDownTimer cdt = new CountDownTimer(timeLeft, 1000) {
                @Override
                public void onTick(long l) {
                    timeLeft = l;
                    updateTimer();
                }

                @Override
                public void onFinish() {
                    clicker.setEnabled(false);
                }
            }.start();
        }

    }

    private void updateTimer(){
        String time;
        if(timeLeft/1000<10){
            time = "00:0" + timeLeft/1000;
        }else{
            time = "00:"  + timeLeft/1000;
        }

        showTime.setText(time);
    }
}
