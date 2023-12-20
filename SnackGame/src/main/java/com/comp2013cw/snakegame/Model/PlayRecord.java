package com.comp2013cw.snakegame.Model;

/**
 * Class to represent each play record, which contains
 * the username and the score.
 * @author Shuli WANG
 */

public class PlayRecord {

    private final String userName;
    private final int score;

    /**
     * get the username
     * @return username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * get the score
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * constructor
     * @param userName
     * @param score
     */
    public PlayRecord(String userName, int score) {
        this.userName = userName;
        this.score = score;
    }
}
