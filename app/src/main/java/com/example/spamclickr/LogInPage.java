package com.example.spamclickr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LogInPage extends AppCompatActivity {

    private EditText userText;
    private EditText passText;
    private Button button;
    private TextView infoBar;

    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference().getRoot();
    private DatabaseReference userRefUsername;
    private DatabaseReference userRefPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        userText = (EditText) findViewById(R.id.userBox);
        passText = (EditText) findViewById(R.id.passwordBox);
        button = (Button) findViewById(R.id.logInButton);
        infoBar = (TextView) findViewById(R.id.infoBar);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_page);
    }

    private void validate(){
    }
}
