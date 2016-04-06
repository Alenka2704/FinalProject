package com.example.android.finalproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String animals[] = {"cat", "dog", "frog", "crane", "mouse"};
        LinearLayout parentLayout = (LinearLayout) findViewById(R.id.parentLayout);
        LayoutInflater layoutInflater = (LayoutInflater)
                this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for (int i = 0; i < animals.length; i++) {

            LinearLayout itemLayout = (LinearLayout) layoutInflater.inflate(R.layout.content_layout, parentLayout, false);
            final int number=i;
            itemLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(MainActivity.this, InformationActivity.class);
                    myIntent.putExtra("option", animals[number]);
                    MainActivity.this.startActivity(myIntent);
                }
            });

            ImageView iv=(ImageView) itemLayout.findViewById(R.id.item_picture);
            iv.setImageResource(getResources().getIdentifier(animals[i] + "_res", "drawable", getPackageName()));

            TextView tv=(TextView)itemLayout.findViewById(R.id.item_name);
            tv.setText(animals[i]);

            parentLayout.addView(itemLayout, i);
        }
    }
}
