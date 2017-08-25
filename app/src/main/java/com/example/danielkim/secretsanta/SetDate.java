package com.example.danielkim.secretsanta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * Created by Daniel Kim on 8/23/2017.
 */

public class SetDate extends AppCompatActivity {
    protected ArrayList<String> namesList;
    protected ArrayList<Integer> numsList;
    protected String groupName;
    protected int maxSize;

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
        maxSize = namesList.size();

    }

    public void startBtnOnClick(View v) {
        // Get the chosen due date data
        DatePicker date = (DatePicker) findViewById(R.id.datePicker);
        String dueDate = getDate(date);

        Button srtBtn = (Button) findViewById(R.id.startButton);
        srtBtn.setText("Sending");

        // Determine the Secret Santas
        Random rand = new Random();
        ArrayList<int[]> resList;
        int [] results;
        int [] idx = new int[maxSize];
        for(int i = 0; i < maxSize; i++)
            idx[i] = i;

        resList = getDerangement(idx);
        results = resList.get(rand.nextInt(resList.size()));


        // TODO Send Out Text Messages




        srtBtn.setText("Sent!");

        // End and restart App
        Handler handler = new Handler();
        handler.postDelayed(
            new Runnable()  {
                public void run () {
                    Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        ,5000);
    }

    protected String getDate(DatePicker dtPck)  {
        int day = dtPck.getDayOfMonth();
        int month = dtPck.getMonth();
        int year = dtPck.getYear();

        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd yyyy");
        return dateFormat.format(cal.getTime());
    }

    protected ArrayList<int[]> getDerangement(int [] nums) {
        ArrayList<int[]> res = new ArrayList<int[]>();

        Map<Integer,Integer> idxMap = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++) {
            idxMap.put(i, nums[i]);
        }

        permute(nums, idxMap, 0, res);
        return res;
    }

    // Recursively Permute the the nums list
    protected void permute(int [] nums, Map<Integer,Integer> idxmap, int start, ArrayList<int[]> res) {
        if(start >= nums.length) {
            res.add(Arrays.copyOf(nums,nums.length));
            return;
        }

        for(int i = start; i < nums.length; i++) {
            if(idxmap.get(i) != nums[start]) {
                swap(nums, i, start);
                permute(nums, idxmap, start+1, res);
                swap(nums, i, start);
            }
        }
    }

    // Swap Method
    protected void swap(int[] nums, int i, int j) {
        Integer temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
