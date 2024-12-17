package com.groupnine.travelbookingsystem.Sana;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/Home/Homepage.fxml"));
        Parent root = loader.load(); // Cast to Parent, not AnchorPane

        // Create Scene and set it
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("FlyStay");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
