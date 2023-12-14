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

public class MyStage extends Application {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;
    //private static final String[]

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Snake Game");
        stage.getIcons().add(ImageMap.images.get("snake-logo"));

        Play play = new Play();
        play.playGame(stage);

    }

    public void loadStage() {
        launch();
    }
}