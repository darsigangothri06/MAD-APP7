package com.example.app19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText to, sub,body;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        to = findViewById(R.id.to);
        sub = findViewById(R.id.sub);
        body = findViewById(R.id.body);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
    }
    private void sendEmail()
    {
        String[] s = {to.getText().toString()};
        String s1 = sub.getText().toString();
        String s2 = body.getText().toString();
        // my application want to communicate with gmail app
        Intent mailIntent = new Intent(Intent.ACTION_SEND);
        mailIntent.setData(Uri.parse("mailto:"));
        mailIntent.setType("text/plain");
        mailIntent.putExtra(Intent.EXTRA_EMAIL,s);
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, s1);
        mailIntent.putExtra(Intent.EXTRA_TEXT, s2);
        startActivity(Intent.createChooser(mailIntent, "send email"));
    }
}