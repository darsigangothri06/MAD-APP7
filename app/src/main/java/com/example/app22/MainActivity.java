package com.example.app22;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView sensorydata;
    SensorManager sm;  // for sensor manager
    List list; // to store set of sensors

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorydata = findViewById(R.id.sensorydata); // binding

        sm = (SensorManager)getSystemService(SENSOR_SERVICE); // to store type of sensors from sensor manager.
        list = sm.getSensorList(Sensor.TYPE_ACCELEROMETER); // to include accelerometer sensor in our list.
        if(list.size() > 0)
            sm.registerListener(gangothri, (Sensor)list.get(0), SensorManager.SENSOR_DELAY_NORMAL);
        else
            Toast.makeText(MainActivity.this, "No Accelerometer in your mobile phone", Toast.LENGTH_LONG).show();
    }

    SensorEventListener gangothri = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] values = sensorEvent.values;
            String dummy = "X: " + values[0] + "\nY: " + values[1] + "\nZ: " + values[2];
            sensorydata.setText(dummy);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };
}