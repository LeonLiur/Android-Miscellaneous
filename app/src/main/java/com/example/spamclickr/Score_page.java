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

public class Score_page extends AppCompatActivity {
    private TextView textScore;
    private TextView textPB;
    private int counter;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference userRefPB = mRootRef.child("PB");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_page);

        textScore = findViewById(R.id.textScore);
        textPB = findViewById(R.id.textPB);
        counter = Clicker.counter;

        textScore.setText(Integer.toString(counter));
    }

    @Override
    protected void onStart() {
        super.onStart();
        userRefPB.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue(Integer.class) != null) {
                    if(counter > dataSnapshot.getValue(Integer.class)){
                        userRefPB.setValue(counter);
                    }
                    textPB.setText(Integer.toString(dataSnapshot.getValue(Integer.class)));
                }else{
                    userRefPB.setValue(counter);
                    textPB.setText(Integer.toString(dataSnapshot.getValue(Integer.class)));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void onClickRestart(View view){
        Intent intent = new Intent(Score_page.this, Clicker.class);
        startActivity(intent);
    }
}
