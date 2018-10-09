package com.planetorium.planetorium;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView tvDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide();
        tvDetails = (TextView)findViewById(R.id.tv_Descript);
        Intent intent = getIntent();
        String details = intent.getStringExtra("desc");
        tvDetails.setText(details);

    }
}
