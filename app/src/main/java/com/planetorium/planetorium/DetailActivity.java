package com.planetorium.planetorium;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    TextView tvDetails,tvheader;
    TextView tvfact1,tvfact2,tvfact3,tvfact4,tvfact5,tvfact6,tvfact7;
    ImageView imga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide();
        imga = (ImageView)findViewById(R.id.imagelogo) ;
        tvheader  = (TextView)findViewById(R.id.tv_planetoriumz);
        Typeface qwe = Typeface.createFromAsset(getAssets(),"fonts/Mayan.ttf");
        tvheader.setTypeface(qwe);

        tvDetails = (TextView)findViewById(R.id.tv_Descript);
        tvfact1 = (TextView)findViewById(R.id.tv_fact1);
        tvfact2 = (TextView)findViewById(R.id.tv_fact2);
        tvfact3 = (TextView)findViewById(R.id.tv_fact3);
        tvfact4 = (TextView)findViewById(R.id.tv_fact4);
        tvfact5 = (TextView)findViewById(R.id.tv_fact5);
        tvfact6 = (TextView)findViewById(R.id.tv_fact6);
        tvfact7 = (TextView)findViewById(R.id.tv_fact7);



        Typeface qwes = Typeface.createFromAsset(getAssets(),"fonts/typewriter.ttf");
        tvDetails.setTypeface(qwes);
        Intent intent = getIntent();
        String details = intent.getStringExtra("desc");
        tvDetails.setText(details);

        String factz1 = intent.getStringExtra("fact1");
        tvfact1.setText(factz1);
        Typeface fa1 = Typeface.createFromAsset(getAssets(),"fonts/typewriter.ttf");
        tvfact1.setTypeface(fa1);

        String factz2 = intent.getStringExtra("fact2");
        tvfact2.setText(factz2);
        Typeface fa2 = Typeface.createFromAsset(getAssets(),"fonts/typewriter.ttf");
        tvfact2.setTypeface(fa2);

        String factz3 = intent.getStringExtra("fact3");
        tvfact3.setText(factz3);
        Typeface fa3 = Typeface.createFromAsset(getAssets(),"fonts/typewriter.ttf");
        tvfact3.setTypeface(fa3);

        String factz4 = intent.getStringExtra("fact4");
        tvfact4.setText(factz4);
        Typeface fa4 = Typeface.createFromAsset(getAssets(),"fonts/typewriter.ttf");
        tvfact4.setTypeface(fa4);

        String factz5 = intent.getStringExtra("fact5");
        tvfact5.setText(factz5);
        Typeface fa5 = Typeface.createFromAsset(getAssets(),"fonts/typewriter.ttf");
        tvfact5.setTypeface(fa5);

        String tvfactz6 = intent.getStringExtra("fact6");
        tvfact6.setText(tvfactz6);
        Typeface fa6 = Typeface.createFromAsset(getAssets(),"fonts/typewriter.ttf");
        tvfact6.setTypeface(fa6);

        String tvfactz7 = intent.getStringExtra("fact7");
        tvfact7.setText(tvfactz7);
        Typeface fa7 = Typeface.createFromAsset(getAssets(),"fonts/typewriter.ttf");
        tvfact7.setTypeface(fa7);

        String image = intent.getStringExtra("image");
        Picasso.get().load(image)
                .into(imga);



    }
}
