package com.example.app18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        textView=findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent st=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                st.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.UK);
                st.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                st.putExtra(RecognizerIntent.EXTRA_PROMPT,"SPEAK HERE");
                startActivityForResult(st,100);

            }
        });
    }
    protected void onActivityResult(int reqcode,int rescode,Intent data){
        super.onActivityResult(reqcode,rescode,data);
        switch (reqcode){
            case 100:{
                if(rescode==RESULT_OK && data!=null){
                    ArrayList Result1= data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textView.setText(Result1.get(0).toString());

                }
            }
        }
    }
}