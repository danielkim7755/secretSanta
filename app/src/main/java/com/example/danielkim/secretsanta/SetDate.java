package com.example.danielkim.secretsanta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by Daniel Kim on 8/23/2017.
 */

public class SetDate extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_date);

        // Back Button Setup
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Retreive Data from last activity
        Intent intent = getIntent();
        ArrayList<String> namesList = intent.getStringArrayListExtra("NameList");
        ArrayList<Integer> numsList = intent.getIntegerArrayListExtra("NumberList");
        String groupName = intent.getStringExtra("Gname");

    }
}
