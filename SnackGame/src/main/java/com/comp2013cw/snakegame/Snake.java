package com.comp2013cw.snakegame;

import javafx.scene.canvas.GraphicsContext;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;
    //private static final String[]

    private static final int RIGHT = 0;
    private static final int LEFT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;
    private final List<Point> snakeBody = new ArrayList<>();
    private final javafx.scene.image.Image bodyImg = ImageMap.images.get("snake-body"); // 25*25
    private final javafx.scene.image.Image ImgSnakeHead = ImageMap.images.get("snake-head-right");

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private javafx.scene.image.Image newImgSnakeHead = ImageMap.images.get("snake-head-right");
    private final double headWidth = newImgSnakeHead.getWidth(); //25
    private final double headHeight = newImgSnakeHead.getHeight();
    public int x;
    public int y;
    public int speed_XY = 25;
    public int score = 0;
    public boolean die = false;
    public boolean addBody = false;
    public double getHeadWidth() {
        return headWidth;
    }
    public double getHeadHeight() {
        return headHeight;
    }

    public void drawSnake(GraphicsContext gc) {
        // add head
        snakeBody.add(new Point(x, y));

        //remove tail
        if (!addBody && snakeBody.size() > 1) {
            snakeBody.remove(0);
        }

        gc.drawImage(newImgSnakeHead, x, y);
        drawSnakeBody(gc);
    }
    private void drawSnakeBody(GraphicsContext gc) {
        if (snakeBody.size() > 1) {
            for(int i = 0; i < snakeBody.size() - 1; i++){
                gc.drawImage(bodyImg, snakeBody.get(i).getX(), snakeBody.get(i).getY());
            }
        }
    }
    void move(int currentDirection) {
        switch (currentDirection) {
            case RIGHT:
                // move right
                x += speed_XY;
                // snake head to right
                newImgSnakeHead = ImgSnakeHead;
                break;
            case LEFT:
                // move left
                x -= speed_XY;
                // snake head to left
                newImgSnakeHead = ImageMethods.rotateImage(ImgSnakeHead, -180);
                break;
            case UP:
                // move up
                y -= speed_XY;
                // snake head to up
                newImgSnakeHead = ImageMethods.rotateImage(ImgSnakeHead, -90);
                break;
            case DOWN:
                // move down
                y += speed_XY;
                // snake head to down
                newImgSnakeHead = ImageMethods.rotateImage(ImgSnakeHead, 90);
                break;
        }
    }

    void eatFood(Food food) {
        if ((x + headWidth >= food.getFoodX() && x <= food.getFoodX() + food.getFoodW()) && (y + headHeight >= food.getFoodY() && y <= food.getFoodY() + food.getFoodH())) {
            addBody = true;
            food.isEaten = true;
            score += 521;
        } else addBody = false;
    }


    void eatBody() {
        for (Point point : snakeBody)
        {
            for (Point point2 : snakeBody)
            {
                if (point.equals(point2) && point != point2)
                {
                    this.die = true;
                    break;
                }
            }
        }
    }

    public void outOfBounds() {
        boolean xOut = (x < 0 || x > WIDTH);
        boolean yOut = (y < 0 || y > HEIGHT);
        if (xOut || yOut)
        {
            die = true;
        }
    }
}
