package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView userScore_tv, computerScore_tv;
    private Button rock_btn, paper_btn, scissors_btn;
    private ImageView compterImage, userImage;
    private int computerScore = 0, userScore = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userScore_tv = (TextView)findViewById(R.id.userScore_tv);
        computerScore_tv = (TextView)findViewById(R.id.computerScore_tv);
        rock_btn = (Button) findViewById(R.id.rock_btn);
        paper_btn = (Button)findViewById(R.id.paper_btn);
        scissors_btn = (Button) findViewById(R.id.scissors_btn);
        compterImage = (ImageView)findViewById(R.id.computer_control_iv);
        userImage = (ImageView) findViewById(R.id.user_control_iv);

        rock_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userImage.setImageResource(R.drawable.rock);
                play("rock");
            }
        });

        paper_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userImage.setImageResource(R.drawable.paper);
                play("paper");
            }
        });

        scissors_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userImage.setImageResource(R.drawable.scissor);
                play("scissor");
            }
        });
    }


    public void play(String userInput){

        Random rand = new Random();
        int choice = rand.nextInt(3) + 1;
        String computer_choice;

        if(choice == 1){
            compterImage.setImageResource(R.drawable.rock);

            computer_choice = "rock";
        }
        else if(choice == 2){
            compterImage.setImageResource(R.drawable.paper);
            computer_choice = "paper";
        }

        else if(choice == 3){
            compterImage.setImageResource(R.drawable.scissor);
            computer_choice = "scissor";
        }
        else{
            computer_choice =  "no";
        }

        result(userInput, computer_choice);
    }

    private void result(String userInput, String computer_choice) {

        if(userInput == computer_choice){
            Toast.makeText(this, "It's a Draw", Toast.LENGTH_SHORT).show();
        }

        else if(userInput == "rock" && computer_choice == "paper" || userInput == "scissor" && computer_choice == "rock" || userInput == "paper" && computer_choice == "scissor"){
            Toast.makeText(this, "You Lose", Toast.LENGTH_SHORT).show();
            computerScore++;
            computerScore_tv.setText("Computer scored : " + Integer.toString(computerScore));
            if(computerScore == 5){
                Main4Activity dialog = new Main4Activity();
                dialog.show(getSupportFragmentManager(), "Player - 1");
            }
        }

        else{
            Toast.makeText(this, "You Win", Toast.LENGTH_SHORT).show();
            userScore++;
            userScore_tv.setText("You scored : " + Integer.toString(userScore));
            if(userScore == 5){
                Main4Activity dialog = new Main4Activity();
                dialog.show(getSupportFragmentManager(), "Player - 1");
            }
        }
    }
}
