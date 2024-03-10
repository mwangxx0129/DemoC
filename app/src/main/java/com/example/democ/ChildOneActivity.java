package com.example.democ;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.democ.util.SharedPreferencesUtil;

public class ChildOneActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child_one); // Make sure you have this layout

        final EditText editTextOne = findViewById(R.id.inputOne);
        final EditText editTextTwo = findViewById(R.id.inputTwo);
        Button saveButton = findViewById(R.id.saveButton);

        String textOne = SharedPreferencesUtil.getStringData(this, "textOne");
        String textTwo = SharedPreferencesUtil.getStringData(this, "textTwo");
        editTextOne.setText(textOne);
        editTextTwo.setText(textTwo);


        saveButton.setOnClickListener(view -> {
            SharedPreferencesUtil.saveStringData(this, "textOne", editTextOne.getText().toString());
            SharedPreferencesUtil.saveStringData(this, "textTwo", editTextTwo.getText().toString());

            // Show a message or feedback to the user, if needed
            Toast.makeText(ChildOneActivity.this, "Saved!", Toast.LENGTH_SHORT).show();
        });

    }
}
