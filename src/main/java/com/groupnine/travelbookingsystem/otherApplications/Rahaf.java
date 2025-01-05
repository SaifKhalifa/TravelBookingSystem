package com.groupnine.travelbookingsystem.otherApplications;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Rahaf extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Rahaf.class.getResource("/com/groupnine/travelbookingsystem/view/BookingDetialsView/details_f.fxml"));
        Parent root = fxmlLoader.load();

        // Automatically set stage size based on the root node
        Scene scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setResizable(false);
        stage.setScene(scene);

        // Adjust stage size to fit the root node's preferred dimensions
        stage.sizeToScene();
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}