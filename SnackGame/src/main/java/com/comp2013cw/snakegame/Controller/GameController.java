package com.comp2013cw.snakegame.Controller;

import com.comp2013cw.snakegame.Model.Food;
import com.comp2013cw.snakegame.Game;
import com.comp2013cw.snakegame.Model.ImageMap;
import com.comp2013cw.snakegame.Model.Snake;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Controller of the screen to play the game.
 * @author Shuli WANG
 */

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
    public Image background1;
    public Image background2;
    private int currentDirection;
    Food food = new Food();
    Snake mySnake = new Snake(100, 100);
    boolean bgChanged = false;
    volatile boolean paused = false;
    private Game game;
    private final GameThread myThread = new GameThread(this);

    /**
     * initialize the game, set the background and draw the highest score
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // play the background music
        MainController.mediaPlayer.play();

        // set the background
        if (Objects.equals(MainController.colorScheme, "Nature scene (default)")) {
            background1 = MainController.nsBackground1;
            background2 = MainController.nsBackground2;
        } else {
            background1 = MainController.cyberBackground1;
            background2 = MainController.cyberBackground2;
        }

        setBackground(background1);

        // show the highest score on the scene
        if (!MainController.dataList.isEmpty()) {
            highestScore.setText(String.valueOf(MainController.dataList.get(0).getScore()));
        } else {
            highestScore.setText(" ");
        }

        endGameButton.setFocusTraversable(false);
    }

    /**
     * method to start playing the game
     */
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

    /**
     * method to run in each frame, used by GameThread
     * @param gc graphicsContext of the canvas
     */
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

    /**
     * set the background of the scene
     * @param image background image
     */
    public void setBackground(Image image) {
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1.0, 1.0, true, true, false, false)); // to fill the window
        Background background = new Background(backgroundImage);
        rootLayout.setBackground(background);
    }

    /**
     * draw the current score on the screen
     * @param gc graphicsContext of the canvas
     */
    private void drawScore(GraphicsContext gc) {
        this.gc.setFill(Color.WHITE);
        this.gc.setFont(new Font("Digital-7", 35));
        this.gc.fillText("Score: " + mySnake.score, 10, 35);
    }

    /**
     * method to change the difficulty level to the more difficult one
     */
    public void changeLevel() {
        // speed up
        mySnake.speed_XY = mySnake.speed_XY * 2;
        bgChanged = true;
        // put text
        Label label = new Label("\n\n                  Night coming!\n                  Speed up!");
        label.setTextFill(Color.web("#a3a5cf"));
        label.setFont(new Font("Candara", 30));
        rootLayout.getChildren().add(label);
        // Set new background image
        setBackground(background2);
    }

    /**
     * what to do if the user clicks 'End Game':
     * let the user confirm the decision, if confirmed, end the game
     * @param actionEvent
     * @throws IOException
     */
    public void endGame(ActionEvent actionEvent) throws IOException {
        System.out.println("end game clicked\n");
        if (!paused) {
            paused = true;
        }
        // show a confirm window
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("/com/comp2013cw/snakegame/view/confirmGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage window = new Stage();
        window.getIcons().add(ImageMap.images.get("snake-logo"));
        window.setScene(scene);
        window.showAndWait();
        ConfirmController confirmController = fxmlLoader.getController();
        boolean answer = confirmController.answer;
        paused = false;
        // if answer is yes, stop the game thread, end the game
        if (answer) {
            synchronized (myThread) {
                myThread.notify();
                System.out.println("notified\n");
            }
            synchronized (myThread) {
                myThread.interrupt();
            }
        }
        // if answer is no, continue the game
        else {
            paused = false;
            synchronized (myThread) {
                myThread.notify();
            }
        }

    }

    /**
     * what to do if the user clicks 'Pause'
     * @param mouseEvent
     */
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

}