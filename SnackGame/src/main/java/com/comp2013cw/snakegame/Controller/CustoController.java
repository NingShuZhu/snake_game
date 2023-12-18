package com.comp2013cw.snakegame.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CustoController implements Initializable {
    public ComboBox<String> colorCombo;
    public ComboBox<String> musicCombo;
    public ComboBox<String> snakeCombo;
    public AnchorPane rootLayout;

    public void clickConfirm(ActionEvent actionEvent) {
        if (musicCombo.getValue()!=null) {
            MainController.music = musicCombo.getValue();
            //System.out.println(MainController.music);
        }
        if (colorCombo.getValue()!=null) {
            MainController.colorScheme = colorCombo.getValue();
        }
        if (snakeCombo.getValue()!=null) {
            MainController.snakeScheme = snakeCombo.getValue();
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
