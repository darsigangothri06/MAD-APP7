package com.example.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox mango, banana;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bind the variables with front end objects

        mango = findViewById(R.id.checkBox);
        banana = findViewById(R.id.checkBox2);
        submit = findViewById(R.id.button);

        // on click listener

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mango.isChecked() && banana.isChecked())
                    Toast.makeText(MainActivity.this, "Mango and Banana are Selected", Toast.LENGTH_SHORT).show();
                else if(mango.isChecked())
                    Toast.makeText(MainActivity.this, "Only Mango is Selected", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Only Banana is Selected", Toast.LENGTH_SHORT).show();
            }
        });


    }
}