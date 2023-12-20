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

    public void clickConfirm(ActionEvent actionEvent) {
        if (musicCombo.getValue()!=null) {
            MainController.music = musicCombo.getValue();
            // set the media player
            if (Objects.equals(musicCombo.getValue(), "Mechanistic")) {
                MainController.mediaPlayer = MainController.cyberMediaPlayer;
            } else {
                MainController.mediaPlayer = MainController.nsMediaPlayer;
            }
            //System.out.println(MainController.music);
        }
        if (colorCombo.getValue()!=null) {
            MainController.colorScheme = colorCombo.getValue();
        }
        if (snakeCombo.getValue()!=null) {
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

    public void clickCancel(ActionEvent actionEvent) {
        Stage stage = (Stage) rootLayout.getScene().getWindow();
        stage.close();
    }

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
