package com.terrytsai.caloriecalculator;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Calories currentCal = new Calories(0);
        final List<Exercise> image_details = getExerciseData();
        final GridView gridView = (GridView) findViewById(R.id.gridView);
        final CustomGridAdapterExercise gridAdapter = new CustomGridAdapterExercise(this, image_details, currentCal);
        gridView.setAdapter(gridAdapter);

        final EditText edit = (EditText) findViewById(R.id.editText);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // When the user clicks on the GridItem
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = gridView.getItemAtPosition(position);
                Exercise exercise = (Exercise) o;
                Toast.makeText(MainActivity.this, "Selected :"
                        + " " + exercise, Toast.LENGTH_LONG).show();
            }
        });

        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                currentCal.setCalories(edit.getText().toString());
                gridAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainScreen.class);
        startActivityForResult(myIntent, 0);
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    private List<Exercise> getExerciseData() {
        List<Exercise> list = new ArrayList<Exercise>();
        Exercise pushups = new Exercise("Pushups", "pu", "reps", 3.5);
        Exercise situps = new Exercise("Situps", "su", "reps", 2);
        Exercise squats = new Exercise("Squats", "sq", "reps", 2.25);
        Exercise leglift = new Exercise("Leg-lift", "lg", "minutes", 0.25);
        Exercise plank = new Exercise("Plank", "pl", "minutes", 0.25);
        Exercise jjacks = new Exercise("Jumping Jacks", "jj", "minutes", 0.1);
        Exercise pullup = new Exercise("Pullups", "pull", "reps", 1);
        Exercise cycling = new Exercise("Cycling", "cy", "minutes", 0.12);
        Exercise walking = new Exercise("Walking", "wa", "minutes", 0.2);
        Exercise jogging = new Exercise("Jogging", "jog", "minutes", 0.12);
        Exercise swimming = new Exercise("Swimming", "sw", "minutes", 0.13);
        Exercise stairs = new Exercise("Stair-climbing", "st", "minutes", 0.15);

        list.add(pushups);
        list.add(situps);
        list.add(squats);
        list.add(leglift);
        list.add(plank);
        list.add(jjacks);
        list.add(pullup);
        list.add(cycling);
        list.add(walking);
        list.add(jogging);
        list.add(swimming);
        list.add(stairs);

        return list;
    }
}
