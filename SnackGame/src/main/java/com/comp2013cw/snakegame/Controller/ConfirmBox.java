package com.comp2013cw.snakegame.Controller;

import com.comp2013cw.snakegame.Model.ImageMap;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Shows a window to allow user to choose yes or no,
 * be Instantiated after 'Exit' button is clicked.
 * @author Shuli WANG
 */

public class ConfirmBox {

    static boolean answer;

    /**
     * display the confirmation box, waiting the user to choose yes or no
     * @param title the title of the window
     * @param message the prompt message
     * @return true for yes, false for no
     */
    public static boolean display(String title, String message){
        Stage window = new Stage();
        window.getIcons().add(ImageMap.images.get("snake-logo"));

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
//        Button closeButton = new Button("Close the window");
//        closeButton.setOnAction(e -> window.close());

        // create two buttons
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
