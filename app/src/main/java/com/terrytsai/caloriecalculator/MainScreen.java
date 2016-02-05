package com.terrytsai.caloriecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Created by Terry T. Tsai on 1/31/2016.
 */
public class MainScreen extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        addListenerOnButton();
        addListenerOnButton2();
    }

    public void addListenerOnButton() {
        final Context context = this;

        button = (Button) findViewById(R.id.button_calc_exercise);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            }
        });
    }

    public void addListenerOnButton2() {
        final Context context = this;

        button = (Button) findViewById(R.id.button_calc_calories);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SelectExercise.class);
                startActivity(intent);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            }
        });
    }
}