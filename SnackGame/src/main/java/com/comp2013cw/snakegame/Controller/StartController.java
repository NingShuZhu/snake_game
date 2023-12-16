package com.comp2013cw.snakegame.Controller;

import javafx.event.ActionEvent;

import java.io.IOException;

public class StartController {

    public void switchToPlay(ActionEvent actionEvent) throws IOException {
        MainController.setScenePlay();
    }

}
