package com.comp2013cw.snakegame.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class EndController implements Initializable {

    @FXML
    public void playAgain(ActionEvent actionEvent) throws Exception {
        MainController.setScenePlay();
    }

    @FXML
    public void exitGame(ActionEvent actionEvent) {
        MainController.exitGame();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("initialized\n");
    }
}
