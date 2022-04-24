package com.example.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class easy extends AppCompatActivity {
    int score=0;
    int count=0;
    int randomIndex;
    String value1,value2,value3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easy);


        //declaring variables:-
        String Qs[]={"2+2=?","5+4=?","9+9=?","6+3=?","7+3=?","9-6=?","2*3=?","12/3=?","5*7=?","22/2=?"};
        String answers[]={"4","9","18","9","10","3","6","4","35","11"};
        randomIndex=(int)((Math.random())*10);;


        //initializing gui elements:-
        Button easyExit=findViewById(R.id.easyexit);
        Button easyAnswer1=findViewById(R.id.easyanswer1);
        Button easyAnswer2=findViewById(R.id.easyanswer2);
        Button easyAnswer3=findViewById(R.id.easyanswer3);
        TextView easyQ=findViewById(R.id.easyQ);
        easyQ.setText(Qs[randomIndex]);


        //generating random values:-
        int ran1=(int)((Math.random())*32);
        int ran2=(int)((Math.random())*32);
        int correctAnswerPosition=(int)((Math.random())*3);

        if(correctAnswerPosition==0){
            easyAnswer1.setText(answers[randomIndex]);
            easyAnswer2.setText(String.valueOf(ran1).toString());
            easyAnswer3.setText(String.valueOf(ran2).toString());
        }
        if(correctAnswerPosition==1){
            easyAnswer1.setText(String.valueOf(ran1).toString());
            easyAnswer2.setText(answers[randomIndex]);
            easyAnswer3.setText(String.valueOf(ran2).toString());
        }
        if(correctAnswerPosition==2){
            easyAnswer1.setText(String.valueOf(ran1).toString());
            easyAnswer2.setText(String.valueOf(ran2).toString());
            easyAnswer3.setText(answers[randomIndex]);
        }

        value1=easyAnswer1.getText().toString();
        value2=easyAnswer2.getText().toString();
        value3=easyAnswer3.getText().toString();


        //creating event handlers:-
        easyAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //initializing scores:-
                String value=easyAnswer1.getText().toString();
                if(value.equals(answers[randomIndex])){
                    score+=10;
                    MediaPlayer correct=MediaPlayer.create(getApplicationContext(),R.raw.correct);
                    correct.start();
                }if(!value.equals(answers[randomIndex])){
                    MediaPlayer wrong=MediaPlayer.create(getApplicationContext(),R.raw.wrong);
                    wrong.start();
                }
                count++;

                //reinitializing the values:-
                //random Qs:-
                randomIndex=(int)((Math.random())*10);
                easyQ.setText(Qs[randomIndex]);
                //random answers:-
                int ran1=(int)((Math.random())*32);
                int ran2=(int)((Math.random())*32);
                int correctAnswerPosition=(int)((Math.random())*3);
                if(correctAnswerPosition==0){
                    easyAnswer1.setText(answers[randomIndex]);
                    easyAnswer2.setText(String.valueOf(ran1));
                    easyAnswer3.setText(String.valueOf(ran2));
                }
                if(correctAnswerPosition==1){
                    easyAnswer1.setText(String.valueOf(ran1));
                    easyAnswer2.setText(answers[randomIndex]);
                    easyAnswer3.setText(String.valueOf(ran2));
                }
                if(correctAnswerPosition==2){
                    easyAnswer1.setText(String.valueOf(ran1));
                    easyAnswer2.setText(String.valueOf(ran2));
                    easyAnswer3.setText(answers[randomIndex]);
                }


                //setting the results into new activity:-
                if(count>=10){
                    if(score>=60){
                        Intent intent=new Intent(getApplicationContext(),winner.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("score",score);
                        bundle.putString("def","easy");
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                    if(score<60){
                        Intent intent=new Intent(getApplicationContext(),loser.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("score",score);
                        bundle.putString("def","easy");
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }

                }


            }
        });


        easyAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //initializing scores:-
                String value=easyAnswer2.getText().toString();
                if(value.equals(answers[randomIndex])){
                    score+=10;
                    MediaPlayer correct=MediaPlayer.create(getApplicationContext(),R.raw.correct);
                    correct.start();
                }if(!value.equals(answers[randomIndex])){
                    MediaPlayer wrong=MediaPlayer.create(getApplicationContext(),R.raw.wrong);
                    wrong.start();
                }
                count++;

                //reinitializing the values:-
                //random Qs:-
                randomIndex=(int)((Math.random())*10);
                easyQ.setText(Qs[randomIndex]);
                //random answers:-
                int ran1=(int)((Math.random())*32);
                int ran2=(int)((Math.random())*32);
                int correctAnswerPosition=(int)((Math.random())*3);
                if(correctAnswerPosition==0){
                    easyAnswer1.setText(answers[randomIndex]);
                    easyAnswer2.setText(String.valueOf(ran1));
                    easyAnswer3.setText(String.valueOf(ran2));
                }
                if(correctAnswerPosition==1){
                    easyAnswer1.setText(String.valueOf(ran1));
                    easyAnswer2.setText(answers[randomIndex]);
                    easyAnswer3.setText(String.valueOf(ran2));
                }
                if(correctAnswerPosition==2){
                    easyAnswer1.setText(String.valueOf(ran1));
                    easyAnswer2.setText(String.valueOf(ran2));
                    easyAnswer3.setText(answers[randomIndex]);
                }


                //setting the results into new activity:-
                if(count>=10){
                    if(score>=60){
                        Intent intent=new Intent(getApplicationContext(),winner.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("score",score);
                        bundle.putString("def","easy");
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                    if(score<60){
                        Intent intent=new Intent(getApplicationContext(),loser.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("score",score);
                        bundle.putString("def","easy");
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }

                }


            }
        });


        easyAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //initializing scores:-
                String value=easyAnswer3.getText().toString();
                if(value.equals(answers[randomIndex])){
                    score+=10;
                    MediaPlayer correct=MediaPlayer.create(getApplicationContext(),R.raw.correct);
                    correct.start();
                }if(!value.equals(answers[randomIndex])){
                    MediaPlayer wrong=MediaPlayer.create(getApplicationContext(),R.raw.wrong);
                    wrong.start();
                }
                count++;

                //reinitializing the values:-
                //random Qs:-
                randomIndex=(int)((Math.random())*10);
                easyQ.setText(Qs[randomIndex]);
                //random answers:-
                int ran1=(int)((Math.random())*32);
                int ran2=(int)((Math.random())*32);
                int correctAnswerPosition=(int)((Math.random())*3);
                if(correctAnswerPosition==0){
                    easyAnswer1.setText(answers[randomIndex]);
                    easyAnswer2.setText(String.valueOf(ran1));
                    easyAnswer3.setText(String.valueOf(ran2));
                }
                if(correctAnswerPosition==1){
                    easyAnswer1.setText(String.valueOf(ran1));
                    easyAnswer2.setText(answers[randomIndex]);
                    easyAnswer3.setText(String.valueOf(ran2));
                }
                if(correctAnswerPosition==2){
                    easyAnswer1.setText(String.valueOf(ran1));
                    easyAnswer2.setText(String.valueOf(ran2));
                    easyAnswer3.setText(answers[randomIndex]);
                }


                //setting the results into new activity:-
                if(count>=10){
                    if(score>=60){
                        Intent intent=new Intent(getApplicationContext(),winner.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("score",score);
                        bundle.putString("def","easy");
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                    if(score<60){
                        Intent intent=new Intent(getApplicationContext(),loser.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("score",score);
                        bundle.putString("def","easy");
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }

                }


            }
        });





        easyExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });






    }



}
