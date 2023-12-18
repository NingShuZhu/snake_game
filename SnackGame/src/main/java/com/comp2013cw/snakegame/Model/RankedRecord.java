package com.comp2013cw.snakegame.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RankedRecord {
    private final IntegerProperty idx;//Simple
    private final StringProperty userName;
    private final IntegerProperty score;
//    public String userName;
//    public int score;
//    public int idx;
    public RankedRecord(int idx, String userName, int score) {
        this.idx = new SimpleIntegerProperty(idx);
        this.userName = new SimpleStringProperty(userName);
        this.score = new SimpleIntegerProperty(score);
    }
}
