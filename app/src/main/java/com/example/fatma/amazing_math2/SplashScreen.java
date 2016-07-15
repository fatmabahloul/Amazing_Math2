package com.example.fatma.amazing_math2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread timerThread = new Thread(){
            public void run(){
                try{

                    ImageView splashIcon = (ImageView) findViewById(R.id.imageView);
                    Animation a = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.custom_anim);
                    //   a.setDuration(3000);
                    splashIcon.startAnimation(a);
                    sleep(4000);

                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }
}
