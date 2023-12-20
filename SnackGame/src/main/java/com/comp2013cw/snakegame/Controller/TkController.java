package com.comp2013cw.snakegame.Controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Controller of the thanks screen, which will show up
 * after the user report a bug.
 * @author Shuli WANG
 */

public class TkController {
    public AnchorPane rootLayout;

    public void ok(ActionEvent actionEvent) {
        Stage stage = (Stage) rootLayout.getScene().getWindow();
        stage.close();
    }
}
