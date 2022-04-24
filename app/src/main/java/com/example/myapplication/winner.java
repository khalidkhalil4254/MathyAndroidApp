package com.example.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class winner extends AppCompatActivity {
    String mode;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winner);
        Button repeate=findViewById(R.id.winnerRepeate);
        Button winerHomebtn=findViewById(R.id.winerhomebtn);
        TextView scoreText=findViewById(R.id.winnerscore);
        Bundle bundle=getIntent().getExtras();
        mode= bundle.getString("def");
        int score= bundle.getInt("score");
        scoreText.setText(String.valueOf(score)+" Pts");
        MediaPlayer winSound=MediaPlayer.create(getApplicationContext(),R.raw.winner);
        winSound.start();


        repeate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mode.equals("easy")){
                    Intent intent=new Intent(getApplicationContext(),easy.class);
                    startActivity(intent);
                }
                if(mode.equals("med")){
                    Intent intent=new Intent(getApplicationContext(),medium.class);
                    startActivity(intent);
                }
                if(mode.equals("hard")){
                    Intent intent=new Intent(getApplicationContext(),hard.class);
                    startActivity(intent);
                }
                winSound.stop();

            }
        });


        winerHomebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });




    }
}
