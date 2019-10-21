package com.example.diceroller;

import android.annotation.SuppressLint;
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

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int score = 0;



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

    @SuppressLint("SetTextI18n")


    public void button_click(View view) {
        TextView tv = this.findViewById(R.id.guess);
        TextView congrats = this.findViewById(R.id.displayCongrats);
        TextView points = this.findViewById(R.id.userPoints);
        EditText userInput = this.findViewById(R.id.enterNumber);
        String x = "";

        congrats.setText("Enter a number below:");



        Random r = new Random();
        int number = r.nextInt(6) + 1;

        try {
            tv.setText(Integer.toString(number));
         //   userInput = findViewById(R.id.enterNumber);

            x = userInput.getText().toString();
        } catch (Exception ex) {
            tv.setText(ex.toString());
        }

        if (!(x.matches("[1-6]"))) {
        congrats.setText("Please select valid numbers between 1-6");
        }
        else {
                if (number == Integer.valueOf(x)) {
                points.setText("Points: " + (++score));
                congrats.setText("Congratulations !");
            }
        }

    }

//    public void enter_Number(View view){
//
//        if (enterNumber == numberTextView);
//            {
//                displayCongrats;
//            }
//
//    }
}
