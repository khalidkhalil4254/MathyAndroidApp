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

public class hard extends AppCompatActivity {
    int score=0;
    int count=0;
    int clck=10;
    int randomIndex;
    String value1,value2,value3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hard);
        //declaring variables:-
        String Qs[]={"2+2=?","5+4=?","9+9=?","6+3=?","7+3=?","9-6=?","2*3=?","12/3=?","5*7=?","22/2=?"};
        String answers[]={"4","9","18","9","10","3","6","4","35","11"};
        randomIndex=(int)((Math.random())*10);


        //initializing gui elements:-
        Button hardExit=findViewById(R.id.hardexit);
        Button hardAnswer1=findViewById(R.id.hardanswer1);
        Button hardAnswer2=findViewById(R.id.hardanswer2);
        Button hardAnswer3=findViewById(R.id.hardanswer3);
        TextView hardQ=findViewById(R.id.hardQ);
        TextView time=findViewById(R.id.hardtime);
        hardQ.setText(Qs[randomIndex]);


        //generating random values:-
        int ran1=(int)((Math.random())*32);
        int ran2=(int)((Math.random())*32);
        int correctAnswerPosition=(int)((Math.random())*3);

        if(correctAnswerPosition==0){
            hardAnswer1.setText(answers[randomIndex]);
            hardAnswer2.setText(String.valueOf(ran1).toString());
            hardAnswer3.setText(String.valueOf(ran2).toString());
        }
        if(correctAnswerPosition==1){
            hardAnswer1.setText(String.valueOf(ran1).toString());
            hardAnswer2.setText(answers[randomIndex]);
            hardAnswer3.setText(String.valueOf(ran2).toString());
        }
        if(correctAnswerPosition==2){
            hardAnswer1.setText(String.valueOf(ran1).toString());
            hardAnswer2.setText(String.valueOf(ran2).toString());
            hardAnswer3.setText(answers[randomIndex]);
        }

        value1=hardAnswer1.getText().toString();
        value2=hardAnswer2.getText().toString();
        value3=hardAnswer3.getText().toString();



        //declaring countdown timer:-
        CountDownTimer timer= new CountDownTimer(11000, 1000) {
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
        hardAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                timer.start();


                //initializing scores:-
                String value=hardAnswer1.getText().toString();
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
                hardQ.setText(Qs[randomIndex]);
                //random answers:-
                int ran1=(int)((Math.random())*32);
                int ran2=(int)((Math.random())*32);
                int correctAnswerPosition=(int)((Math.random())*3);
                if(correctAnswerPosition==0){
                    hardAnswer1.setText(answers[randomIndex]);
                    hardAnswer2.setText(String.valueOf(ran1));
                    hardAnswer3.setText(String.valueOf(ran2));
                }
                if(correctAnswerPosition==1){
                    hardAnswer1.setText(String.valueOf(ran1));
                    hardAnswer2.setText(answers[randomIndex]);
                    hardAnswer3.setText(String.valueOf(ran2));
                }
                if(correctAnswerPosition==2){
                    hardAnswer1.setText(String.valueOf(ran1));
                    hardAnswer2.setText(String.valueOf(ran2));
                    hardAnswer3.setText(answers[randomIndex]);
                }


                //setting the results into new activity:-
                if(count>=10){
                    if(score>=60){
                        timer.cancel();
                        Intent intent=new Intent(getApplicationContext(),winner.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("score",score);
                        bundle.putString("def","hard");
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                    if(score<60){
                        timer.cancel();
                        Intent intent=new Intent(getApplicationContext(),loser.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("score",score);
                        bundle.putString("def","hard");
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }

                }


            }
        });


        hardAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                timer.start();


                //initializing scores:-
                String value=hardAnswer2.getText().toString();
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
                hardQ.setText(Qs[randomIndex]);
                //random answers:-
                int ran1=(int)((Math.random())*32);
                int ran2=(int)((Math.random())*32);
                int correctAnswerPosition=(int)((Math.random())*3);
                if(correctAnswerPosition==0){
                    hardAnswer1.setText(answers[randomIndex]);
                    hardAnswer2.setText(String.valueOf(ran1));
                    hardAnswer3.setText(String.valueOf(ran2));
                }
                if(correctAnswerPosition==1){
                    hardAnswer1.setText(String.valueOf(ran1));
                    hardAnswer2.setText(answers[randomIndex]);
                    hardAnswer3.setText(String.valueOf(ran2));
                }
                if(correctAnswerPosition==2){
                    hardAnswer1.setText(String.valueOf(ran1));
                    hardAnswer2.setText(String.valueOf(ran2));
                    hardAnswer3.setText(answers[randomIndex]);
                }


                //setting the results into new activity:-
                if(count>=10){
                    if(score>=60){
                        timer.cancel();
                        Intent intent=new Intent(getApplicationContext(),winner.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("score",score);
                        bundle.putString("def","hard");
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                    if(score<60){
                        timer.cancel();
                        Intent intent=new Intent(getApplicationContext(),loser.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("score",score);
                        bundle.putString("def","hard");
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }

                }


            }
        });


        hardAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                timer.start();


                //initializing scores:-
                String value=hardAnswer3.getText().toString();
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
                hardQ.setText(Qs[randomIndex]);
                //random answers:-
                int ran1=(int)((Math.random())*32);
                int ran2=(int)((Math.random())*32);
                int correctAnswerPosition=(int)((Math.random())*3);
                if(correctAnswerPosition==0){
                    hardAnswer1.setText(answers[randomIndex]);
                    hardAnswer2.setText(String.valueOf(ran1));
                    hardAnswer3.setText(String.valueOf(ran2));
                }
                if(correctAnswerPosition==1){
                    hardAnswer1.setText(String.valueOf(ran1));
                    hardAnswer2.setText(answers[randomIndex]);
                    hardAnswer3.setText(String.valueOf(ran2));
                }
                if(correctAnswerPosition==2){
                    hardAnswer1.setText(String.valueOf(ran1));
                    hardAnswer2.setText(String.valueOf(ran2));
                    hardAnswer3.setText(answers[randomIndex]);
                }


                //setting the results into new activity:-
                if(count>=10){
                    if(score>=60){
                        timer.cancel();
                        Intent intent=new Intent(getApplicationContext(),winner.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("score",score);
                        bundle.putString("def","hard");
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                    if(score<60){
                        timer.cancel();
                        Intent intent=new Intent(getApplicationContext(),loser.class);
                        Bundle bundle=new Bundle();
                        bundle.putInt("score",score);
                        bundle.putString("def","hard");
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }

                }


            }
        });




        //creating event handlers:-
        hardExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel();
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
