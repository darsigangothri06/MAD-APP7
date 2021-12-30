package com.example.app25;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class MainActivity extends AppCompatActivity {
    Button buttonGenQRCode;
    ImageView imageViewQRCode;
    EditText editTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGenQRCode = findViewById(R.id.buttonGenQRCode);
        imageViewQRCode = findViewById(R.id.imageViewQRCode);
        editTextInput = findViewById(R.id.editTextInput);

        buttonGenQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateQRCode();
            }
        });
    }

    protected void generateQRCode()
    {
        String text = editTextInput.getText().toString();
        if(TextUtils.isEmpty(text))
        {
            Toast.makeText(MainActivity.this, "Enter text", Toast.LENGTH_SHORT).show();
            editTextInput.setError("Kindly enter the text to get QR Code");
            return;
        }
        try {
            QRGEncoder qrgEncoder = new QRGEncoder(text, null, QRGContents.Type.TEXT,150);
            Bitmap bitmap = qrgEncoder.encodeAsBitmap();
            imageViewQRCode.setImageBitmap(bitmap);
        } catch (WriterException e)
        {
            e.printStackTrace();
        }
    }
}