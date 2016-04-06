package com.example.android.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String option = extras.getString("option");
            ImageView infoImage = (ImageView) findViewById(R.id.infoImage);
            infoImage.setImageResource(getResources().getIdentifier(option, "drawable", getPackageName()));
        }
    }

    public void backToList(View v) {
        Intent myIntent = new Intent(InformationActivity.this, MainActivity.class);
        InformationActivity.this.startActivity(myIntent);
    }
}
