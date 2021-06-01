package com.example.filipino_slang;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {

    TextView txtGameMode;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        // Getting the method in the Main Activity
        Intent playGame = getIntent();
        String gameMode = playGame.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Declaration of Game Mode Text View
        txtGameMode = findViewById(R.id.txtGameMode);
        txtGameMode.setText(gameMode);
    }
}