package com.example.filipino_slang;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button btnPlayGame;
    RadioGroup rdGrpSelection;
    RadioButton rdBtnSelectedMode;
    public TextView txtGameMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    public void onCustomToggleClick(View view) {
        Toast.makeText(this, "CustomToggle", Toast.LENGTH_SHORT).show();
    }

    // For the Selection Modes (Toast)
    public void checkedGameMode(View view) {
        rdBtnSelectedMode = (RadioButton) findViewById(rdGrpSelection.getCheckedRadioButtonId());
        Toast.makeText(this, "Selected Mode: " + rdBtnSelectedMode.getText(), Toast.LENGTH_SHORT).show();
    }

    // For opening the Game Screen
    public void openGameScreen(){
        Intent playGame = new Intent(this, GameScreen.class);
        startActivity(playGame);

        // TODO Changing of text view in GameScreen
        // Declaration of Radio Button
        rdBtnSelectedMode = (RadioButton) findViewById(rdGrpSelection.getCheckedRadioButtonId());
        // Declaration of Text View Mode in Game Screen
        txtGameMode = findViewById(R.id.txtGameMode);
        // What mode are you in.
        txtGameMode.setText(String.format("You are in %s.", rdBtnSelectedMode.getText()));

    }
}