package com.example.csc250_mergesort;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
   private ListView listOfNumbersLV;
    private ArrayList<String> theListOfNumbersAsStrings;
    private ArrayAdapter<String> theListOfNumbersAdapter;

    private ListView theCallsToMergeSortLV;
    private ArrayList<String> theListOfMergeSortCalls;
    private ArrayAdapter<String> theCallsToMergeSortAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // this.inputET = this.findViewById(R.id.inputET);
       // this.answerTV = this.findViewById(R.id.answerTV);
        this.listOfNumbersLV = this.findViewById(R.id.listOfNumbersLV);

        //this guy will show the parts of the arraylist we are working on in mergesort
        this.theListOfMergeSortCalls = new ArrayList<String>();
        this.theCallsToMergeSortAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                this.theListOfMergeSortCalls);
        this.theCallsToMergeSortLV = this.findViewById(R.id.theCallsToMergeSortLV);
        this.theCallsToMergeSortLV.setAdapter(this.theCallsToMergeSortAdapter);


        this.theListOfNumbersAsStrings = new ArrayList<String>();
        this.theListOfNumbersAsStrings.add("5");
        this.theListOfNumbersAsStrings.add("2");
        this.theListOfNumbersAsStrings.add("8");
        this.theListOfNumbersAsStrings.add("3");
        this.theListOfNumbersAsStrings.add("13");
        this.theListOfNumbersAsStrings.add("5");
        this.theListOfNumbersAsStrings.add("5");
        this.theListOfNumbersAsStrings.add("8");
        this.theListOfNumbersAsStrings.add("1");

        this.theListOfNumbersAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                this.theListOfNumbersAsStrings);

        this.listOfNumbersLV.setAdapter(theListOfNumbersAdapter);
    }

    public String buildStringFromPartOfList(ArrayList<String> theList, int begin, int end )
    {
        String s = "";
        for (int i= begin; i<=end; i++)
        {
            s = s + theList.get(i)+ " ";
        }
        return s;
    }

    public String merge(ArrayList<String> theList, int begin, int end)
    {
        String s = "";
        for (int i= begin; i<=end; i++)
        {
            s = s + theList.get(i)+ " ";
        }
        return s;
    }

    private void mergeSort(ArrayList<String> theList, int begin, int end)
    {
        //ask if this list is trivial sorted
        //I only want to do anything inside MergeSort if it is not trivially sorted
        String currentPartOfArray = this.buildStringFromPartOfList((theList), begin, end);
        this.theListOfMergeSortCalls.add(currentPartOfArray);
        this.theCallsToMergeSortAdapter.notifyDataSetChanged();




        if (begin != end)
        {
            //I don't have a 1-list, so I need to divide my list in half & call mergesort
            //call mergeSort on left and right side

            if (end>=1)
            {
                int middle = (begin+end)/2;
                mergeSort(theList, begin,middle);
                mergeSort(theList, middle+1, end);
                merge(theList, begin,end);
            }


        }

    }

    public void onMergeSortButtonClicked (View v)
    {
        // letting the adapter know the data set has changed
        this.mergeSort(this.theListOfNumbersAsStrings,
                0, this.theListOfNumbersAsStrings.size()-1);

    }



    // for factorial program
    /*private int factorialIter(int n)
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
        }*/



}