package com.comp2013cw.snakegame.Controller;

import com.comp2013cw.snakegame.Model.Food;
import com.comp2013cw.snakegame.Game;
import com.comp2013cw.snakegame.Model.ImageMap;
import com.comp2013cw.snakegame.Model.Snake;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    //private static final String[]

    private static final int RIGHT = 0;
    private static final int LEFT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;

    public Scene scene;
    @FXML
    public AnchorPane rootLayout;
    private Canvas canvas;
    private GraphicsContext gc;
    private final javafx.scene.image.Image gameOverImg = ImageMap.images.get("game-scene-01");
    private int currentDirection;
    Food food = new Food();
    Snake mySnake = new Snake(100,100);
    StackPane root;
    private Game game;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        canvas = new Canvas(WIDTH, HEIGHT);
        rootLayout.getChildren().add(canvas);
    }

    public void playGame() {

        gc = canvas.getGraphicsContext2D();

        // Let the scene listen to the keyboard to set the moving direction
        scene = rootLayout.getScene();
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

        new Thread(()->{

            while(!mySnake.die){
                run(gc);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> {
                    try {
                        if (mySnake.die) MainController.setSceneEnd();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }).start();

    }

    private void run(GraphicsContext gc) {
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

}
