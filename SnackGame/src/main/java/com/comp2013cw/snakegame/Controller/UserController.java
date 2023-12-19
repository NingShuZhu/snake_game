package com.comp2013cw.snakegame.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserController {
    public Label userName;
    public AnchorPane rootLayout;

    public void clickSwitch(ActionEvent actionEvent) {
        Stage stage = (Stage) rootLayout.getScene().getWindow();
        stage.close();
    }
}
