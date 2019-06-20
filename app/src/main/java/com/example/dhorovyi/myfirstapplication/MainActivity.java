package com.example.dhorovyi.myfirstapplication;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    double xValueOfAccelerometer, yValueOfAccelerometer, zValueOfAccelerometer;
    double xValueOfGyroscope, yValueOfGyroscope, zValueOfGyroscope;
    public Button button;
    public TextView textView;
    public TextView textViewAccelerometrdata;
    public  MediaPlayer mediaPlayer;
    private SensorManager sensorManager;
    private Sensor mySensorAccelerometer;
    private Sensor mySensorGyroscope;

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            xValueOfAccelerometer = event.values[0];
            yValueOfAccelerometer = event.values[1];
            zValueOfAccelerometer = event.values[2];
          //  Log.d(String.valueOf(valueOfAccelerometer), "x:" + xValueOfAccelerometer + ";y:" + yValueOfAccelerometer + ";z:" + zValueOfAccelerometer);

            /*
            if(xValueOfAccelerometer > 20) {
                Log.d(TAG, "X positive");
                Log.d(String.valueOf(valueOfAccelerometer),  "x:" + xValueOfAccelerometer + ";y:" + yValueOfAccelerometer + ";z:" + zValueOfAccelerometer);
            } else if(xValueOfAccelerometer < -20) {
                Log.d(TAG, "X negative");
                Log.d(String.valueOf(valueOfAccelerometer),  "x:" + xValueOfAccelerometer + ";y:" + yValueOfAccelerometer + ";z:" + zValueOfAccelerometer);
            }
            if(yValueOfAccelerometer > 20) {
                Log.d(TAG, "Y positive");
                Log.d(String.valueOf(valueOfAccelerometer), "x:" + xValueOfAccelerometer + ";y:" + yValueOfAccelerometer + ";z:" + zValueOfAccelerometer);
            } else if(yValueOfAccelerometer < -20) {
                Log.d(TAG, "Y negative");
                Log.d(String.valueOf(valueOfAccelerometer),  "x:" + xValueOfAccelerometer + ";y:" + yValueOfAccelerometer + ";z:" + zValueOfAccelerometer);
            }
            if(zValueOfAccelerometer > 20) {
                Log.d(TAG, "Z positive");
                Log.d(String.valueOf(valueOfAccelerometer), "x:" + xValueOfAccelerometer + ";y:" + yValueOfAccelerometer + ";z:" + zValueOfAccelerometer);
            } else if(zValueOfAccelerometer < -20) {
                Log.d(TAG, "Z negative");
                Log.d(String.valueOf(valueOfAccelerometer), "x:" + xValueOfAccelerometer + ";y:" + yValueOfAccelerometer + ";z:" + zValueOfAccelerometer);
            } */

            if(Math.abs(xValueOfAccelerometer) > 20 ) {
                Log.e(TAG, "Zieg heil!");
                ziegHeil();
                textViewAccelerometrdata.setText("Zieq hiel!");


            }

//            if (!mediaPlayer.isPlaying()) {
//                if (xValueOfAccelerometer >= 5) {
//                    try {
//                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//                        AssetFileDescriptor fileDescriptor = getAssets().openFd("a.mp3");
//                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                            @Override
//                            public void onCompletion(MediaPlayer mp) {
//                                mediaPlayer.stop();
//                            }
//                        });
//                        mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor());
//                        mediaPlayer.prepare();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    mediaPlayer.start();
//                }
//            }
//            if (mediaPlayer.isPlaying()) {
//                if (xValueOfAccelerometer <= -5) {
//                    mediaPlayer.stop();
//                    mediaPlayer.release();
//                    mediaPlayer = new MediaPlayer();
//                }
//            }
        }
            if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
                xValueOfGyroscope = event.values[0];
                yValueOfGyroscope = event.values[1];
                zValueOfGyroscope = event.values[2];
        //        Log.d(String.valueOf(valueOfGyroscope), "x:" + xValueOfGyroscope + ";y:" + yValueOfGyroscope + ";z:" + zValueOfGyroscope);
            }

    }

    public void ziegHeil() {
        if (!mediaPlayer.isPlaying()) {
                    try {
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        AssetFileDescriptor fileDescriptor = getAssets().openFd("a.mp3");
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mediaPlayer.stop();
                            }
                        });
                        mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor());
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mediaPlayer.start();

            }
            if (mediaPlayer.isPlaying()) {
                if (xValueOfAccelerometer <= -5) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = new MediaPlayer();
                }
            }
    }


    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, mySensorAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, mySensorGyroscope, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);
        textViewAccelerometrdata = findViewById(R.id.textView2);
        mediaPlayer = new MediaPlayer();
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mySensorAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mySensorGyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
    }

    public void buttonS(View v) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = new MediaPlayer();
        } else {
            try {
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                AssetFileDescriptor fileDescriptor = getAssets().openFd("a.mp3");
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaPlayer.stop();
                    }
                });
                mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor());
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();
        }
    }
}
