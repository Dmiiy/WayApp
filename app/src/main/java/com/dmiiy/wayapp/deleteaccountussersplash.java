package com.dmiiy.wayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class deleteaccountussersplash extends AppCompatActivity {
    LottieAnimationView lottie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteaccountussersplash);
        lottie=(LottieAnimationView) findViewById(R.id.lottiedelete);
        //lottie.animate().translationY(-1200).setDuration(2000).setStartDelay(0);

        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(),MailLogin.class);
                startActivity(i);
                finish();
            }
        },5500);
    }
}