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

/**
 * The thread to run the game logic of each frame.
 * @author Shuli WANG
 */

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

    /**
     * override the run() method in Thread, run the game and
     * determine if the game has ended
     * @throws RuntimeException
     */
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
                        gameC.changeLevel();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            if (gameC.mySnake.die) return;
        }

    }
}
