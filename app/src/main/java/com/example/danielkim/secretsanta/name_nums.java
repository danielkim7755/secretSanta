package com.example.danielkim.secretsanta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;


import java.util.ArrayList;
import java.util.List;

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

        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);


        // Grab Data from first Activity
        Intent i = getIntent();
        String GName = i.getStringExtra("GName");
        int totalNum = i.getIntExtra("numPeople",0);

        // Dynamically set edit texts
        List<String> NamesList = new ArrayList<String>();
        List<String> NumList = new ArrayList<String>();
        String nameHint = "Name";
        String numHint = "Number";


        for (int j = 0; j < totalNum; j++)  {
            LinearLayout editTextLayout = new LinearLayout(this);
            editTextLayout.setOrientation(LinearLayout.HORIZONTAL);
            mainLayout.addView(editTextLayout);

            EditText nameText = new EditText(this);

            nameText.setId(j);
            nameText.setHint(nameHint);
            nameText.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            nameText.setEms(30);
            editTextLayout.addView(nameText);

            EditText numText = new EditText(this);
            numText.setId(j);
            numText.setHint(numHint);
            editTextLayout.addView(numText);

        }


        setContentView(mainLayout);
    }





}
