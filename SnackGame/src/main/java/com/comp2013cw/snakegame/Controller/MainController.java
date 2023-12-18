package com.comp2013cw.snakegame.Controller;

import com.comp2013cw.snakegame.ConfirmBox;
import com.comp2013cw.snakegame.Game;
import com.comp2013cw.snakegame.Model.PlayRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Comparator;

public class MainController {
    public static ObservableList<PlayRecord> dataList = FXCollections.observableArrayList();
    public static String colorScheme = "Nature scene (default)";
    public static String music = "Brisk (default)";
    public static String snakeScheme = "Cute (default)";
    private static final Comparator<PlayRecord> comparator = new Comparator<PlayRecord>(){
        @Override
        public int compare(PlayRecord o1, PlayRecord o2) {
            int a = o1.getScore();    //compare the scores
            int b = o2.getScore();
            return Integer.compare(a, b);
        }

    };

    private static Game game;
    private static String name;
    private static int score;
    public static boolean isHighest;
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

    public static void setSceneEnd2() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/com/comp2013cw/snakegame/view/endGUI2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        game.stage.setScene(scene);
    }

    public static void exitGame() {
        boolean answer = ConfirmBox.display("Title", "Sure you want to exit?");
        if (answer)
            game.stage.close();
    }

    public static void setGame(Game game) {
        MainController.game = game;
    }

    public static void addData(PlayRecord pr) {
        dataList.add(pr);
    }

    public static void setName(String text) {
        name = text;
        addAndSortData();
    }

    private static void addAndSortData() {
        dataList.add(new PlayRecord(name, score));
        dataList.sort(comparator.reversed()); // scores from highest to lowest
    }

    public static void setScore(int s) {
       score = s;
       if (!dataList.isEmpty()) {
           isHighest = s > dataList.get(0).getScore();
       } else {
           isHighest = true;
       }
    }

    public static String getName() {
        return name;
    }
    public static int getScore() {
        return score;
    }
}
