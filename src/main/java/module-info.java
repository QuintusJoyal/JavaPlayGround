module com.play.playground {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.play.playground to javafx.fxml;
    exports com.play.playground;
}