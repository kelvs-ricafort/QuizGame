package com.newtechieblog.wordpress.views.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {
    ImageView imageView_splash;
    TextView titleView_splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageView_splash = findViewById(R.id.imageView_splash);
        titleView_splash = findViewById(R.id.textView_splash);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.splash_anim);
        titleView_splash.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}