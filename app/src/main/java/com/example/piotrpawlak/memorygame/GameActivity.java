package com.example.piotrpawlak.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private final int default_level = 16;
    int Level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Level = getIntent().hasExtra("level") ? Integer.parseInt(getIntent().getStringExtra("level")) : default_level;

        // [dev-test]
        TextView test = findViewById(R.id.test);
        String s = String.valueOf(Level);
        test.setText(s);
    }
}
