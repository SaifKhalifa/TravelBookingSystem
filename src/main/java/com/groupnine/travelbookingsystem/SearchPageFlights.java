package com.groupnine.travelbookingsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;


public class SearchPageFlights extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/searchPageFlights.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Search Page Flights");
        primaryStage.setScene(new Scene(root, 1280, 800));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
