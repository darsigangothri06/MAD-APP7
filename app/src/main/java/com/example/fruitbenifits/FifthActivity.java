package com.example.fruitbenifits;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FifthActivity extends AppCompatActivity {
    Button button;
    EditText feedtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_fifth);

        button = findViewById(R.id.button);
        feedtext = findViewById(R.id.feedtext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ActivityCompat.checkSelfPermission(FifthActivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
                    return;
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("09381451765", null, feedtext.getText().toString(), null, null);
                Toast.makeText(FifthActivity.this, "FEEDBACK SENT", Toast.LENGTH_SHORT).show();
            }
        });
    }
}