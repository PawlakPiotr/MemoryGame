package com.example.piotrpawlak.memorygame;

import android.widget.TextView;

public class Player {

    int points;
    TextView p_txt_view;

    public Player(TextView tx) {
        points = 0;
        this.p_txt_view = tx;
    }

    public int addPoint() {
        return points++;
    }

    public int getPoints() {
        return points;
    }

    public void setText(String text) {
        this.p_txt_view.setText(text);
    }

    public String getText() {
        return p_txt_view.getText().toString();
    }
}
