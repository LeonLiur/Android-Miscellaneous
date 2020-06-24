package com.example.spamclickr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Clicker extends AppCompatActivity {

    private TextView clickCounter;
    private TextView showTime;
    private Button clicker;
    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicker);

        clickCounter = (TextView) findViewById(R.id.clickCounter);
        showTime = (TextView) findViewById(R.id.showTime);
        clicker = (Button) findViewById(R.id.buttonClick);
        reset = (Button) findViewById(R.id.)
    }
}
