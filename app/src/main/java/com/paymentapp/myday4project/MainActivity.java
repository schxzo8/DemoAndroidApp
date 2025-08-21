package com.paymentapp.myday4project;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextLastName;
    Button mybutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextLastName = findViewById(R.id.editTextLastName);
        mybutton = findViewById(R.id.buton1);

        // Real-time validation for first name
        editTextName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = s.toString().trim();
                if (!input.isEmpty() && !input.matches("[a-zA-Z]+")) {
                    editTextName.setError("Only letters allowed!");
                    //showToast("Numbers are not allowed!");
                } else {
                    editTextName.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Real-time validation for last name
        editTextLastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = s.toString().trim();
                if (!input.isEmpty() && !input.matches("[a-zA-Z]+")) {
                    editTextLastName.setError("Only letters allowed!");
                    //showToast("Numbers are not allowed!");
                } else {
                    editTextLastName.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        //  Button click
        mybutton.setOnClickListener(v -> {
            String firstName = editTextName.getText().toString().trim();
            String lastName = editTextLastName.getText().toString().trim();

            boolean isValid = true;

            if (firstName.isEmpty()) {
                editTextName.setError("Please enter your first name");
                showToast("Enter First Name!");
                isValid = false;
            } else if (!firstName.matches("[a-zA-Z]+")) {
                editTextName.setError("First name should contain only letters!");
                //showToast("First name should contain only letters!");
                isValid = false;
            }

            if (lastName.isEmpty()) {
                editTextLastName.setError("Please enter your last name");
                showToast("Enter Last Name!");
                isValid = false;
            } else if (!firstName.matches("[a-zA-Z]+")) {
                editTextLastName.setError("Last name should contain only letters!");
                //showToast("Last name should contain only letters!");
                isValid = false;
            }

            // Proceed to next activity
            if (isValid) {
                Intent intent = new Intent(MainActivity.this, MainPart2.class);
                intent.putExtra("FIRST_NAME", firstName);
                intent.putExtra("LAST_NAME", lastName);
                startActivity(intent);
            }
        });
    }

    // Show Toast Method
    private void showToast(String message) {
        Toast toast = Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
