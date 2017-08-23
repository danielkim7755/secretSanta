package com.example.danielkim.secretsanta;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;


/**
 * Created by Daniel Kim on 8/18/2017.
 */

public class name_nums extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.name_nums);

        // Back Button Setup
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // LinearLayout that holds edit texts.
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        // Scroll Layout that holds the main linear layout.
        ScrollView scroll = new ScrollView(this);
        scroll.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        scroll.addView(mainLayout);

        //Instruction Edit Text
        EditText instText = new EditText(this);
        instText.setText("Enter names with their phone numbers", TextView.BufferType.NORMAL);
        instText.setFocusable(false);
        instText.setClickable(false);
        instText.setTextColor(Color.RED);
        instText.setBackgroundColor(Color.TRANSPARENT);
        instText.setGravity(Gravity.CENTER_HORIZONTAL);
        mainLayout.addView(instText);

        // Grab Data from first Activity
        Intent i = getIntent();
        String GName = i.getStringExtra("GName");
        int totalNum = i.getIntExtra("numPeople",0);

        // Dynamically set edit texts
        String nameHint = "Name";
        String numHint = "Phone Number";

        for (int j = 0; j < totalNum; j++)  {
            LinearLayout editTextLayout = new LinearLayout(this);
            editTextLayout.setOrientation(LinearLayout.HORIZONTAL);
            mainLayout.addView(editTextLayout);

            // Name Edit Text
            EditText nameText = new EditText(this);
            nameText.setId(j);
            nameText.setHint(nameHint);
            nameText.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            nameText.setEms(10);
            editTextLayout.addView(nameText);

            // Number Edit Text
            EditText numText = new EditText(this);
            numText.setId(j);
            numText.setHint(numHint);
            numText.setEms(7);
            editTextLayout.addView(numText);
        }

        // Start Button
        Button startButton = new Button(this);
        


        setContentView(scroll);
    }





}
