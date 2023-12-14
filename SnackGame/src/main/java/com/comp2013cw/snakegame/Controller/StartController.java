package com.comp2013cw.snakegame.Controller;

import com.comp2013cw.snakegame.Play;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StartController {
    public AnchorPane rootLayout;

    public void switchToPlay(ActionEvent actionEvent) {
        Stage stage = (Stage) rootLayout.getScene().getWindow();
        Play play = new Play();
        stage.setScene(play.scene);
        stage.show();
        play.playGame();
    }
}
