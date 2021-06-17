package com.example.filipino_slang;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {

    TextView txtGameMode;
    Button btnBack;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        // Getting the method in the Main Activity
        Intent playGame = getIntent();
        String gameMode = playGame.getStringExtra(MainActivity.whatMode);

        // Declaration of Game Mode Text View
        txtGameMode = findViewById(R.id.txtGameMode);
        txtGameMode.setText(gameMode);

        btnBack = (Button) findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenuScreen();
            }
        });
    }

    public void openMenuScreen(){
        Intent returnMenuScreen = new Intent(this, MainActivity.class);
        startActivity(returnMenuScreen);
    }
}