package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button submit, reset;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Linking frontend variables with backend variables
        submit = findViewById(R.id.submit);
        reset = findViewById(R.id.reset);
        message = findViewById(R.id.message);

        // Adding text message when submit is pressed
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message.setText("Hello, Gangothri!");  // setText is used to set the text to our variable
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message.setText("");  // Clearing text -- means using empty string
            }
        });
    }
}