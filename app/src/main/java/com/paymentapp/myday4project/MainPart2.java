package com.paymentapp.myday4project;

import static com.paymentapp.myday4project.R.*;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainPart2 extends AppCompatActivity {
    TextView displayText;

    Button mybuten;
    @SuppressLint({"ResourceType", "SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.main_part_two);

        displayText = findViewById(R.id.textViewResult);


        String firstName = getIntent().getStringExtra("FIRST_NAME");
        String lastName = getIntent().getStringExtra("LAST_NAME");


        displayText.setText("Welcome to the App!, " + firstName + " " + lastName);

        mybuten = findViewById(id.buton3);
        mybuten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPart2.this,Part3.class);
                intent.putExtra("FIRST_NAME", firstName);
                intent.putExtra("LAST_NAME", lastName);
                startActivity(intent);
            }
        });
    }
}
