package com.planetorium.planetorium;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class SplashScreen extends AppCompatActivity {
    ImageView imagesplash;
private String url = "http://bdfjade.com/data/out/134/6373149-solar-system-wallpaper.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash_screen);
        imagesplash = (ImageView)findViewById(R.id.splash_image);
        Picasso.get().load(url).into(imagesplash);

        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }
        }, secondsDelayed * 9000);
    }


}
