package com.comp2013cw.snakegame;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;

public class Game extends Application {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;
    //private static final String[]

    private static final int RIGHT = 0;
    private static final int LEFT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;

    private GraphicsContext gc;
    private final javafx.scene.image.Image gameOverImg = ImageMap.images.get("game-scene-01");
    private int currentDirection;
    Food food = new Food();
    Snake mySnake = new Snake(100,100);

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Snake Game");
        stage.getIcons().add(ImageMap.images.get("snake-logo"));
        StackPane root = new StackPane();
        javafx.scene.canvas.Canvas canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);

        // Set background image
        Image image = ImageMap.images.get("UI-background");
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1.0, 1.0, true, true, false, false)); // to fill the window
        Background background = new Background(backgroundImage);
        Scene scene = new Scene(root);
        root.setBackground(background);

        stage.setScene(scene);
        stage.show();
        gc = canvas.getGraphicsContext2D();

        // Let the scene listen to the keyboard to set the moving direction
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

        drawScore(gc);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(130), e -> run(gc)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }


    private void run(GraphicsContext gc){
        //drawBackground(gc);
        if (mySnake.die) {
            // switch the scene
            double w = gameOverImg.getWidth();
            double h = gameOverImg.getHeight();
            gc.drawImage(gameOverImg, (WIDTH-w) /2, (HEIGHT-h) /2);
            return;
        }
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        food.draw(gc);
        mySnake.drawSnake(gc);
        drawScore(gc);
        mySnake.move(currentDirection);
        mySnake.eatFood(food);
        if (food.isEaten)
            food = new Food();
        mySnake.eatBody();
        mySnake.outOfBounds();
    }

    private void drawScore(GraphicsContext gc) {
        this.gc.setFill(Color.WHITE);
        this.gc.setFont(new Font("Digital-7", 35));
        this.gc.fillText("Score: " + mySnake.score, 10, 35);
    }

    public static void main(String[] args){
        launch(args);
    }
}