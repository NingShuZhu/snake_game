module com.comp2013cw.snakegame {
    requires java.desktop;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;

    opens com.comp2013cw.snakegame to javafx.fxml;
    exports com.comp2013cw.snakegame;
}