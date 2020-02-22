package com.example.rpsyoutube;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Button rock, paper, scissors;
    TextView tv_score;
    int pCounter, cCounter;



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

        rock = (Button) findViewById(R.id.rock);
        paper = (Button) findViewById(R.id.paper);
        scissors = (Button) findViewById(R.id.scissors);

        tv_score = (TextView) findViewById(R.id.tv_score);


        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = playTurn("Rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Player: " + Integer.toString(pCounter) + " Computer: " + Integer.toString(cCounter));

            }

        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = playTurn("Paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Player: " + Integer.toString(pCounter) + "Computer: " + Integer.toString(cCounter));

            }
        });

        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = playTurn("Scissors");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Player: " + Integer.toString(pCounter) + "Computer: " + Integer.toString(cCounter));

            }
        });
    }

    public String playTurn(String player_choice) {

        String computer_choice = "";
        Random r = new Random();
        int computer_choice_number = r.nextInt(2);

        if (computer_choice_number == 0) {
            computer_choice = "Rock";
        } else if (computer_choice_number == 1) {
            computer_choice = "Paper";
        } else if (computer_choice_number == 2) {
            computer_choice = "Scissors ";
        }

        if (computer_choice == player_choice) {
            return "Draw.";
        } else if (player_choice == "Rock" && computer_choice == "Scissors") {
            pCounter++;
            return "Rock beats paper!";
        } else if (player_choice == "Paper" && computer_choice == "Rock") {
            pCounter++;
            return "Paper beats rock!";
        } else if (player_choice == "Scissors" && computer_choice == "Paper") {
            pCounter++;
            return "Scissors beats paper!";
        } else if (computer_choice == "Rock" && player_choice == "Scissors") {
            cCounter++;
            return "Rock beats paper!";
        } else if (computer_choice == "Paper" && player_choice == "Rock") {
            cCounter++;
            return "Rock beats paper!";
        } else if (computer_choice == "Scissors" && player_choice == "Paper") {
            cCounter++;
            return "Rock beats paper!";
        } else return "Uhhhh Somethings Wrong!!";

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

}
