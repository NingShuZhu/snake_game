package com.comp2013cw.snakegame;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AllInOne extends Application {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;
    //private static final String[]

    private static final int RIGHT = 0;
    private static final int LEFT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;

    private GraphicsContext gc;
    private List<Point> snakeBody = new ArrayList<>();
    private Image foodImage;
    private final Image bodyImg = new Image(getClass().getResourceAsStream("/images/snake-body.png")); // 25*25
    private final Image newImgSnakeHead = new Image(getClass().getResourceAsStream("/images/snake-head-right.png"));
    private double headWidth = newImgSnakeHead.getWidth(); //25
    private double headHeight = newImgSnakeHead.getHeight();
    private final Image gameOverImg = new Image(getClass().getResourceAsStream("/images/game-scene-01.jpg"));
    private int foodX;
    private int foodY;
    private double foodW;
    private double foodH;
    private boolean gameOver = false;
    private int currentDirection;
    private int x = WIDTH/2;
    private int y = HEIGHT/2;
    private int speed_XY = 25;
    private int score = 0;
    private boolean addBody = false;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Snakee Game");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/snake-logo.png")));
        StackPane root = new StackPane();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);
        Image image = new Image(getClass().getResourceAsStream("/images/UI-background.png"));
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1.0, 1.0, true, true, false, false)); // to fill the window
        Background background = new Background(backgroundImage);
        Scene scene = new Scene(root);//,WIDTH,HEIGHT
        root.setBackground(background);

        stage.setScene(scene);
        stage.show();
        gc = canvas.getGraphicsContext2D();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode code = event.getCode();
                if (code == KeyCode.RIGHT || code == KeyCode.D) {
                    if (currentDirection != LEFT) {
                        currentDirection = RIGHT;
                    }
                }
                if (code == KeyCode.LEFT || code == KeyCode.A) {
                    if (currentDirection != RIGHT) {
                        currentDirection = LEFT;
                    }
                }
                if (code == KeyCode.UP || code == KeyCode.W) {
                    if (currentDirection != DOWN) {
                        currentDirection = UP;
                    }
                }
                if (code == KeyCode.DOWN || code == KeyCode.S) {
                    if (currentDirection != UP) {
                        currentDirection = DOWN;
                    }
                }
            }
        });

        generateFood();
        drawScore();

        //System.out.println("body width = " + bodyImg.getWidth());

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(130), e -> run(gc)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }


    private void run(GraphicsContext gc){
        //drawBackground(gc);
        if (gameOver) {
            // switch the scene
            double w = gameOverImg.getWidth();
            double h = gameOverImg.getHeight();
            gc.drawImage(gameOverImg, (WIDTH-w) /2, (HEIGHT-h) /2);
            return;
        }
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        drawFood(gc);
        drawSnake(gc);
        drawScore();
        move();
        eatFood();
        eatBody();
        outofBounds();
    }

    private void generateFood() {
        start:
        while (true) {
            foodX = (int) (Math.random()*WIDTH);
            foodY = (int) (Math.random()*HEIGHT);

            // check if the food is eaten
//            for (Point snake : snakeBody) {
//                if (snake.getX() == foodX && snake.getY() == foodY) {
//                    continue start;
//                }
//            }
            foodImage = new Image(getClass().getResourceAsStream("/images/food-kiwi.png"));
            foodW = foodImage.getWidth();
            foodH = foodImage.getHeight();
            break;  // why use while? start label related to while loop
        }
    }

    private void drawFood(GraphicsContext gc) {
        gc.drawImage(foodImage, foodX, foodY, 20,20);
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

    private void outofBounds() {
        boolean xOut = (x < 0 || x > WIDTH);
        boolean yOut = (y < 0 || y > HEIGHT);
        if (xOut || yOut)
        {
            gameOver = true;
        }
    }

    private void drawSnakeBody(GraphicsContext gc) {
//        gc.setFill(Color.web("4674E9"));
//        gc.fillRoundRect(snakeHead.getX(), snakeHead.getY(), 9, 9, 35,35);
        if (snakeBody.size() > 1) {
            for(int i = 0; i < snakeBody.size() - 1; i++){
                //gc.fillRoundRect(snakeBody.get(i).getX(), snakeBody.get(i).getY(), 9, 9, 20, 20);
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
                break;
            case LEFT:
                // move left
                x -= speed_XY;
                // snake head to left
                break;
            case UP:
                // move up
                y -= speed_XY;
                // snake head to up
                break;
            case DOWN:
                // move down
                y += speed_XY;
                // snake head to down
                break;
        }
    }

    private void eatFood() {
        if ((x + headWidth >= foodX && x <= foodX + foodW) && (y + headHeight >= foodY && y <= foodY + foodH)) {
            addBody = true;
            generateFood();
            score += 521;
        } else addBody = false;
    }

    private void drawScore() {
        gc.setFill(Color.WHITE);
        gc.setFont(new Font("Digital-7", 35));
        gc.fillText("Score: " + score, 10, 35);
    }

    public static void main(String[] args){
        launch(args);
    }
}
