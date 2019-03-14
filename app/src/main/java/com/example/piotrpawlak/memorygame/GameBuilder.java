package com.example.piotrpawlak.memorygame;

import android.widget.TextView;

public class GameBuilder {

    int level, mode;
    TextView p1_txt, p2_txt;

    public GameBuilder(int mode, Player p1){
        this.mode = mode;

        p1 = new Player(p1_txt);
    }

    public GameBuilder(int mode, Player p1, Player p2){
        this.mode = mode;

        p1 = new Player(p1_txt);
        p2 = new Player(p2_txt);
    }

    public int getPlayerPoints(Player p) {
        return p.getPoints();
    }

}
