package com.comp2013cw.snakegame.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Controller of the customization screen, which can be accessed from the start screen.
 * @author Shuli WANG
 */

public class CustoController implements Initializable {
    public ComboBox<String> colorCombo;
    public ComboBox<String> musicCombo;
    public ComboBox<String> snakeCombo;
    public AnchorPane rootLayout;

    /**
     * if the user clicks confirm, change the UI according to the user's choice
     * @param actionEvent
     */
    public void clickConfirm(ActionEvent actionEvent) {
        if (musicCombo.getValue()!=null) {
            // change the music
            MainController.music = musicCombo.getValue();
            // set the media player
            if (Objects.equals(musicCombo.getValue(), "Mechanistic")) {
                MainController.mediaPlayer = MainController.cyberMediaPlayer;
            } else {
                MainController.mediaPlayer = MainController.nsMediaPlayer;
            }
        }
        if (colorCombo.getValue()!=null) {
            // change the color scheme
            MainController.colorScheme = colorCombo.getValue();
        }
        if (snakeCombo.getValue()!=null) {
            // change the snake appearance
            MainController.snakeScheme = snakeCombo.getValue();
            if (Objects.equals(snakeCombo.getValue(), "Pixel style")) {
                MainController.bodyImg = MainController.cyberBodyImg;
                MainController.headImg = MainController.cyberHeadImg;
                MainController.isCyberSnake = true;
            } else {
                MainController.bodyImg = MainController.nsBodyImg;
                MainController.headImg = MainController.nsHeadImg;
                MainController.isCyberSnake = false;
            }
        }
        Stage stage = (Stage) rootLayout.getScene().getWindow();
        stage.close();
    }

    /**
     * if th user clicks cancel, just close the window without changing
     * @param actionEvent
     */
    public void clickCancel(ActionEvent actionEvent) {
        Stage stage = (Stage) rootLayout.getScene().getWindow();
        stage.close();
    }

    /**
     * initialize the contents of the comboBox
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colorCombo.getItems().addAll(
                "Nature scene (default)",
                "Cyber style"
        );
        musicCombo.getItems().addAll(
                "Brisk (default)",
                "Mechanistic"
        );
        snakeCombo.getItems().addAll(
                "Cute (default)",
                "Pixel style"
        );
        musicCombo.setPromptText(MainController.music);
        snakeCombo.setPromptText(MainController.snakeScheme);
        colorCombo.setPromptText(MainController.colorScheme);
    }
}
