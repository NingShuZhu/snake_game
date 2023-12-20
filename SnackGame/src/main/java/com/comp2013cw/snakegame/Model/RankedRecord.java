package com.comp2013cw.snakegame.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Class to represent a play record with its ranking.
 * @author Shuli WANG
 */

public class RankedRecord {
//    public final IntegerProperty idx;//Simple
//    public final StringProperty userName;
//    public final IntegerProperty score;
    private final String userName;
    private final int score;
    private final int idx;

    public String getUserName() {
        return userName;
    }
    public int getScore() {
        return score;
    }
    public int getIdx() {
        return idx;
    }

    /**
     * constructor
     * @param idx index
     * @param userName
     * @param score
     */
    public RankedRecord(int idx, String userName, int score) {
        this.idx = idx;
        this.userName = userName;
        this.score = score;
    }
}
