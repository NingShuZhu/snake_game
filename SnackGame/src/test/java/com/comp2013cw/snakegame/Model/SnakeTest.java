package com.comp2013cw.snakegame.Model;

import com.comp2013cw.snakegame.Controller.MainController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakeTest {

    @Test
    void snakeOutOfBound() {
        MainController.headImg = MainController.nsHeadImg;
        MainController.bodyImg = MainController.nsBodyImg;
        var snake = new Snake(900, 600);
        snake.outOfBounds();
        assertTrue(snake.die);
    }
    @Test
    void moveCorrectly() {
        MainController.headImg = MainController.nsHeadImg;
        MainController.bodyImg = MainController.nsBodyImg;
        var snake = new Snake(300, 400);
        snake.move(2);
        assertEquals(400 - 25, snake.y);
    }

}