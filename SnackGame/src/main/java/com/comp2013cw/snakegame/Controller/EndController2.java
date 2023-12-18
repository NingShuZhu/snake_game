package com.comp2013cw.snakegame.Controller;

import com.comp2013cw.snakegame.Model.ImageMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EndController2 implements Initializable {
    public Label nameLabel;
    public Label scoreLabel;
    public Label highestLabel;
    public ImageView iv2;
    public ImageView iv1;
    private final Image image = ImageMap.images.get("congratulation");

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
//        System.out.println("initialized\n");
        nameLabel.setText(MainController.getName());
        scoreLabel.setText(String.valueOf(MainController.getScore()));
        if (MainController.isHighest) {
            highestLabel.setText("Highest Score!");
            iv1.setImage(image);
            iv2.setImage(image);
        }
    }

    public void backToHome(ActionEvent actionEvent) throws IOException {
        MainController.setSceneStart();
    }
}
