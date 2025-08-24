package com.paymentapp.myday4project.controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.paymentapp.myday4project.R;
import com.paymentapp.myday4project.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextLastName;
    Button myButton;
    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextLastName = findViewById(R.id.editTextLastName);
        myButton = findViewById(R.id.buton1);

        viewModel = new MainViewModel(this);

        myButton.setOnClickListener(v -> {
            String firstName = editTextName.getText().toString().trim();
            String lastName = editTextLastName.getText().toString().trim();

            String firstError = viewModel.getFirstNameError(firstName);
            String lastError = viewModel.getLastNameError(lastName);

            editTextName.setError(firstError);
            editTextLastName.setError(lastError);

            if (firstError == null && lastError == null) {
                viewModel.saveUser(firstName, lastName); // Save to Room DB

                Intent intent = new Intent(MainActivity.this, ResultHelper.class);
                intent.putExtra("FIRST_NAME", firstName);
                intent.putExtra("LAST_NAME", lastName);
                startActivity(intent);
            }
        });
    }
}
