module com.example.registroproductos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.registroproductos to javafx.fxml;
    exports com.example.registroproductos;
    exports com.example.registroproductos.controller;
    opens com.example.registroproductos.controller;
}