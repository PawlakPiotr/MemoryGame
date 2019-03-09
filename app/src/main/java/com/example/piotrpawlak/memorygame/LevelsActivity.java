package com.example.piotrpawlak.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelsActivity extends AppCompatActivity implements View.OnClickListener {

    private final String intent_extra_level = "level";
    Button btn_4x4, btn_4x5, btn_4x6;
    int[] values = {16, 20, 24};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        setComponents();
    }

    private void setComponents() {
        btn_4x4 = findViewById(R.id.btn_4x4);
        btn_4x5 = findViewById(R.id.btn_4x5);
        btn_4x6 = findViewById(R.id.btn_4x6);

        btn_4x4.setOnClickListener(this);
        btn_4x5.setOnClickListener(this);
        btn_4x6.setOnClickListener(this);
    }


    private void startGame(Intent intent, String value) {

        intent.putExtra(intent_extra_level, value);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_4x4:
                startGame(new Intent(this, GameActivity.class), "16");
                break;
            case R.id.btn_4x5:
                startGame(new Intent(this, GameActivity.class), "20");
                break;
            case R.id.btn_4x6:
                startGame(new Intent(this, GameActivity.class), "24");
                break;
            default:
                break;
        }
    }
}
