package com.example.danielkim.secretsanta;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

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
        final String GName = i.getStringExtra("GName");
        final int totalNum = i.getIntExtra("numPeople",0);

        // Dynamically set edit texts
        String nameHint = "Name";
        String numHint = "Phone Number";
        final List<EditText> names = new ArrayList<EditText>();
        final List<EditText> numbers = new ArrayList<EditText>();

        for (int j = 0; j < totalNum; j++)  {
            LinearLayout editTextLayout = new LinearLayout(this);
            editTextLayout.setOrientation(LinearLayout.HORIZONTAL);
            mainLayout.addView(editTextLayout);

            // Name Edit Text
            EditText nameText = new EditText(this);
            nameText.setHint(nameHint);
            nameText.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            nameText.setEms(10);
            editTextLayout.addView(nameText);

            // Number Edit Text
            EditText numText = new EditText(this);
            numText.setHint(numHint);
            numText.setEms(7);
            numText.setInputType(InputType.TYPE_CLASS_NUMBER);
            editTextLayout.addView(numText);

            names.add(nameText);
            numbers.add(numText);
        }

        // Start Button Setup
        Button nextButton = new Button(this);
        nextButton.setBackgroundColor(Color.GREEN);
        nextButton.setText("Next");
        nextButton.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        nextButton.setTextColor(Color.WHITE);

        // Add Button to Main Layout
        mainLayout.addView(nextButton);

        setContentView(scroll);


        // Next Button OnClick Setup
        nextButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v)  {
                        Intent intent = new Intent(name_nums.this, SetDate.class);
                        ArrayList<String> namesList = new ArrayList<String>();
                        ArrayList<Integer> numsList = new ArrayList<Integer>();

                        // Put all input into a list
                        for (int j = 0; j < totalNum; j++) {
                            namesList.add(names.get(j).getText().toString());
                            numsList.add(Integer.getInteger(numbers.get(j).getText().toString()));
                        }

                        // Pass data to next Activity
                        intent.putStringArrayListExtra("NameList", namesList);
                        intent.putIntegerArrayListExtra("NumberList",numsList);
                        intent.putExtra("GName",GName);

                        startActivity(intent);
                    }
                }
        );


    }
}
