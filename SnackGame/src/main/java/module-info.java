open module com.comp2013cw.snakegame {
    requires java.desktop;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.media;

    exports com.comp2013cw.snakegame;
    exports com.comp2013cw.snakegame.Controller;
    exports com.comp2013cw.snakegame.Model;
}