package com.example.filipino_slang;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static String whatMode;
    Button btnPlayGame;
    RadioGroup rdGrpSelection;
    RadioButton rdBtnSelectedMode, rdBtnEasyMode, rdBtnNormalMode, rdBtnHardMode;
    ToggleButton tglBtnMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declaration of Music Toggle Button
        tglBtnMusic = findViewById(R.id.tglBtnMusic);

        // Declaration of Play Game Button
        btnPlayGame = findViewById(R.id.btnPlayGame);

        // Declaration of Radio Group Level Selections
        rdGrpSelection = findViewById(R.id.levelSelection);

        // Declaration of Game Mode Radio Buttons
        rdBtnEasyMode= findViewById(R.id.easySelection);
        rdBtnNormalMode= findViewById(R.id.normalSelection);
        rdBtnHardMode= findViewById(R.id.hardSelection);

        // Clicking Buttons
        btnPlayGame.setOnClickListener(this);
        tglBtnMusic.setOnClickListener(this);
        rdBtnEasyMode.setOnClickListener(this);
        rdBtnNormalMode.setOnClickListener(this);
        rdBtnHardMode.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tglBtnMusic:
                if (tglBtnMusic.isChecked()){
                    Toast.makeText(this, "Music : Off", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Music : On", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnPlayGame:
                openGameScreen();
                break;
            case R.id.easySelection:
            case R.id.normalSelection:
            case R.id.hardSelection:
                rdBtnSelectedMode = findViewById(rdGrpSelection.getCheckedRadioButtonId());
                Toast.makeText(this, "Difficulty : " + rdBtnSelectedMode.getText(), Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }


    @Override
    public void onBackPressed() {
        openExitPrompt();
    }

    // For opening the Exit Prompt
    public void openExitPrompt(){
        Intent exitGame = new Intent(this, ExitPrompt.class);
        startActivity(exitGame);
    }


    // For opening the Game Screen
    public void openGameScreen(){
        // Declaration of Opening the Game Screen
        Intent playGame = new Intent(this, GameScreen.class);

        // Declaration of Radio Button
        rdBtnSelectedMode = findViewById(rdGrpSelection.getCheckedRadioButtonId());

        // What mode are you in.
        String gameMode =  String.format("%s", rdBtnSelectedMode.getText());

        playGame.putExtra(whatMode, gameMode);
        startActivity(playGame);
    }
}