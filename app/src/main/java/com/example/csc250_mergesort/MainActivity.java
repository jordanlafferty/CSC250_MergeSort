package com.example.csc250_mergesort;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    private EditText inputET;
    private TextView answerTV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.inputET = this.findViewById(R.id.inputET);
        this.answerTV = this.findViewById(R.id.answerTV);
    }

    public void onFactorialButtonClicked(View v)
    {
        String currValue = this.inputET.getText().toString();
        this.answerTV.setText(currValue);
        int factorial = Integer.parseInt(currValue);
        int total = Integer.parseInt(currValue);
        int num = Integer.parseInt(currValue);

        for (int i = 0; i < num; i++)
        {
            if (factorial <=1)
            {
                this.answerTV.setText(""+total);

            }
            else
            {
                total = total * (factorial-1);
                factorial--;
            }
        }

    }

}