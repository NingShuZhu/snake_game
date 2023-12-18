package com.comp2013cw.snakegame.Controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EmptyController {
    public AnchorPane rootLayout;

    public void ok(ActionEvent actionEvent) {
        Stage stage = (Stage) rootLayout.getScene().getWindow();
        stage.close();
    }
}
