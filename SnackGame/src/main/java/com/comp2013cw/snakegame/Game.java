package com.comp2013cw.snakegame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game extends Application {

//    private static final int WIDTH = 1000;
//    private static final int HEIGHT = 700;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("view/StartGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Snake Game");
        stage.getIcons().add(ImageMap.images.get("snake-logo"));

        stage.setScene(scene);
        stage.show();
    }
    //public void loadStage
    public static void main(String[] args) {
        launch();
    }
}