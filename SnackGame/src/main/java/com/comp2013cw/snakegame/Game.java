//package com.comp2013cw.snakegame;
//
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import javax.swing.*;
//
////import static javafx.application.Application.launch;
//
//public class Game extends Application implements EventHandler<ActionEvent> {
//    Stage window;
//    Scene scene1, scene2;
//    Button button;
//
//    @Override
//    public void start(Stage stage) throws Exception {
//
////////////switch between scenes
////        window = stage;
////
////        Label label1 = new Label("welcome to the first scene!");
////        Button button1 = new Button("Go to scene 2");
////        button1.setOnAction(e -> window.setScene(scene2));
////
////        //layout 1 : everything in vertical column
////        VBox layout1 = new VBox(20);//all objects in a column
////        layout1.getChildren().addAll(label1, button1);
////        scene1 = new Scene(layout1, 200, 200);
////
////        Button button2 = new Button("Go back to scene 1");
////        button2.setOnAction(e -> window.setScene(scene1));
////
////        //layout 2
////        StackPane layout2 = new StackPane();
////        layout2.getChildren().add(button2);
////        scene2 = new Scene(layout2, 600, 300);
////
////        window.setScene(scene1);
////        window.setTitle("Hello World");
////        window.show();
//
////        stage.setTitle("Hello World");
////        button = new Button("click me");
////
////        button.setOnAction(this); //call handler
//
////        //layout
////        StackPane layout = new StackPane();
////        layout.getChildren().add(button);
////
////        Scene scene = new Scene(layout,300,250);
////        stage.setScene(scene);
//
////        stage.show();
//
//        window = stage;
//        window.setTitle("try to close by a button");
//
//        window.setOnCloseRequest(e -> {
//            e.consume(); // to prevent the window closes whatever the answer is
//            closeProgram();
//        }); //when click x to exit
//
//        button = new Button("Close Program");
//        button.setOnAction(e -> closeProgram());
//
//        StackPane layout = new StackPane();
//        layout.getChildren().add(button);
//        Scene scene = new Scene(layout,300,250);
//        window.setScene(scene);
//        window.show();
//    }
//
//    private void closeProgram(){
////        System.out.println("file is saved!");
////        window.close();
//        boolean answer = ConfirmBox.display("Title", "Sure you want to exit?");
//        if (answer)
//            window.close();
//    }
//
//    public static void main(String[] args) {
//        launch();
//        //new Play().loadFrame();
//        //MusicPlayer.getMusicPlay("./musics/frogger.mp3");
//    }
//
//    @Override
//    public void handle(ActionEvent actionEvent) {
//        if(actionEvent.getSource()==button){
//            System.out.println("button is clicked");
//        }
//    }
//}