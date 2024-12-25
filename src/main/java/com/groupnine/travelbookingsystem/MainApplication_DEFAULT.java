package com.groupnine.travelbookingsystem;

import com.groupnine.travelbookingsystem.util.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;

public class MainApplication_DEFAULT extends Application {
    // app data
    public static String loggedInUser = "";


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication_DEFAULT.class.getResource("/com/groupnine/travelbookingsystem/view/authentication/login.fxml"));

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
        boolean status = HibernateUtil.getInstance().isConnected();
        System.out.println("Database Connected: " + status);

        launch();
    }
}