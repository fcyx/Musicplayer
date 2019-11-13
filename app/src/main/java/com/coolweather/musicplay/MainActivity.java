package com.coolweather.musicplay;
import android.app.MediaRouteButton;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private TextView play, pause;
    private MediaPlayer mediaPlayer;
    private TextView hint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = (TextView) findViewById(R.id.tv_play);
        pause = (TextView) findViewById(R.id.tv_pause);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.a);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                play();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    pause.setText("继续");
                    play.setEnabled(true);
                } else {
                    mediaPlayer.start();
                    pause.setText("暂停");
                    play.setEnabled(false);
                }
            }
        });

    }


    private void play() {
        try {
            System.out.println("--------------->1");
            mediaPlayer.reset();
            mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.a);//重新设置要播放的音频  
            mediaPlayer.start();//开始播放  

            play.setEnabled(false);
            pause.setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void onDestory(){
        mediaPlayer.release();
        super.onDestroy();
    }

}





