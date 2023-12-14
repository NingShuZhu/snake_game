package com.comp2013cw.snakegame.Controller;

import com.comp2013cw.snakegame.StartScene;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EndController {
    public Button playAgainButton;
    public Button exitButton;
    public AnchorPane rootLayout;

    public void playAgain(ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) rootLayout.getScene().getWindow();
        StartScene startScene = new StartScene();
        stage.setScene(startScene.start);
    }

    public void exitGame(ActionEvent actionEvent) {
        Stage stage = (Stage) rootLayout.getScene().getWindow();
        stage.close();
    }
}
