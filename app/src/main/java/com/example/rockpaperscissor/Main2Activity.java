package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    Button btn_singlePlayer, btn_twoPlayers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_singlePlayer = (Button)findViewById(R.id.btn_singlePlayer);
        btn_twoPlayers = (Button)findViewById(R.id.btn_twoPlayer);
        btn_singlePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent singlePlayerMood = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(singlePlayerMood);
            }
        });

        btn_twoPlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent twoPlayerMood = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(twoPlayerMood);
            }
        });
    }
}
