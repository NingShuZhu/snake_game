package com.comp2013cw.snakegame.Controller;

import com.comp2013cw.snakegame.Model.ImageMap;
import com.comp2013cw.snakegame.Model.PlayRecord;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;

public class GameThread extends Thread {
    public boolean isWaiting = false;
    //private volatile boolean isPaused = true;
    private GameController gameC;

    GameThread(GameController gameController) {
        gameC = gameController;
    }

//    public void setPaused(boolean paused) {
//        isPaused = paused;
//    }

    @Override
    public void run() throws RuntimeException {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                MainController.setScore(gameC.mySnake.score);
                return;
            }
            synchronized (this) {
                while (gameC.paused) {
                    try {
                        isWaiting = true;
                        MainController.mediaPlayer.pause();
                        System.out.println("waiting\n");
                        wait();
                        isWaiting = false;
                        MainController.mediaPlayer.play();
                        System.out.println("not waiting\n");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            // run the game
            gameC.run(gameC.gc);
            try {
                synchronized (this) {
                    if (!Thread.currentThread().isInterrupted())
                        Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(() -> {
                try {
                    if (gameC.mySnake.die) {
                        MainController.mediaPlayer.stop();
                        MainController.setScore(gameC.mySnake.score);
                        MainController.setSceneEnd();
                        return;
                    }
                    if (gameC.mySnake.score > 2000 && !gameC.bgChanged) {
                        // speed up
                        gameC.mySnake.speed_XY = gameC.mySnake.speed_XY * 2;
                        gameC.bgChanged = true;
                        // put text
                        Label label = new Label("\n\n                  Night coming!\n                  Speed up!");
                        label.setTextFill(Color.web("#a3a5cf"));
                        label.setFont(new Font("Candara", 30));
                        gameC.rootLayout.getChildren().add(label);
                        // Set new background image
                        gameC.setBackground(gameC.background2);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            if (gameC.mySnake.die) return;
        }

    }
}
