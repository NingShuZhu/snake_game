package com.comp2013cw.snakegame;
//
//import java.awt.*;
//import java.awt.event.KeyEvent;
//import java.awt.image.BufferedImage;
//import java.util.LinkedList;
//import java.util.List;
//
//public class Snake extends SnakeObject implements Movable
//{
//    // Leikjabreytan.
//    private int speed_XY;
//    private int length;
//    private int num; // ?
//    public int score = 0;
//
//    private static final BufferedImage IMG_SNAKE_HEAD = (BufferedImage) ImageMap.images.get("snake-head-right");
//
//    public static List<Point> bodyPoints = new LinkedList<>();
//
//    private static BufferedImage newImgSnakeHead;
//    boolean up, down, left, right = true;
//
//    public Snake(int x, int y)
//    {
//        this.l = true;
//        this.x = x;
//        this.y = y;
//        this.i = ImageMap.images.get("snake-body");
//        this.w = i.getWidth(null);
//        this.h = i.getHeight(null);
//
//        this.speed_XY = 5;
//        this.length = 1;
//
//        /*
//         * Attention : ?
//         */
//        this.num = w / speed_XY;
//        newImgSnakeHead = IMG_SNAKE_HEAD;
//
//    }
//
//    public int getLength()
//    {
//        return length;
//    }
//
//    public void changeLength(int length)
//    {
//        this.length = length;
//    }
//
//    public void keyPressed(KeyEvent e)
//    {
//        // athugaðu lykilinn
//        switch (e.getKeyCode())
//        {
//            case KeyEvent.VK_UP:
//                if (!down)
//                {
//                    up = true;
//                    down = false;
//                    left = false;
//                    right = false;
//
//                    newImgSnakeHead = (BufferedImage) ImageMethods.rotateImage(IMG_SNAKE_HEAD, -90);
//                }
//                break;
//
//            case KeyEvent.VK_DOWN:
//                if (!up)
//                {
//                    up = false;
//                    down = true;
//                    left = false;
//                    right = false;
//
//                    newImgSnakeHead = (BufferedImage) ImageMethods.rotateImage(IMG_SNAKE_HEAD, 90);
//                }
//                break;
//
//            case KeyEvent.VK_LEFT:
//                if (!right)
//                {
//                    up = false;
//                    down = false;
//                    left = true;
//                    right = false;
//
//                    newImgSnakeHead = (BufferedImage) ImageMethods.rotateImage(IMG_SNAKE_HEAD, -180);
//
//                }
//                break;
//
//            case KeyEvent.VK_RIGHT:
//                if (!left)
//                {
//                    up = false;
//                    down = false;
//                    left = false;
//                    right = true;
//
//                    newImgSnakeHead = IMG_SNAKE_HEAD;
//                }
//
//            default:
//                break;
//        }
//    }
//
//
//    public void move()
//    {
//        // láta kvikindið hreyfa sig
//        if (up)
//        {
//            y -= speed_XY;
//        } else if (down)
//        {
//            y += speed_XY;
//        } else if (left)
//        {
//            x -= speed_XY;
//        } else if (right)
//        {
//            x += speed_XY;
//        }
//
//    }
//
//    @Override
//    public void draw(Graphics g)
//    {
//        outofBounds();
//        eatBody();
//
//        bodyPoints.add(new Point(x, y));
//
//        if (bodyPoints.size() == (this.length + 1) * num)
//        {
//            bodyPoints.remove(0);
//        }
//        g.drawImage(newImgSnakeHead, x, y, null);
//        drawBody(g);
//
//        move();
//    }
//
//    public void eatBody()
//    {
//        for (Point point : bodyPoints)
//        {
//            for (Point point2 : bodyPoints)
//            {
//                if (point.equals(point2) && point != point2)
//                {
//                    this.l = false;
//                }
//            }
//        }
//    }
//
//    public void drawBody(Graphics g)
//    {
//        int length = bodyPoints.size() - 1 - num;
//
//        for (int i = length; i >= num; i -= num)
//        {
//            Point point = bodyPoints.get(i);
//            g.drawImage(this.i, point.x, point.y, null);
//        }
//    }
//
//    private void outofBounds()
//    {
//        boolean xOut = (x <= 0 || x >= (870 - w));
//        boolean yOut = (y <= 40 || y >= (560 - h));
//        if (xOut || yOut)
//        {
//            l = false;
//        }
//    }
//}
//
////public class Snake {
////
////		private static final long serialVersionUID = -3641221053272056036L;
////
////
////    // TODO: það þarf endurnýjun
////
////    public static int moving;
////
////    public static int move(int x) {
////        moving = x;
////        return moving;
////    }
////
////    public static void stop() {
////        moving = 0;
////    }
////}

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

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
    private javafx.scene.image.Image newImgSnakeHead = ImageMap.images.get("snake-head-right");
    private final double headWidth = newImgSnakeHead.getWidth(); //25
    private final double headHeight = newImgSnakeHead.getHeight();
    private int currentDirection;
    public int x = WIDTH/2;
    public int y = HEIGHT/2;
    public int speed_XY = 25;
    public int score = 0;
    public boolean gameOver = false;
    public boolean addBody = false;
    public double getHeadWidth() {
        return headWidth;
    }
    public double getHeadHeight() {
        return headHeight;
    }

    private void drawSnake(GraphicsContext gc) {
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
    private void move() {
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
    private void drawScore(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.setFont(new Font("Digital-7", 35));
        gc.fillText("Score: " + score, 10, 35);
    }
    private void eatBody() {
        for (Point point : snakeBody)
        {
            for (Point point2 : snakeBody)
            {
                if (point.equals(point2) && point != point2)
                {
                    this.gameOver = true;
                    break;
                }
            }
        }
    }

    private void outOfBounds() {
        boolean xOut = (x < 0 || x > WIDTH);
        boolean yOut = (y < 0 || y > HEIGHT);
        if (xOut || yOut)
        {
            gameOver = true;
        }
    }
}
