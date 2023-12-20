package com.comp2013cw.snakegame.Controller;

import com.comp2013cw.snakegame.Model.ImageMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller of the first end screen,
 * allow players to enter their names.
 * @author Shuli WANG
 */

public class EndController implements Initializable {

    public TextField name;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("initialized\n");
    }

    public void clickOK(ActionEvent actionEvent) throws IOException {
        if (name.getText() != null && !name.getText().isEmpty()) {
            // set the username as input
            MainController.setName(name.getText());
            // set scene to end2
            MainController.setSceneEnd2();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/com/comp2013cw/snakegame/view/emptyGUI.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage window = new Stage();
            window.getIcons().add(ImageMap.images.get("snake-logo"));
            window.setScene(scene);
            window.show();
        }
    }

}
