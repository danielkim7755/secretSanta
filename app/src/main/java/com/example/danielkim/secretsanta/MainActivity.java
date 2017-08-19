package com.example.danielkim.secretsanta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText groupName_input, num_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void OkBtnOnClick(View v) {
        // Create button and intent for connecting activities
        Button button = (Button) v;
        Intent i = new Intent(MainActivity.this,name_nums.class);

        // Grab the group name and number of people data
        groupName_input = (EditText) findViewById(R.id.GNameInput);
        num_input = (EditText) findViewById(R.id.numInput);

        String GName = groupName_input.getText().toString();
        String numPeople = num_input.getText().toString();
        int num = Integer.parseInt(numPeople);

        // Put data into the next activity
        i.putExtra("GName",GName);
        i.putExtra("numPeople", num);

        // Start the next activity
        startActivity(i);
    }


}
