package com.comp2013cw.snakegame.Controller;

import com.comp2013cw.snakegame.Model.ImageMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EndController2 implements Initializable {
    public Label nameLabel;
    public Label scoreLabel;
    public Label highestLabel;
    public ImageView iv1;
    private final Image image = ImageMap.images.get("congratulation");
    public AnchorPane rootLayout;

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
        // set background
        Image bgImage = ImageMap.images.get("end2");
        BackgroundImage backgroundImage = new BackgroundImage(bgImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1.0, 1.0, true, true, false, false)); // to fill the window
        Background background = new Background(backgroundImage);
        rootLayout.setBackground(background);

        // put username on the screen
        nameLabel.setText(MainController.getName() + "!");

        // put score on the screen
        scoreLabel.setText(String.valueOf(MainController.getScore()));

        // if the score is the highest, congratulate
        if (MainController.isHighest) {
            highestLabel.setText("Highest Score!");
            iv1.setImage(image);
        }
    }

    public void backToHome(ActionEvent actionEvent) throws IOException {
        MainController.setSceneStart();
    }
}
