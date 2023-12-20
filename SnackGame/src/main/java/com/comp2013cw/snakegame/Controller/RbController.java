package com.comp2013cw.snakegame.Controller;

import com.comp2013cw.snakegame.Model.ImageMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller of Report Bug screen, which can be accessed from the start screen.
 * @author Shuli WANG
 */

public class RbController {
    public AnchorPane rootLayout;

    public void clickSubmit(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) rootLayout.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/com/comp2013cw/snakegame/view/tkGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage window = new Stage();
        stage.getIcons().add(ImageMap.images.get("snake-logo"));
        window.setScene(scene);
        window.showAndWait();
    }
}
