package com.comp2013cw.snakegame.Controller;

import com.comp2013cw.snakegame.Game;
import com.comp2013cw.snakegame.Model.PlayRecord;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MainControllerTest {
    Game game = new Game();

    @Test
    void dataInSortedListIsSorted() {
        // add two records
        MainController.setScore(521);
        MainController.setName("Shuli");
        MainController.setScore(1042);
        MainController.setName("Shu");
        // test if the one has higher score is in front of the lower one
        assertEquals("Shu", MainController.dataList.get(0).getUserName());
    }

}