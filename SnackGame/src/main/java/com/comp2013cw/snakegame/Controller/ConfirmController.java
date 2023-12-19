package com.comp2013cw.snakegame.Controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ConfirmController {
    public AnchorPane rootLayout;
    public boolean answer;

    public void clickYes(ActionEvent actionEvent) throws IOException {
        answer = true;
        Stage stage = (Stage) rootLayout.getScene().getWindow();
        stage.close();
        MainController.setSceneStart();
    }

    public void clickNo(ActionEvent actionEvent) {
        answer = false;
        Stage stage = (Stage) rootLayout.getScene().getWindow();
        stage.close();
    }
}
