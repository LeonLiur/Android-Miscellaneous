package com.example.spamclickr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.startbutton);
    }

    public void onClickToStart(View view){
        Intent intent = new Intent(MainActivity.this, LogInPage.class);
        startActivity(intent);
    }
}
