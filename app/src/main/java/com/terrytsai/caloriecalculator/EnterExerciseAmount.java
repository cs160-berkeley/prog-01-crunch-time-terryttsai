package com.terrytsai.caloriecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Terry T. Tsai on 1/31/2016.
 */
public class EnterExerciseAmount extends AppCompatActivity {

    Button button;
    TextView howMany;
    TextView repsMins;
    String exerciseName;
    String exerciseType;
    double conversionRate;
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_exercise_amount);

        Bundle extras = getIntent().getExtras();

        howMany = (TextView) findViewById(R.id.how_many_exercise);
        repsMins = (TextView) findViewById(R.id.reps_minutes);
        edit = (EditText) findViewById(R.id.amount_exercise);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(edit, InputMethodManager.SHOW_IMPLICIT);
        edit.requestFocus();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (extras != null) {
            exerciseName = extras.getString("exerciseName");
            exerciseType = extras.getString("exerciseType");
            conversionRate = extras.getDouble("conversionRate");
            howMany.setText("Enter amount of " + exerciseName + ":");
            if (exerciseType.equals("reps")) {
                repsMins.setText("reps");
            } else {
                repsMins.setText("minutes");
            }
            Log.d("Getting Intent", exerciseName);
        }

        addListenerOnButton();
    }

    public double getEditDouble() {
        double result;
        try {
            result = Double.parseDouble(edit.getText().toString());
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }

    public void addListenerOnButton() {
        final Context context = this;

        button = (Button) findViewById(R.id.button_go);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edit.getText().toString().matches("")){
                    Toast.makeText(EnterExerciseAmount.this, "You did not enter a number", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(context, ExerciseResult.class);

                    intent.putExtra("amountExercise", getEditDouble());
                    intent.putExtra("exerciseName", exerciseName);
                    intent.putExtra("exerciseType", exerciseType);
                    intent.putExtra("conversionRate", conversionRate);
                    Log.d("Get Input", edit.getText().toString());
                    startActivity(intent);
                    overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), SelectExercise.class);
        startActivityForResult(myIntent, 0);
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}