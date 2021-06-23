package com.example.filipino_slang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExitPrompt extends AppCompatActivity implements View.OnClickListener {

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

        // For Clicking Buttons
        btnExitGame.setOnClickListener(this);
        btnReturnGame.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnReturnGame:
                openMenuScreen();
                break;
            case R.id.btnExitGame:
                finishAffinity();
                break;
            default:
                break;
        }
    }

    // for opening Menu Screen
    public void openMenuScreen(){
        Intent returnMenuScreen = new Intent(this, MainActivity.class);
        startActivity(returnMenuScreen);
    }
}