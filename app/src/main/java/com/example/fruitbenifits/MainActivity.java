package com.example.fruitbenifits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button mainspeak, feedbutton;
    EditText mainfruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainspeak=findViewById(R.id.mainspeak);
        mainfruit=findViewById(R.id.mainfruit);
        feedbutton = findViewById(R.id.feedbutton);

        mainspeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent st=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                st.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.UK);
                st.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                st.putExtra(RecognizerIntent.EXTRA_PROMPT,"PICK A FRUIT");
                startActivityForResult(st,100);

            }
        });
        feedbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent B = new Intent(MainActivity.this, FifthActivity.class);
                startActivity(B);
            }
        });
    }
    protected void onActivityResult(int reqcode,int rescode,Intent data){
        super.onActivityResult(reqcode,rescode,data);
        switch (reqcode){
            case 100:{
                if(rescode==RESULT_OK && data!=null){
                    ArrayList Result1= data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    mainfruit.setText(Result1.get(0).toString());
                    MOVE();
                }
            }
        }
    }

    public void MOVE()
    {
        if(mainfruit.getText().toString().equals("Apple") || mainfruit.getText().toString().equals("apple"))
        {
            Toast.makeText(MainActivity.this, "Moving to Apple screen.. Stay Tuned", Toast.LENGTH_LONG).show();
            Intent I = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(I);
        }
        else if(mainfruit.getText().toString().equals("Banana") || mainfruit.getText().toString().equals("banana"))
        {
            Toast.makeText(MainActivity.this, "Moving to Banana screen.. Stay Tuned", Toast.LENGTH_SHORT).show();
            Intent J = new Intent(MainActivity.this, ThirdActivity.class);
            startActivity(J);
        }
        else if(mainfruit.getText().toString().equals("Orange") || mainfruit.getText().toString().equals("orange"))
        {
            Toast.makeText(MainActivity.this, "Moving to Orange screen.. Stay Tuned", Toast.LENGTH_SHORT).show();
            Intent L = new Intent(MainActivity.this, FourthActivity.class);
            startActivity(L);
        }
        else
        {
            Toast.makeText(MainActivity.this, "Invalid Command", Toast.LENGTH_SHORT).show();
        }
    }
}