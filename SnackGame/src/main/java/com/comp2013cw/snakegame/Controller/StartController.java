package com.comp2013cw.snakegame.Controller;

import com.comp2013cw.snakegame.Model.ImageMap;
import com.comp2013cw.snakegame.Model.MusicMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.net.spi.InetAddressResolver;
import java.util.ResourceBundle;

/**
 * Controller of the start screen
 * @author Shuli WANG
 */

public class StartController implements Initializable {

    /**
     * initialize the game's information when the start screen is initialized
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MainController.initMediaPlayers();
        MainController.mediaPlayer = MainController.nsMediaPlayer;
        MainController.bodyImg = MainController.nsBodyImg;
        MainController.headImg = MainController.nsHeadImg;
    }

    /**
     * switch to play game if th user clicked 'Start'
     * @param actionEvent
     * @throws IOException
     */
    public void switchToPlay(ActionEvent actionEvent) throws IOException {
        MainController.setScenePlay();
    }

    /**
     * show the Report Bug window if the user clicked 'Report Bug'
     * @param actionEvent
     * @throws IOException
     */
    public void clickRB(ActionEvent actionEvent) throws IOException {
        System.out.println("RB clicked\n");
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/com/comp2013cw/snakegame/view/reportBugGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage window = new Stage();
        window.setTitle("Report Bug");
        window.getIcons().add(ImageMap.images.get("snake-logo"));
        window.setScene(scene);
        window.showAndWait();
    }

    /**
     * show the High Score window if the user clicked 'High Score'
     * @param actionEvent
     * @throws IOException
     */
    public void clickHS(ActionEvent actionEvent) throws IOException {
        System.out.println("HS clicked\n");
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/com/comp2013cw/snakegame/view/highScoreGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage window = new Stage();
        window.setTitle("High Scores");
        window.getIcons().add(ImageMap.images.get("snake-logo"));
        window.setScene(scene);
        window.showAndWait();
    }

    /**
     * show the customize window if the user clicked 'Customization'
     * @param actionEvent
     * @throws IOException
     */
    public void clickCus(ActionEvent actionEvent) throws IOException {
        //System.out.println("Cus clicked\n");
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/com/comp2013cw/snakegame/view/custoGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage window = new Stage();
        window.setTitle("Customization");
        window.getIcons().add(ImageMap.images.get("snake-logo"));
        window.setScene(scene);
        window.showAndWait();
    }

}
