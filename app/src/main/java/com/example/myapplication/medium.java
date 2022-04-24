package com.example.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class medium extends AppCompatActivity {
    int score=0;
    int count=0;
    Intent lost;
    int randomIndex;
    String value1,value2,value3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medium);


        //declaring variables:-
        String Qs[]={"2+2=?","5+4=?","9+9=?","6+3=?","7+3=?","9-6=?","2*3=?","12/3=?","5*7=?","22/2=?"};
        String answers[]={"4","9","18","9","10","3","6","4","35","11"};
        randomIndex=(int)((Math.random())*10);


        //initializing gui elements:-
        Button medExit=findViewById(R.id.medexit);
        Button medAnswer1=findViewById(R.id.medanswer1);
        Button medAnswer2=findViewById(R.id.medanswer2);
        Button medAnswer3=findViewById(R.id.medanswer3);
        TextView medQ=findViewById(R.id.medQ);
        TextView time=findViewById(R.id.medtime);
        medQ.setText(Qs[randomIndex]);


        //generating random values:-
        int ran1=(int)((Math.random())*32);
        int ran2=(int)((Math.random())*32);
        int correctAnswerPosition=(int)((Math.random())*3);

        if(correctAnswerPosition==0){
            medAnswer1.setText(answers[randomIndex]);
            medAnswer2.setText(String.valueOf(ran1).toString());
            medAnswer3.setText(String.valueOf(ran2).toString());
        }
        if(correctAnswerPosition==1){
            medAnswer1.setText(String.valueOf(ran1).toString());
            medAnswer2.setText(answers[randomIndex]);
            medAnswer3.setText(String.valueOf(ran2).toString());
        }
        if(correctAnswerPosition==2){
            medAnswer1.setText(String.valueOf(ran1).toString());
            medAnswer2.setText(String.valueOf(ran2).toString());
            medAnswer3.setText(answers[randomIndex]);
        }

        value1=medAnswer1.getText().toString();
        value2=medAnswer2.getText().toString();
        value3=medAnswer3.getText().toString();




        //declaring countdown timer:-
        CountDownTimer timer= new CountDownTimer(21000, 1000) {
            @Override
            public void onTick(long l) {
                int sec= (int) (l/1000)%60;
                time.setText(String.valueOf(sec)+"s");
            }

            @Override
            public void onFinish() {
                if(score>=60){
                    Intent intent=new Intent(getApplicationContext(),winner.class);
                    Bundle bundle=new Bundle();
                    bundle.putInt("score",score);
                    bundle.putString("def","med");
                    intent.putExtras(bundle);
                    startActivity(intent);
                }if(score<60){
                    Intent intent=new Intent(getApplicationContext(),loser.class);
                    Bundle bundle=new Bundle();
                    bundle.putInt("score",score);
                    bundle.putString("def","med");
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        }.start();



        //creating event handlers:-
        medAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


              timer.start();


                //initializing scores:-
                String value=medAnswer1.getText().toString();
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
                medQ.setText(Qs[randomIndex]);
                //random answers:-
                int ran1=(int)((Math.random())*32);
                int ran2=(int)((Math.random())*32);
                int correctAnswerPosition=(int)((Math.random())*3);
                if(correctAnswerPosition==0){
                    medAnswer1.setText(answers[randomIndex]);
                    medAnswer2.setText(String.valueOf(ran1));
                    medAnswer3.setText(String.valueOf(ran2));
                }
                if(correctAnswerPosition==1){
                    medAnswer1.setText(String.valueOf(ran1));
                    medAnswer2.setText(answers[randomIndex]);
                    medAnswer3.setText(String.valueOf(ran2));
                }
                if(correctAnswerPosition==2){
                    medAnswer1.setText(String.valueOf(ran1));
                    medAnswer2.setText(String.valueOf(ran2));
                    medAnswer3.setText(answers[randomIndex]);
                }


                //setting the results into new activity:-
                if(count>=10){
                    if(score>=60){
                        timer.cancel();
                        Intent intent=new Intent(getApplicationContext(),winner.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("score",score);
                        bundle.putString("def","med");
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                    if(score<60){
                        timer.cancel();
                        Intent intent=new Intent(getApplicationContext(),loser.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("score",score);
                        bundle.putString("def","med");
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }

                }


            }
        });


        medAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                timer.start();



                //initializing scores:-
                String value=medAnswer2.getText().toString();
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
                medQ.setText(Qs[randomIndex]);
                //random answers:-
                int ran1=(int)((Math.random())*32);
                int ran2=(int)((Math.random())*32);
                int correctAnswerPosition=(int)((Math.random())*3);
                if(correctAnswerPosition==0){
                    medAnswer1.setText(answers[randomIndex]);
                    medAnswer2.setText(String.valueOf(ran1));
                    medAnswer3.setText(String.valueOf(ran2));
                }
                if(correctAnswerPosition==1){
                    medAnswer1.setText(String.valueOf(ran1));
                    medAnswer2.setText(answers[randomIndex]);
                    medAnswer3.setText(String.valueOf(ran2));
                }
                if(correctAnswerPosition==2){
                    medAnswer1.setText(String.valueOf(ran1));
                    medAnswer2.setText(String.valueOf(ran2));
                    medAnswer3.setText(answers[randomIndex]);
                }


                //setting the results into new activity:-
                if(count>=10){
                    if(score>=60){
                        timer.cancel();
                        Intent intent=new Intent(getApplicationContext(),winner.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("score",score);
                        bundle.putString("def","med");
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                    if(score<60){
                        timer.cancel();
                        Intent intent=new Intent(getApplicationContext(),loser.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("score",score);
                        bundle.putString("def","med");
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }

                }


            }
        });


        medAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                timer.start();



                //initializing scores:-
                String value=medAnswer3.getText().toString();
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
                medQ.setText(Qs[randomIndex]);
                //random answers:-
                int ran1=(int)((Math.random())*32);
                int ran2=(int)((Math.random())*32);
                int correctAnswerPosition=(int)((Math.random())*3);
                if(correctAnswerPosition==0){
                    medAnswer1.setText(answers[randomIndex]);
                    medAnswer2.setText(String.valueOf(ran1));
                    medAnswer3.setText(String.valueOf(ran2));
                }
                if(correctAnswerPosition==1){
                    medAnswer1.setText(String.valueOf(ran1));
                    medAnswer2.setText(answers[randomIndex]);
                    medAnswer3.setText(String.valueOf(ran2));
                }
                if(correctAnswerPosition==2){
                    medAnswer1.setText(String.valueOf(ran1));
                    medAnswer2.setText(String.valueOf(ran2));
                    medAnswer3.setText(answers[randomIndex]);
                }


                //setting the results into new activity:-
                if(count>=10){
                    if(score>=60){
                        timer.cancel();
                        Intent intent=new Intent(getApplicationContext(),winner.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("score",score);
                        bundle.putString("def","med");
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                    if(score<60){
                        timer.cancel();
                        Intent intent=new Intent(getApplicationContext(),loser.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("score",score);
                        bundle.putString("def","med");
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }

                }


            }
        });




        //creating event handlers:-
        medExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });




    }
}
