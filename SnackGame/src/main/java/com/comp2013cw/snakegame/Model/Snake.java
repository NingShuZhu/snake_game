package com.comp2013cw.snakegame.Model;

import com.comp2013cw.snakegame.Controller.MainController;
import javafx.scene.canvas.GraphicsContext;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class of snake, implements the interface Movable.
 * @author Shuli WANG-modified
 */

public class Snake implements Movable{
    private static final int WIDTH = 880;
    private static final int HEIGHT = 580;

    private static final int RIGHT = 0;
    private static final int LEFT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;
    private final List<Point> snakeBody = new ArrayList<>();
    private final javafx.scene.image.Image bodyImg = MainController.bodyImg; // 25*25
    private final javafx.scene.image.Image ImgSnakeHead = MainController.headImg;

    private javafx.scene.image.Image newImgSnakeHead = MainController.headImg;
    private final double headWidth = newImgSnakeHead.getWidth(); //25
    private final double headHeight = newImgSnakeHead.getHeight();
    public int x;
    public int y;
    public int speed_XY = 25;
    public int score = 0;
    public boolean die = false;
    public boolean addBody = false;

    /**
     * constructor, pass the initial position to the snake
     * @param x x coordinate
     * @param y y coordinate
     */
    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * draw the snake on the canvas
     * @param gc graphsContext of the canvas
     */
    public void drawSnake(GraphicsContext gc) {
        // add head
        // if speed is 2 times of the head width, add the middle point too
        if (speed_XY == 50) {
            // get old head point
            Point oldPoint = snakeBody.get(snakeBody.size()-1);
            Point midPoint = new Point((oldPoint.x+x)/2, (oldPoint.y+y)/2);
            snakeBody.add(midPoint);
        }
        snakeBody.add(new Point(x, y));
        //remove tail
        if (speed_XY == 50 && !addBody && snakeBody.size() > 1) {
            snakeBody.remove(0);
            snakeBody.remove(0);
        } else if (speed_XY == 50 && addBody && snakeBody.size() > 1) {
            snakeBody.remove(0);
        }
        if (speed_XY == 25 && !addBody && snakeBody.size() > 1) {
            snakeBody.remove(0);
        }
        // draw the snake's head
        gc.drawImage(newImgSnakeHead, x, y);
        // draw the snake's body
        drawSnakeBody(gc);
    }

    /**
     * draw the snake's body on the canvas
     * @param gc graphsContext of the canvas
     */
    private void drawSnakeBody(GraphicsContext gc) {
        // if the snake has body, draw it one by one
        if (snakeBody.size() > 1) {
            for(int i = 0; i < snakeBody.size() - 1; i++){
                gc.drawImage(bodyImg, snakeBody.get(i).getX(), snakeBody.get(i).getY());
            }
        }
    }

    /**
     * make the snake move a step forward to the current direction
     * @param currentDirection current moving direction
     */
    public void move(int currentDirection) {
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
                newImgSnakeHead = ImageMethods.rotateImage(ImgSnakeHead, -180, MainController.isCyberSnake);
                break;
            case UP:
                // move up
                y -= speed_XY;
                // snake head to up
                newImgSnakeHead = ImageMethods.rotateImage(ImgSnakeHead, -90, MainController.isCyberSnake);
                break;
            case DOWN:
                // move down
                y += speed_XY;
                // snake head to down
                newImgSnakeHead = ImageMethods.rotateImage(ImgSnakeHead, 90, MainController.isCyberSnake);
                break;
        }
    }

    /**
     * method to see if the snake eats the food
     * @param food
     */
    public void eatFood(Food food) {
        // calculate if the snake's head is around the food
        if ((x + headWidth >= food.getFoodX() && x <= food.getFoodX() + food.getFoodW()) && (y + headHeight >= food.getFoodY() && y <= food.getFoodY() + food.getFoodH())) {
            // add body length
            addBody = true;
            // eat food
            food.isEaten = true;
            // add score
            score += 521;
        } else addBody = false;
    }

    /**
     * method to see if the snake eats itself
     */
    public void eatBody() {
        // if two points of the snake are in the same place, it eats itself
        for (Point point : snakeBody)
        {
            for (Point point2 : snakeBody)
            {
                if (point.equals(point2) && point != point2)
                {
                    // if eats itself, the snake dies
                    this.die = true;
                    break;
                }
            }
        }
    }

    /**
     * method to see if the snake is out of bounds
     */
    public void outOfBounds() {
        // if the current place of the snake is out of the bounds of the stage
        boolean xOut = (x < 0 || x > WIDTH);
        boolean yOut = (y < 0 || y > HEIGHT);
        if (xOut || yOut)
        {
            // if out of bounds, the snake dies
            die = true;
        }
    }
}
