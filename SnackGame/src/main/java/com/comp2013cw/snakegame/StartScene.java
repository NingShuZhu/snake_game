package com.comp2013cw.snakegame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class StartScene {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 700;
    public Scene start;
    public StartScene() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/comp2013cw/snakegame/view/StartGUI.fxml"));
        start = new Scene(root);//, WIDTH, HEIGHT
    }

}
