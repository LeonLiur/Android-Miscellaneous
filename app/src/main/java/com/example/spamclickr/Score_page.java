package com.example.spamclickr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Score_page extends AppCompatActivity {
    private TextView textScore;
    private TextView textPB;
    private int counter;
    private TextView promptText;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference userRefPB = mRootRef.child("PB");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_page);

        textScore = findViewById(R.id.textScore);
        textPB = findViewById(R.id.textPB);
        promptText = findViewById(R.id.promptText);
        counter = Clicker.counter;
        String score = "Score: " + Integer.toString(counter);
        textScore.setText(score);
        double a  = 15.0/counter;
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
        String b = df.format(a);

        String text = "You click once every " + b + " seconds!";
        promptText.setText(text);
    }

    @Override
    protected void onStart() {
        super.onStart();
        userRefPB.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue(Integer.class) != null) {
                    if (counter > dataSnapshot.getValue(Integer.class)) {
                        userRefPB.setValue(counter);
                    }
                    textPB.setText("Personal Best: " + Long.toString(dataSnapshot.getValue(Long.class)));
                } else {
                    userRefPB.setValue(counter);
                    textPB.setText("Personal Best: " + Long.toString(dataSnapshot.getValue(Long.class)));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void onClickReset(View view){
        Intent intent = new Intent(Score_page.this, Clicker.class);
        startActivity(intent);
    }
}
