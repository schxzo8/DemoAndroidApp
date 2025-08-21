package com.paymentapp.myday4project;

import static java.sql.Types.NULL;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editTextName, editTextLastName;
    Button mybutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextName);
        editTextLastName = findViewById(R.id.editTextLastName);
        mybutton = findViewById(R.id.buton1);

        mybutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String firstName = editTextName.getText().toString().trim();
                String lastName = editTextLastName.getText().toString().trim();

                //input validation for empty fields
                if(firstName.isEmpty()){
                    editTextName.setError("Please enter your first name");
                    Toast toast = Toast.makeText(MainActivity.this, "Enter First Name!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0,0);
                    toast.show();
                    return;
                }
                if(lastName.isEmpty()){
                    editTextLastName.setError("Please enter your last name");
                    Toast.makeText(MainActivity.this, "Enter Last Name!", Toast.LENGTH_LONG).show();
                    return;
                }

                //checking for strings only
                if(!firstName.matches("[a-zA-Z]+")){
                    editTextName.setError("Only letters allowed");
                    return;
                }
                if(!lastName.matches("[a-zA-Z]+")){
                    editTextLastName.setError("Only letters allowed");
                    return;
                }
                
                Intent intent = new Intent(MainActivity.this,MainPart2.class);
                intent.putExtra("FIRST_NAME", firstName);
                intent.putExtra("LAST_NAME", lastName);
                startActivity(intent);
            }
        });

    }




}