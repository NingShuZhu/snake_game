package com.comp2013cw.snakegame.Controller;

import com.comp2013cw.snakegame.Game;
import com.comp2013cw.snakegame.Model.ImageMap;
import com.comp2013cw.snakegame.Model.MusicMap;
import com.comp2013cw.snakegame.Model.PlayRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Comparator;

/**
 * Main Controller, which has static methods to connects all the controllers
 * and switch among the main scenes.
 * @author Shuli WANG
 */

public class MainController {
    public static ObservableList<PlayRecord> dataList = FXCollections.observableArrayList();
    public static String colorScheme = "Nature scene (default)";
    public static String music = "Brisk (default)";
    public static String snakeScheme = "Cute (default)";
    public static Media nsMedia;
    public static Media cyberMedia;
    public static MediaPlayer nsMediaPlayer;
    public static MediaPlayer cyberMediaPlayer;
    public static MediaPlayer mediaPlayer;
    public static Image nsBackground1 = ImageMap.images.get("UI-background");
    public static Image nsBackground2 = ImageMap.images.get("UI-background1");
    public static Image cyberBackground1 = ImageMap.images.get("cyber-bg1");
    public static Image cyberBackground2 = ImageMap.images.get("cyber-bg2");
    public static Image nsBodyImg = ImageMap.images.get("snake-body");
    public static Image cyberBodyImg = ImageMap.images.get("snake-body-cyber");
    public static Image bodyImg;
    public static Image nsHeadImg = ImageMap.images.get("snake-head-right");
    public static Image cyberHeadImg = ImageMap.images.get("snake-head-right-cyber");
    public static Image headImg;
    public static boolean isCyberSnake = false;
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

    /**
     * method to initialize the media players for different musics
     */
    public static void initMediaPlayers() {
        nsMedia = new Media(
                MainController.class.getResource(MusicMap.musicPaths.get("Brisk (default)")).toString()
        );
        nsMediaPlayer = new MediaPlayer(nsMedia);
        // loop the music
        nsMediaPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                nsMediaPlayer.seek(Duration.ZERO);
            }
        });

        cyberMedia = new Media(
                MainController.class.getResource(MusicMap.musicPaths.get("cyber")).toString()
        );
        cyberMediaPlayer = new MediaPlayer(cyberMedia);
    }

    /**
     * method to switch the scene of the stage to the start scene
     * @throws IOException if the fxml file can't be loaded
     */
    public static void setSceneStart() throws IOException {
        //System.out.println(MainController.class.getResource("view/StartGUI.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/com/comp2013cw/snakegame/view/StartGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        game.stage.setScene(scene);
    }

    /**
     * method to switch the scene of the stage to the scene to play game
     * @throws IOException if the fxml file can't be loaded
     */
    public static void setScenePlay() throws IOException {
        //GameController gameController = new GameController();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/com/comp2013cw/snakegame/view/playGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        game.stage.setScene(scene);
        GameController gameController = fxmlLoader.getController();
        gameController.playGame();
    }

    /**
     * method to switch the scene of the stage to the first end scene
     * @throws IOException if the fxml file can't be loaded
     */
    public static void setSceneEnd() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/com/comp2013cw/snakegame/view/endGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        game.stage.setScene(scene);
    }

    /**
     * method to switch the scene of the stage to the second end scene
     * @throws IOException if the fxml file can't be loaded
     */
    public static void setSceneEnd2() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/com/comp2013cw/snakegame/view/endGUI2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        game.stage.setScene(scene);
    }

    /**
     * method to show up a window to ask users to confirm
     * whether they are sure to exit the game
     */
    public static void exitGame() {
        boolean answer = ConfirmBox.display("Confirm", "Sure you want to exit?");
        if (answer)
            game.stage.close();
    }

    /**
     * pass the game to the MainController to deal with switching the scenes.
     * @param game the main instance of the project which extends Application
     */
    public static void setGame(Game game) {
        MainController.game = game;
    }

    /**
     * pass the username to the MainController and
     * add it and its score to the data list,
     * then sort the list
     * @param text username
     */
    public static void setName(String text) {
        name = text;
        addAndSortData();
    }

    /**
     * method to add a play record to the data list
     * and sort the new list
     */
    private static void addAndSortData() {
        dataList.add(new PlayRecord(name, score));
        dataList.sort(comparator.reversed()); // scores from highest to lowest
    }

    /**
     * pass the score to the MainController and
     * see if the score is the highest, if true,
     * set isHighest to true
     * @param s score
     */
    public static void setScore(int s) {
       score = s;
       if (!dataList.isEmpty()) {
           isHighest = s > dataList.get(0).getScore();
       } else {
           isHighest = true;
       }
    }

    /**
     * get the username
     * @return current username
     */
    public static String getName() {
        return name;
    }

    /**
     * get the score
     * @return current score
     */
    public static int getScore() {
        return score;
    }
}
