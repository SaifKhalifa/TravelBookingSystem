package com.groupnine.travelbookingsystem.otherApplications.ResultSearchJava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class ResultSearchFlights extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/ResultSearchFlights-Hotels/resultSearchFlights.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Result Search Flights");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

