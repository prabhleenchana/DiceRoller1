package com.example.diceroller;

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

    public void dicebreakers(View view) {
        TextView Questions = this.findViewById(R.id.displayCongrats);

        switch (number) {
            case 1:
                Questions.setText("If you could go anywhere in the world, where would you go?");
                break;
            case 2:
                Questions.setText("If you were stranded on a desert island, what three things would you want to take with you?");
                break;
            case 3:
                Questions.setText("If you could eat only one food for the rest of your life, what would that be?");
                break;
            case 4:
                Questions.setText("If you won a million dollars, what is the first thing you would buy?");
                break;
            case 5:
                Questions.setText("If you could spend the day with one fictional character, who would it be?");
                break;
            case 6:
                Questions.setText("If you found a magic lantern and a genie gave you three wishes, what would you wish?");
                break;


        }

    }
    public int roll_the_dice() {
        Random r = new Random();
        int number = r.nextInt(6) + 1;

        return number;
    }

}
