package com.example.filipino_slang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExitPrompt extends AppCompatActivity {

    Button btnExitGame;
    Button btnReturnGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit_prompt);

        // Declaration for Exit button
        btnExitGame = (Button) findViewById(R.id.btnExitGame);

        //Declaration for Return button
        btnReturnGame = (Button) findViewById(R.id.btnReturnGame);

        btnExitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        btnReturnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenuScreen();
            }
        });
    }

    // for opening Menu Screen
    public void openMenuScreen(){
        Intent returnGame = new Intent(this, MainActivity.class);
        startActivity(returnGame);
    }
}