package com.example.filipino_slang;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ToggleButton;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    public static String EXTRA_MESSAGE;
    Button btnPlayGame;
    RadioGroup rdGrpSelection;
    RadioButton rdBtnSelectedMode;
    ToggleButton tglBtnMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declaration of Music Toggle Button
        tglBtnMusic = (ToggleButton) findViewById(R.id.tglBtnMusic);

        // Declaration of Play Game Button
        btnPlayGame = (Button) findViewById(R.id.btnPlayGame);

        // Declaration of Radio Group
        rdGrpSelection = (RadioGroup) findViewById(R.id.levelSelection);

        btnPlayGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Opens Game Screen
                openGameScreen();
            }
        });
    }

    // For Music On or Off (Toast)
    public void onMusicClick(View view) {
        if (tglBtnMusic.isChecked()){
            Toast.makeText(this, "Music : Off", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Music : On", Toast.LENGTH_SHORT).show();
        }
    }

    // For the Selection Modes (Toast)
    public void checkedGameMode(View view) {
        rdBtnSelectedMode = (RadioButton) findViewById(rdGrpSelection.getCheckedRadioButtonId());
        Toast.makeText(this, "Difficulty : " + rdBtnSelectedMode.getText(), Toast.LENGTH_SHORT).show();
    }

    // For opening the Game Screen
    public void openGameScreen(){
        // Declaration of Opening the Game Screen
        Intent playGame = new Intent(this, GameScreen.class);

        // Declaration of Radio Button
        rdBtnSelectedMode = (RadioButton) findViewById(rdGrpSelection.getCheckedRadioButtonId());

        // What mode are you in.
        String gameMode =  String.format("You are in %s.", rdBtnSelectedMode.getText());

        playGame.putExtra(EXTRA_MESSAGE, gameMode);
        startActivity(playGame);
    }
}