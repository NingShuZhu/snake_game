package com.comp2013cw.snakegame.Model;

import com.comp2013cw.snakegame.Controller.MainController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {

    @Test
    void willBeEaten() {
        Food food = new Food();
        int x = food.getFoodX();
        int y = food.getFoodY();

        MainController.headImg = MainController.nsHeadImg;
        MainController.bodyImg = MainController.nsBodyImg;
        Snake snake = new Snake(x, y);
        snake.eatFood(food);
        assertTrue(food.isEaten);
    }

}