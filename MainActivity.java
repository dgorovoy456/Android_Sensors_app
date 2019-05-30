package com.example.dhorovyi.myfirstapplication;

import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    public Button button;
    public TextView textView;
    public MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);
        mediaPlayer = new MediaPlayer();

    }

    public void buttonS(View v) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=new MediaPlayer();
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
