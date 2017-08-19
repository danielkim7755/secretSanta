package com.example.danielkim.secretsanta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Daniel Kim on 8/18/2017.
 */

public class name_nums extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_nums);

        // Grab Data from first Activity
        Intent i = getIntent();
        String GName = i.getStringExtra("GName");
        int totalNum = i.getIntExtra("numPeople",0);

    }
}
