package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        releaseMediaPlayer();
        mediaPlayer = MediaPlayer.create(this,R.raw.song1);
        findViewById(R.id.play_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });
        findViewById(R.id.pause_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Toast.makeText(MainActivity.this,"it's done",Toast.LENGTH_SHORT).show();
            }
        });

                                                       }
    private void releaseMediaPlayer(){
        if(mediaPlayer!=null)
        {
            mediaPlayer.release();
            mediaPlayer=null;

        }                           }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }}