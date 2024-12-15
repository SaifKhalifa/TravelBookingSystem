package com.groupnine.travelbookingsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/Homepage.fxml"));
        AnchorPane root = loader.load();

        // إنشاء Scene وربطها
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("FlyStay");
        primaryStage.show();

        // ربط العناصر بأبعاد النافذة
        root.prefWidthProperty().bind(scene.widthProperty());
        root.prefHeightProperty().bind(scene.heightProperty());

    }

    public static void main(String[] args) {
        launch(args);
    }
}
