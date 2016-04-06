package com.example.android.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] names = {"frog", "cat", "crane", "dog", "mouse"};
        LinearLayout parentLayout = (LinearLayout) findViewById(R.id.parentLayout);
        LinearLayout lLayout[] = new LinearLayout[names.length]; //list of items
        //special LinearLayout params
        LinearLayout.LayoutParams llparams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        llparams.height=0;
        llparams.weight=1;
        //params for LinearLayout children
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        for (int i = 0; i < lLayout.length; i++) {
            final int number = i;
            //list item
            lLayout[i] = new LinearLayout(this);
            lLayout[i].setId(i);
            lLayout[i].setLayoutParams(llparams);
            lLayout[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(MainActivity.this, InformationActivity.class);
                    myIntent.putExtra("option", names[number]);
                    MainActivity.this.startActivity(myIntent);
                }
            });

            //list item contents
            ImageView iv = new ImageView(this);
            iv.setLayoutParams(params);
            iv.setImageResource(getResources().getIdentifier(names[i] + "_res", "drawable", getPackageName()));
            iv.setMaxHeight(LinearLayout.LayoutParams.MATCH_PARENT);
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            lLayout[i].addView(iv);

            TextView tv = new TextView(this);
            tv.setLayoutParams(params);
            tv.setText(names[i]);
            tv.setAllCaps(true);
            tv.setTextSize(18);
            tv.setHeight(LinearLayout.LayoutParams.MATCH_PARENT);
            lLayout[i].addView(tv);

            parentLayout.addView(lLayout[i]);
        }
    }
}
