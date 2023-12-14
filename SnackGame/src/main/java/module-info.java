module com.comp2013cw.snakegame {
    requires java.desktop;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;

    opens com.comp2013cw.snakegame to javafx.fxml;
    exports com.comp2013cw.snakegame;
    exports com.comp2013cw.snakegame.Controller;
    opens com.comp2013cw.snakegame.Controller to javafx.fxml;
}