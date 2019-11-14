package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.String.valueOf;

public class DicebreakerQuestions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicebreaker_questions);

    }

    public void goBack(View view) { // allows button to go back from new DB question page --> back to diceroller page
        startActivity(new Intent(DicebreakerQuestions.this, MainActivity.class ));

    }

    public void saveQ (View view) {

        EditText newQuestion = (EditText)findViewById(R.id.newQ);

        EditText questionNumber = (EditText)findViewById(R.id.qNum);
        int number = Integer.valueOf(questionNumber.getText().toString());

        switch (number) {
            case 1:
                MainActivity.Q1 = newQuestion.getText().toString();
                break;
            case 2:
                MainActivity.Q2 = newQuestion.getText().toString();
                break;
            case 3:
                MainActivity.Q3 = newQuestion.getText().toString();
                break;
            case 4:
                MainActivity.Q4 = newQuestion.getText().toString();
                break;
            case 5:
                MainActivity.Q5 = newQuestion.getText().toString();
                break;
            case 6:
                MainActivity.Q6 = newQuestion.getText().toString();
                break;

            default:
                Toast.makeText(getApplicationContext(),"Please select valid numbers between 1-6",Toast.LENGTH_SHORT).show();

        }
        startActivity(new Intent(DicebreakerQuestions.this, MainActivity.class ));

    }
}