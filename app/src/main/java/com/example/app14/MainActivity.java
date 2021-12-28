package com.example.app14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {
    Button button;
    String phno = "09440274130";
    String message = "Hello!! Static text message demo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
                    return;

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phno, null,message,null,null);
                Toast.makeText(MainActivity.this, "SMS Sent", Toast.LENGTH_LONG).show();
            }
        });

    }
}