package com.groupnine.travelbookingsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication_DEFAULT extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(MainApplication_DEFAULT.class.getResource("/com/groupnine/travelbookingsystem/view/authentication/login.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication_DEFAULT.class.getResource("/com/groupnine/travelbookingsystem/view/SearchPageFlighte-Hotels/searchPageHotels.fxml"));

        Parent root = fxmlLoader.load();

        // Automatically set stage size based on the root node
        Scene scene = new Scene(root);
        stage.setTitle("Login");
        stage.setResizable(true);
        stage.setScene(scene);

        // Adjust stage size to fit the root node's preferred dimensions
        stage.sizeToScene();
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}