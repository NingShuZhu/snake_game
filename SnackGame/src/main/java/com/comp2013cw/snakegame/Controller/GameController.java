package com.comp2013cw.snakegame.Controller;

import com.comp2013cw.snakegame.ConfirmBox;
import com.comp2013cw.snakegame.Model.Food;
import com.comp2013cw.snakegame.Game;
import com.comp2013cw.snakegame.Model.ImageMap;
import com.comp2013cw.snakegame.Model.Snake;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    //private static final String[]

    private static final int RIGHT = 0;
    private static final int LEFT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;

    public Scene scene;
    @FXML
    public AnchorPane rootLayout;
    @FXML
    public Button endGameButton;
    public ImageView pauseIV;
    public Label highestScore;
    @FXML
    private Canvas canvas;
    GraphicsContext gc;
    private final javafx.scene.image.Image gameOverImg = ImageMap.images.get("game-scene-01");
    private final Image pausedImg = ImageMap.images.get("paused");
    private final Image runningImg = ImageMap.images.get("running");
    private int currentDirection;
    Food food = new Food();
    Snake mySnake = new Snake(100,100);
    boolean bgChanged = false;
    volatile boolean paused = false;
    private Game game;
    private final GameThread myThread = new GameThread(this);
    public MediaPlayer mediaPlayer;
    //    private final Object flag = new Object();;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // play the background music
        Media media = new Media(getClass().getResource("/musics/frogger.mp3").toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

        // show the highest score on the scene
        if (!MainController.dataList.isEmpty()){
            highestScore.setText(String.valueOf(MainController.dataList.get(0).getScore()));
        } else {
            highestScore.setText(" ");
        }

        endGameButton.setFocusTraversable(false);
    }

    public void playGame() {

        gc = canvas.getGraphicsContext2D();

        // Let the scene listen to the keyboard to set the moving direction
        scene = rootLayout.getScene();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode code = event.getCode();
                //System.out.println("key listened\n");
                if (code == KeyCode.RIGHT || code == KeyCode.D) {
                    if (currentDirection != LEFT) {
                        currentDirection = RIGHT;
                    }
                }
                if (code == KeyCode.LEFT || code == KeyCode.A) {
                    if (currentDirection != RIGHT) {
                        currentDirection = LEFT;
                    }
                }
                if (code == KeyCode.UP || code == KeyCode.W) {
                    if (currentDirection != DOWN) {
                        currentDirection = UP;
                    }
                }
                if (code == KeyCode.DOWN || code == KeyCode.S) {
                    if (currentDirection != UP) {
                        currentDirection = DOWN;
                    }
                }
            }
        });

        drawScore(gc);

        myThread.start();
    }

    public void run(GraphicsContext gc) {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        food.draw(gc);
        mySnake.drawSnake(gc);
        drawScore(gc);
        mySnake.move(currentDirection);
        mySnake.eatFood(food);
        if (food.isEaten)
            food = new Food();
        mySnake.eatBody();
        mySnake.outOfBounds();
    }

    private void drawScore(GraphicsContext gc) {
        this.gc.setFill(Color.WHITE);
        this.gc.setFont(new Font("Digital-7", 35));
        this.gc.fillText("Score: " + mySnake.score, 10, 35);
    }

    public void endGame(ActionEvent actionEvent) throws IOException {
        System.out.println("end game clicked\n");
        if (!paused) {
            paused = true;
        }
        // show a confirm window
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/com/comp2013cw/snakegame/view/confirmGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage window = new Stage();
        window.setScene(scene);
        window.showAndWait();
        ConfirmController confirmController = fxmlLoader.getController();
        boolean answer = confirmController.answer;
        paused = false;
        if (answer) {
            synchronized (myThread) {
                myThread.notify();
                System.out.println("notified\n");
            }
            synchronized (myThread) {
                myThread.interrupt();
            }
        }
        else {
            paused = false;
            synchronized (myThread) {
                myThread.notify();
            }
        }

    }

    public void switchPause(MouseEvent mouseEvent) {
        if (!paused) {
            paused = true;
            pauseIV.setImage(pausedImg);
        } else {
            paused = false;
            pauseIV.setImage(runningImg);
            synchronized (myThread) {
                System.out.println("here3\n");
                myThread.notifyAll();
            }

        }
    }

//    class GameThread extends Thread {
//        private volatile boolean isPaused = true;
//        private GameController myGame;
//
//        public void setPaused(boolean paused) {
//            isPaused = paused;
//        }
//
//        public void setGame(GameController gameController) {
//            myGame = gameController;
//        }
//
//        @Override
//        public void run() {
//            while (true) {
//                synchronized (this) {
//                    while (isPaused) {
//                        try {
//                            wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//            myGame.run(myGame.gc);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            Platform.runLater(() -> {
//                try {
//                    if (mySnake.die) MainController.setSceneEnd();
//                    if (mySnake.score > 2000 && !bgChanged) {
//                        bgChanged = true;
//                        // Set new background image
//                        Image image = ImageMap.images.get("UI-background1");
//                        BackgroundImage backgroundImage = new BackgroundImage(image,
//                                BackgroundRepeat.NO_REPEAT,
//                                BackgroundRepeat.NO_REPEAT,
//                                BackgroundPosition.CENTER,
//                                new BackgroundSize(1.0, 1.0, true, true, false, false)); // to fill the window
//                        Background background = new Background(backgroundImage);
//                        rootLayout.setBackground(background);
//                    }
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//        }
//    }
}
