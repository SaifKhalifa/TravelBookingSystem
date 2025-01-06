package com.groupnine.travelbookingsystem;

import com.groupnine.travelbookingsystem.util.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication_DEFAULT extends Application {
    // app data
    private static String loggedInUser = "", loggedInUserRole = "";
    private static int loggedInUserId = 0;
    private static Stage primaryStage;

    //--------------------------------------------------------------------------

    public static String getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(String loggedInUser) {
        MainApplication_DEFAULT.loggedInUser = loggedInUser;
    }

    public static String getLoggedInUserRole() {
        return loggedInUserRole;
    }

    public static void setLoggedInUserRole(String loggedInUserRole) {
        MainApplication_DEFAULT.loggedInUserRole = loggedInUserRole;
    }
    public static int getLoggedInUserId() {
        return loggedInUserId;
    }

    public static void setLoggedInUserId(int loggedInUserId) {
        MainApplication_DEFAULT.loggedInUserId = loggedInUserId;
    }

    //--------------------------------------------------------------------------
    public static void loadScene(String fxmlPath, String title, boolean resizable){
        loadScene(fxmlPath, title, resizable, false);
    }
    public static void loadScene(String fxmlPath, String title, boolean resizable, boolean maximized) {
        primaryStage.setMaximized(false);
        primaryStage.setScene(null);
        primaryStage.setResizable(true);
        primaryStage.setFullScreen(false);

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication_DEFAULT.class.getResource(fxmlPath));
            Parent root = fxmlLoader.load();

            Scene newScene = new Scene(root);
            primaryStage.setTitle(title);
            primaryStage.setResizable(resizable);
            primaryStage.setScene(newScene);

            if (maximized) {
                primaryStage.setMaximized(true);  // Maximize after showing the stage
            } else {
                primaryStage.sizeToScene();  // Adjust to fit content if not maximized
            }
            primaryStage.show();

            //primaryStage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load scene: " + fxmlPath);
        }
    }


    //--------------------------------------------------------------------------
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;  // Store reference to primary stage

        loadScene("/com/groupnine/travelbookingsystem/view/authentication/login.fxml", "Login", true);
    }

    private static void checkHibernateConnection() {
        boolean status = HibernateUtil.getInstance().isConnected();
        System.out.println("Database Connected: " + status);
    }

    //--------------------------------------------------------------------------
    public static void main(String[] args) {
        checkHibernateConnection();
        launch();
    }
}