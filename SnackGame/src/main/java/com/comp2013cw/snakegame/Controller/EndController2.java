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

/**
 * Controller of the second end screen,
 * shows the player's name, score, and
 * if the score is the highest.
 * @author Shuli WANG
 */

public class EndController2 implements Initializable {
    public Label nameLabel;
    public Label scoreLabel;
    public Label highestLabel;
    public ImageView iv1;
    private final Image image = ImageMap.images.get("congratulation");
    public AnchorPane rootLayout;

    /**
     * what to do if the user clicks 'Play Again'
     * @param actionEvent
     * @throws Exception
     */
    @FXML
    public void playAgain(ActionEvent actionEvent) throws Exception {
        MainController.setScenePlay();
    }

    /**
     * what to do if the user clicks 'Exit'
     * @param actionEvent
     * @throws Exception
     */
    @FXML
    public void exitGame(ActionEvent actionEvent) {
        MainController.exitGame();
    }

    /**
     * initialize the settlement screen
     * @param url
     * @param resourceBundle
     */
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

    /**
     * what to do if the user clicks 'Back To Home'
     * @param actionEvent
     * @throws Exception
     */
    public void backToHome(ActionEvent actionEvent) throws IOException {
        MainController.setSceneStart();
    }
}
