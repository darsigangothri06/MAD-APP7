package com.example.app16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
    }
    private void sendEmail()
    {
        String[] to = {"divyasreemannava@gmail.com"};

        // my application want to communicate with gmail app
        Intent mailIntent = new Intent(Intent.ACTION_SEND);
        mailIntent.setData(Uri.parse("mailto:"));
        mailIntent.setType("text/plain");
        mailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Static Email Demo mam");
        mailIntent.putExtra(Intent.EXTRA_TEXT, "Hi Mam");
        startActivity(Intent.createChooser(mailIntent, "send email"));
    }
}