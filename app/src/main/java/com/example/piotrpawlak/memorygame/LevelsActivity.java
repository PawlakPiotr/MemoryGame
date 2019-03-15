package com.example.piotrpawlak.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelsActivity extends AppCompatActivity implements View.OnClickListener {

    private String mode;
    private final String intent_extra_level = "level";
    Button btn_4x4, btn_4x5, btn_4x6;
    String[] values = {"16", "20", "24"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        mode = getIntent().getStringExtra("mode");

        setComponents();
    }

    private void setComponents() {
        btn_4x4 = findViewById(R.id.btn_4x4);
        btn_4x5 = findViewById(R.id.btn_4x5);
        btn_4x6 = findViewById(R.id.btn_4x6);

        setButtonsListeners(new Button[]{btn_4x4, btn_4x5, btn_4x6});
    }

    private void startGame(Intent intent, String value) {
        intent.putExtra(intent_extra_level, value);
        intent.putExtra("mode", mode);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_4x4:
                startGame(new Intent(this, GameActivity.class), values[0]);
                break;
            case R.id.btn_4x5:
                startGame(new Intent(this, GameActivity.class), values[1]);
                break;
            case R.id.btn_4x6:
                startGame(new Intent(this, GameActivity.class), values[2]);
                break;
            default:
                break;
        }
    }

    private void setButtonsListeners(Button[] arr) {
        for(Button btn : arr) {
            btn.setOnClickListener(this);
        }
    }
}
