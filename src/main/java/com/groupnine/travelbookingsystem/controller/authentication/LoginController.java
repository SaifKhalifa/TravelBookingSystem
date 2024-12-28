package com.groupnine.travelbookingsystem.controller.authentication;

import com.groupnine.travelbookingsystem.MainApplication_DEFAULT;
import com.groupnine.travelbookingsystem.util.HibernateUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField passwordTextField, usernameTextField;

    @FXML
    private ImageView passwordToggleIcon, statusIcon;

    @FXML
    private Button passwordToggleButton;

    @FXML
    private Label statusLabel, errorLabel;

    @FXML
    private void initialize() {
        if(!HibernateUtil.getInstance().isConnected())
        {
            statusLabel.setText("Error connecting to database");
            //statusLabel.setStyle("-fx-text-fill: #FF6B6B;");
            statusIcon.setImage(new Image(getClass().getResource("/com/groupnine/travelbookingsystem/Assets/imgs/auth/disconnected_icon.png").toExternalForm()));
        }
        else{
            statusLabel.setText("Connected to database");
            statusIcon.setImage(new Image(getClass().getResource("/com/groupnine/travelbookingsystem/Assets/imgs/auth/connected_icon.png").toExternalForm()));
        }

        errorLabel.setVisible(false);
        // Sync password fields
        passwordTextField.textProperty().bindBidirectional(passwordField.textProperty());

        // Set toggle button action
        /*passwordToggleButton.setOnMouseClicked(event -> togglePasswordVisibility());*/
        passwordToggleButton.setOnAction(event -> togglePasswordVisibility());
    }

    private void togglePasswordVisibility() {
        if (passwordField.isVisible()) {
            passwordField.setVisible(false);
            passwordTextField.setVisible(true);
            passwordToggleIcon.setImage(new Image(getClass().getResourceAsStream("/com/groupnine/travelbookingsystem/Assets/imgs/auth/hide-password-logo.png")));
        } else {
            passwordField.setVisible(true);
            passwordTextField.setVisible(false);
            passwordToggleIcon.setImage(new Image(getClass().getResourceAsStream("/com/groupnine/travelbookingsystem/Assets/imgs/auth/show-password-logo.png")));
        }
    }

    @FXML
    private void onLoginButtonClick()
    {
        usernameTextField.setOnMouseClicked(event ->
        {
            errorLabel.setVisible(false);
            //username.clear();
            usernameTextField.selectAll();
        });

        passwordField.setOnMouseClicked(event ->
        {
            errorLabel.setVisible(false);
            //password.clear();
            passwordField.selectAll();
        });

        if(usernameTextField.getText().isEmpty() || passwordField.getText().isEmpty())
        {
            errorLabel.setVisible(true);
            errorLabel.setText("Username/Email and password are required!");
        }
        else
        {
            if (usernameTextField.getText().equals("admin")) {
                if (passwordField.getText().equals("admin")) {
                    errorLabel.setVisible(false);
                    statusLabel.setText("Success, Welcome " + usernameTextField.getText() + "!");
                    statusLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: #35b359;");
                    try {
                        // Corrected path for the FXML file
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/groupnine/travelbookingsystem/view/Home/HomePage_V2.fxml"));
                        Scene mainScene = new Scene(fxmlLoader.load());

                        // Get the current stage
                        Stage currentStage = (Stage) usernameTextField.getScene().getWindow();

                        // Set the new scene
                        currentStage.setScene(mainScene);
                        currentStage.setTitle("Welcome " + usernameTextField.getText() +"!");
                        currentStage.setMaximized(true);
                    } catch (IOException e) {
                        e.printStackTrace(); // Log any loading errors
                    }

                }
            } else {
                errorLabel.setVisible(true);
                errorLabel.setText("Invalid username/email or password!");
            }

        }
    }

    @FXML
    private void onForgetPasswordButtonClick()
    {
        try {
            // Load the next view
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication_DEFAULT.class.getResource("/com/groupnine/travelbookingsystem/view/authentication/forget_password.fxml"));
            Scene mainScene = new Scene(fxmlLoader.load());

            // Get the current stage
            Stage currentStage = (Stage) usernameTextField.getScene().getWindow();

            // Set the new scene
            currentStage.setScene(mainScene);
            currentStage.setTitle("Forget Password");
        } catch (IOException e) {
            e.printStackTrace(); // Log any loading errors
        }
    }

    @FXML
    private void onCreateAccountButtonClick()
    {
        showAlert("Access Denied", "You need to login as an admin first.");

        try {
            // Load the next view
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication_DEFAULT.class.getResource("/com/groupnine/travelbookingsystem/view/authentication/create_account.fxml"));
            Scene mainScene = new Scene(fxmlLoader.load());

            // Get the current stage
            Stage currentStage = (Stage) usernameTextField.getScene().getWindow();

            // Set the new scene
            currentStage.setScene(mainScene);
            currentStage.setTitle("Create Account");
        } catch (IOException e) {
            e.printStackTrace(); // Log any loading errors
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
