package com.comp2013cw.snakegame.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class RbController {
    public AnchorPane rootLayout;

    public void clickSubmit(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) rootLayout.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/com/comp2013cw/snakegame/view/tkGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage window = new Stage();
        window.setScene(scene);
        window.showAndWait();
    }
}
