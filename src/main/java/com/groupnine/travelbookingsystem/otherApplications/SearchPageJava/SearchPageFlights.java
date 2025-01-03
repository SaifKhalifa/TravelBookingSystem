package com.groupnine.travelbookingsystem.otherApplications.SearchPageJava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class SearchPageFlights extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/SearchPageFlighte-Hotels/searchPageFlights.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Search Page Flights");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
