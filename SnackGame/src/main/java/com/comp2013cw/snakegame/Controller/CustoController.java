package com.comp2013cw.snakegame.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CustoController {
    public ComboBox colorCombo;
    public ComboBox musicCombo;
    public ComboBox snakeCombo;
    public AnchorPane rootLayout;

    public void clickConfirm(ActionEvent actionEvent) {
    }

    public void clickCancel(ActionEvent actionEvent) {
        Stage stage = (Stage) rootLayout.getScene().getWindow();
        stage.close();
    }
}
