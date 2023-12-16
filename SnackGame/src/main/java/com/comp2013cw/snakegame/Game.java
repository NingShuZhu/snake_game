package com.comp2013cw.snakegame;

import com.comp2013cw.snakegame.Controller.MainController;
import com.comp2013cw.snakegame.Model.ImageMap;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Game extends Application {
    public Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        setInitialScene();
    }

    private void setInitialScene() throws IOException {

        MainController.setGame(this);
        MainController.setSceneStart();

        stage.setTitle("Snake Game");
        stage.getIcons().add(ImageMap.images.get("snake-logo"));

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}