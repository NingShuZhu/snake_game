package com.comp2013cw.snakegame.Controller;

import com.comp2013cw.snakegame.Game;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class MainController {
    private static Game game;
    public static void setSceneStart() throws IOException {
        //System.out.println(MainController.class.getResource("view/StartGUI.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/com/comp2013cw/snakegame/view/StartGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        game.stage.setScene(scene);
    }
    public static void setScenePlay() throws IOException {
        //GameController gameController = new GameController();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/com/comp2013cw/snakegame/view/playGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        game.stage.setScene(scene);
        GameController gameController = fxmlLoader.getController();
        gameController.playGame();
    }
    public static void setSceneEnd() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/com/comp2013cw/snakegame/view/endGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        game.stage.setScene(scene);
    }

    public static void exitGame() {
        game.stage.close();
    }

    public static void setGame(Game game) {
        MainController.game = game;
    }
}
