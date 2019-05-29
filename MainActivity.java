package com.example.dhorovyi.myfirstapplication;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
public Button button;
public TextView textView;
public MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      button   = findViewById(R.id.button2);
      textView = findViewById(R.id.textView);
      mediaPlayer = getExternalMediaDirs();

    }

    public void buttonS (View v) {

        button.se;
    }
}
