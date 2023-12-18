package com.comp2013cw.snakegame.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {

    public void switchToPlay(ActionEvent actionEvent) throws IOException {
        MainController.setScenePlay();
    }

    public void clickUser(MouseEvent mouseEvent) throws IOException {
        System.out.println("User clicked\n");
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/com/comp2013cw/snakegame/view/userGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage window = new Stage();
        window.setScene(scene);
        window.showAndWait();
    }

    public void clickRB(ActionEvent actionEvent) throws IOException {
        System.out.println("RB clicked\n");
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/com/comp2013cw/snakegame/view/reportBugGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage window = new Stage();
        window.setScene(scene);
        window.showAndWait();
    }

    public void clickHS(ActionEvent actionEvent) throws IOException {
        System.out.println("HS clicked\n");
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/com/comp2013cw/snakegame/view/highScoreGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage window = new Stage();
        window.setScene(scene);
        window.showAndWait();
    }

    public void clickCus(ActionEvent actionEvent) throws IOException {
        //System.out.println("Cus clicked\n");
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/com/comp2013cw/snakegame/view/custoGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage window = new Stage();
        window.setScene(scene);
        window.showAndWait();
    }
}
