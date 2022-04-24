package com.example.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    int x=0;
    MediaPlayer main;
    Intent easyIntent;
    Intent medIntent;
    Intent hardIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int music[]={R.raw.funday,R.raw.christmasmoments,R.raw.spook};
        main=MediaPlayer.create(getApplicationContext(),music[x]);
        main.start();

        Button easybtn=findViewById(R.id.easy);
        Button medbtn=findViewById(R.id.med);
        Button hardbtn=findViewById(R.id.hard);
        Button sound=findViewById(R.id.sound);
        Button mute=findViewById(R.id.mute);

        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.start();
            }
        });

        mute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.pause();
            }
        });

        main.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                x++;
                if(x==3){
                    x=0;
                }
                main=MediaPlayer.create(getApplicationContext(),music[x]);
                main.start();
            }
        });


        easybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.pause();
                easyIntent=new Intent(getApplicationContext(),easy.class);
                startActivity(easyIntent);
            }
        });


        medbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.pause();
                medIntent=new Intent(getApplicationContext(), medium.class);
                startActivity(medIntent);
            }
        });


        hardbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main.pause();
                hardIntent=new Intent(getApplicationContext(),hard.class);
                startActivity(hardIntent);
            }
        });
    }

    protected void onPause() {
        super.onPause();
        main.pause();
    }

    protected void onResume() {
        super.onResume();
        main.start();
    }

}