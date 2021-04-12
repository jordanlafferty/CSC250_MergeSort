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
    private int factorialIter(int n)
    {
        int runningTotal = n;
        for (int i =n-1; i>0; i--)
        {
            runningTotal *= i;
        }
        return runningTotal;
    }

    private int factorialRec(int n)
    {
        // also can be written as if (n== 1) return 1;
        if (n== 1)
        {
            return 1;
        }
        return n* factorialRec(n-1);
    }

    private int factorialRec2(int n)
    {
        //shorter way to solve
        // Inline if statement
        //boolean_exp?true_exp;false_exp;
        return n==1?1:n* factorialRec(n-1);
    }


    public void onFactorialButtonClicked(View v)
    {
        String currValue = this.inputET.getText().toString();
        this.answerTV.setText(currValue);
        int currValueasInt = Integer.parseInt(currValue);
        this.answerTV.setText(""+this.factorialIter(currValueasInt));

        //how I solved it
        /*int factorial = Integer.parseInt(currValue);
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
        }*/

    }

}