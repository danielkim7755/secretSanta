package com.example.danielkim.secretsanta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Kim on 8/18/2017.
 */

public class name_nums extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.name_nums);

        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);


        // Grab Data from first Activity
        Intent i = getIntent();
        String GName = i.getStringExtra("GName");
        int totalNum = i.getIntExtra("numPeople",0);

        // Dynamically set edit texts
        List<String> Names = new ArrayList<String>();

        for (int j = 0; j < totalNum; j++)  {
            LinearLayout editTextLayout = new LinearLayout(this);
            editTextLayout.setOrientation(LinearLayout.VERTICAL);
            mainLayout.addView(editTextLayout);

            EditText nameText = new EditText(this);
            nameText.setId(j);
            editTextLayout.addView(nameText);

            EditText areaCodeText = new EditText(this);
            areaCodeText.setId(j);
            editTextLayout.addView(areaCodeText);
        }


        setContentView(mainLayout);


    }
}
