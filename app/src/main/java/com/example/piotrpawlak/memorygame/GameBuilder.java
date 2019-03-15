package com.example.piotrpawlak.memorygame;

import android.widget.TextView;

public class GameBuilder {

    int level, mode, counter;
    TextView p1_txt, p2_txt;

    public GameBuilder(int mode, Player p1){
        this.mode = mode;
        counter = 0;
        p1 = new Player(p1_txt);
    }

    public GameBuilder(int mode, Player p1, Player p2){
        this.mode = mode;

        p1 = new Player(p1_txt);
        p2 = new Player(p2_txt);
    }

    public void countMove() {
        counter++;
    }

    public int getCounter() {
        return counter/2;
    }

    public int getPlayerPoints(Player p) {
        return p.getPoints();
    }

}
