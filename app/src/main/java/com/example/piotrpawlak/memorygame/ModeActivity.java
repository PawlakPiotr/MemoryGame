package com.example.piotrpawlak.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModeActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_onePlayer, btn_twoPlayers;
    String mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        setComponents();
    }

    private void setComponents() {
        btn_onePlayer = findViewById(R.id.btn_1p);
        btn_twoPlayers = findViewById(R.id.btn_2p);

        btn_onePlayer.setOnClickListener(this);
        btn_twoPlayers.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_1p:
                openLevels("1");
                break;
            case R.id.btn_2p:
                openLevels("2");
                break;
            default:
                break;
        }
    }

    private void openLevels(String mode) {
        Intent levels = new Intent(this, LevelsActivity.class);
        levels.putExtra("mode", mode);
        startActivity(levels);
    }
}
