package com.example.danielkim.secretsanta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;



/**
 * Created by Daniel Kim on 8/23/2017.
 */

public class SetDate extends AppCompatActivity {
    protected ArrayList<String> namesList;
    protected ArrayList<Integer> numsList;
    protected String groupName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_date);

        // Back Button Setup
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Retrieve Data from last activity
        Intent intent = getIntent();
        namesList = intent.getStringArrayListExtra("NameList");
        numsList = intent.getIntegerArrayListExtra("NumberList");
        groupName = intent.getStringExtra("Gname");

    }

    public void startBtnOnClick(View v) {
        // Get the chosen due date data
        DatePicker date = (DatePicker) findViewById(R.id.datePicker);
        String dueDate = getDate(date);


    }

    protected String getDate(DatePicker dtPck)  {
        int day = dtPck.getDayOfMonth();
        int month = dtPck.getMonth();
        int year = dtPck.getYear();

        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.format(cal.getTime());
    }
}
