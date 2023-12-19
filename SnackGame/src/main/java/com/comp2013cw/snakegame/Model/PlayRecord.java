package com.comp2013cw.snakegame.Model;

public class PlayRecord {

    private final String userName;
    private final int score;

    public String getUserName() {
        return userName;
    }

    public int getScore() {
        return score;
    }
    public PlayRecord(String userName, int score) {
        this.userName = userName;
        this.score = score;
    }
}
