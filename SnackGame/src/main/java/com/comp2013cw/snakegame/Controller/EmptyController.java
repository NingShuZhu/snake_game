package com.comp2013cw.snakegame.Controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Controller of the screen to tell the user
 * the username can't be empty if an empty username is detected.
 * @author Shuli WANG
 */

public class EmptyController {
    public AnchorPane rootLayout;

    public void ok(ActionEvent actionEvent) {
        Stage stage = (Stage) rootLayout.getScene().getWindow();
        stage.close();
    }
}
