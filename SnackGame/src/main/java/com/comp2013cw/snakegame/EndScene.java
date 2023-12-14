package com.comp2013cw.snakegame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class EndScene {
    public Scene end;
    public EndScene() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/comp2013cw/snakegame/view/endGUI.fxml"));
        end = new Scene(root);//, WIDTH, HEIGHT
    }

}
