package com.example.registroproductos;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipalApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MenuPrincipalApplication
        .class.getResource("menu-principal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Menú principal del sistema");
        stage.setScene(scene);
        stage.show();

    }
}
