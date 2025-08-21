package com.paymentapp.myday4project;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Part3 extends AppCompatActivity {
    TextView displayText;
    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats);

        displayText = findViewById(R.id.viewStats);

        String firstName = getIntent().getStringExtra("FIRST_NAME");
        String lastName = getIntent().getStringExtra("LAST_NAME");


        displayText.setText("Your First Name: " + firstName + "\n" + "Your Last Name: " + lastName + "\n" + "Your Age: 19");




    }
}
