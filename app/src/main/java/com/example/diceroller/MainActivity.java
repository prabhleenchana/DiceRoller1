package com.example.diceroller;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // question variables
    static String Q1 = "If you could go anywhere in the world, where would you go?";
    static String Q2 = "If you were stranded on a desert island, what three things would you want to take with you?";
    static String Q3 = "If you could eat only one food for the rest of your life, what would that be?";
    static String Q4 = "If you won a million dollars, what is the first thing you would buy?";
    static String Q5 = "If you could spend the day with one fictional character, who would it be?";
    static String Q6 = "If you found a magic lantern and a genie gave you three wishes, what would you wish?";

    int score = 0;
    int number = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //  @SuppressLint("SetTextI18n")


    public void button_click(View view) {
        TextView rolledNum = this.findViewById(R.id.guess);
        TextView congrats = this.findViewById(R.id.displayCongrats);
        TextView points = this.findViewById(R.id.userPoints);
        EditText userInput = this.findViewById(R.id.enterNumber);
        String x = "";

        number = roll_the_dice();
        congrats.setText("Enter a number below:");

        try {
            rolledNum.setText(Integer.toString(number));

            x = userInput.getText().toString();
        } catch (Exception ex) {
            rolledNum.setText(ex.toString());
        }

        if (!(x.matches("[1-6]"))) {
            //congrats.setText("Please select valid numbers between 1-6");

            Toast.makeText(getApplicationContext(),"Please select valid numbers between 1-6",Toast.LENGTH_SHORT).show();

        }
        else {
            if (number == Integer.valueOf(x)) {
                points.setText("Points: " + (++score));
                congrats.setText("Congratulations !");
            }
        }



    }

    public void dicebreakers(View view) {   // switch statement for setting my questions - linked above
        TextView Questions = this.findViewById(R.id.displayCongrats);

        switch (number) {
            case 1:
                Questions.setText(Q1);
                break;
            case 2:
                Questions.setText(Q2);
                break;
            case 3:
                Questions.setText(Q3);
                break;
            case 4:
                Questions.setText(Q4);
                break;
            case 5:
                Questions.setText(Q5);
                break;
            case 6:
                Questions.setText(Q6);
                break;

        }

    }
    public int roll_the_dice() { // generates my random numbers for dice to roll
        Random r = new Random();
        int number = r.nextInt(6) + 1;

        return number;
    }

    public void addQuestion(View view) { // on click - connects button from diceroller page --> adding new dicebreaker question page
        startActivity(new Intent(MainActivity.this, DicebreakerQuestions.class));

    }
}

