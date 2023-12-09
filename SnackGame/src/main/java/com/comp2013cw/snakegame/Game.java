package com.comp2013cw.snakegame;

import javafx.application.Application;
import javafx.stage.Stage;

//import static javafx.application.Application.launch;

public class Game extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello World");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        //new Play().loadFrame();
        //MusicPlayer.getMusicPlay("./musics/frogger.mp3");
    }
}