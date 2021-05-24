package com.example.filipino_slang;

import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Toggle_Click(View view) {
    }

    public void onDefaultToggleClick(View view) {
        Toast.makeText( context: this, text: "DefaultToggle",Toast.LENGTH_SHORT).show();
    }
}