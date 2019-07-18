package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main3Activity extends AppCompatActivity {

    private TextView p1Score_tv, p2Score_tv, playerStatus;
    private Button rock_btn, paper_btn, scissors_btn;
    private int p1Score = 0, p2Score = 0;
    private int count = 0;
    private String savedChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        p1Score_tv = (TextView)findViewById(R.id.player_one_score);
        p2Score_tv = (TextView)findViewById(R.id.player_two_score);
        rock_btn = (Button) findViewById(R.id.rock2_btn);
        paper_btn = (Button)findViewById(R.id.paper2_btn);
        scissors_btn = (Button) findViewById(R.id.scissors2_btn);
        playerStatus = (TextView)findViewById(R.id.player_status);

        rock_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;

                if(count % 2 == 0) {
                    play("rock", savedChoice);
                }
                else{
                    savedChoice = "rock";
                    playerStatus.setText("Player - 2");

                }
            }
        });

        paper_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count++;
                if(count % 2 == 0) {
                    play("paper", savedChoice);
                }
                else{
                    savedChoice = "paper";
                    playerStatus.setText("Player - 2");
                }
            }
        });

        scissors_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                if(count % 2 == 0) {
                    play("scissor", savedChoice);
                }
                else{
                    savedChoice = "scissor";
                    playerStatus.setText("Player - 2");
                }
            }
        });
    }
    public void play(String userInput2, String userInput1){
        result(userInput1, userInput2);
    }

    private void result(String userInput, String computer_choice) {

        if(userInput == computer_choice){
            Toast.makeText(this, "It's a Draw", Toast.LENGTH_SHORT).show();
            playerStatus.setText("Player - 1");
        }

        else if(userInput == "rock" && computer_choice == "paper" || userInput == "scissor" && computer_choice == "rock" || userInput == "paper" && computer_choice == "scissor"){
            Toast.makeText(this, "Player 2 Wins", Toast.LENGTH_SHORT).show();
            p2Score++;
            p2Score_tv.setText("Player 2 scored : " + Integer.toString(p2Score));
            if(p2Score == 5){
                Main4Activity dialog = new Main4Activity();
                dialog.show(getSupportFragmentManager(), "Player - 2");
            }
            else {

                playerStatus.setText("Player - 1");
            }
        }

        else{
            Toast.makeText(this, "Player 1 Wins", Toast.LENGTH_SHORT).show();
           p1Score++;
            p1Score_tv.setText("Player 1 scored : " + Integer.toString(p1Score));
           if(p1Score == 5){
               Main4Activity dialog = new Main4Activity();
               dialog.show(getSupportFragmentManager(), "Player - 1");
           }
           else {
               playerStatus.setText("Player - 1");
           }
        }
    }
}
