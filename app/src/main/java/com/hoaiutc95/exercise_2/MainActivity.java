package com.hoaiutc95.exercise_2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner mSelectColor1, mSelectColor2;
    private TextView txtShowColor;
    private String []arr = {"Red", "Yellow", "Blue", "Green"};
    private Integer []color = {Color.RED,Color.YELLOW,Color.BLUE,Color.GREEN};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSelectColor1 = (Spinner) findViewById(R.id.sp_select_color_1);
        mSelectColor2 = (Spinner) findViewById(R.id.sp_select_color_2);
        txtShowColor = (TextView) findViewById(R.id.tvColor);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arr);
        mSelectColor2.setAdapter(arrayAdapter);
        mSelectColor1.setOnItemSelectedListener(new SpinnerSelectColor());
        mSelectColor2.setOnItemSelectedListener(new SpinnerSelectColor());
    }

    private class SpinnerSelectColor implements AdapterView.OnItemSelectedListener{
        private boolean kt = true;

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if(kt) {
                kt = false;
            } else {
                mSelectColor2.setPrompt(getResources().getString(R.string.spinner_prompt));
                txtShowColor.setBackgroundColor(color[position]);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            // Won’t be invoked unless you programmatically remove entries
        }
    }
}
