package com.example.piotrpawlak.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    Button btn_play, btn_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final Intent levels_activity = new Intent(this, LevelsActivity.class);

        setComponents();
        levels(levels_activity);
        exit();
    }

    private void setComponents() {
        btn_exit = findViewById(R.id.btn_exit);
        btn_play = findViewById(R.id.btn_play);
    }

    private void levels(final Intent intent) {
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    private void exit() {
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }
}
