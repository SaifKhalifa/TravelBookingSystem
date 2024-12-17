package com.groupnine.travelbookingsystem.controller.authentication;

import com.groupnine.travelbookingsystem.MainApplication_DEFAULT;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class PasswordRecoverController {

    @FXML
    private PasswordField newPasswordField, confirmPasswordField;

    @FXML
    private Button setPasswordButton;

    @FXML
    private Label errorLabel, statusLabel;

    @FXML
    private TextField emailTextField, passwordTextField;

    @FXML
    private ImageView passwordToggleIcon, passwordConfirmToggleIcon;

    @FXML
    private void initialize() {
        statusLabel.setText("Error connecting to database");
        statusLabel.setStyle("-fx-text-fill: #FF6B6B;");

        errorLabel.setVisible(false);
    }

    @FXML
    private void onSetPasswordButtonClick(MouseEvent event) {
        errorLabel.setVisible(true);
        errorLabel.setText("");

        String newPassword = newPasswordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
            errorLabel.setText("Both fields are required.");
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            errorLabel.setText("Passwords do not match.");
            return;
        }

        if (newPassword.length() < 8) {
            errorLabel.setText("Password must be at least 8 characters long.");
            return;
        }

        // Simulate password change success (replace with actual logic)
        errorLabel.setText("Password successfully changed.");
        clearNewPasswordFields();
    }

    private void clearNewPasswordFields() {
        newPasswordField.clear();
        confirmPasswordField.clear();
    }

    @FXML
    private void onBackToLoginButtonClick(ActionEvent event) {
        try {
            // Load the next view
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication_DEFAULT.class.getResource("/com/groupnine/travelbookingsystem/view/authentication/login.fxml"));
            Scene loginScene = new Scene(fxmlLoader.load());

            // Get the current stage
            Stage currentStage = (Stage) emailTextField.getScene().getWindow();

            // Set the new scene
            currentStage.setScene(loginScene);
            currentStage.setTitle("Login");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Navigating back to Login view.");
    }

    @FXML
    private void onSubmitEmail(ActionEvent event) {
        errorLabel.setVisible(true);
        errorLabel.setText("");

        String email = emailTextField.getText();

        if (email.isEmpty()) {
            errorLabel.setText("Error: Email field is empty.");
            return;
        }

        if (!isValidEmail(email)) {
            errorLabel.setText("Error: Invalid email format.");
            return;
        }

        // Simulate email submission success (needs to be replaced with the actual logic)
        statusLabel.setText("Password recovery email sent to: " + email);
        statusLabel.setTextFill(Color.GREEN);
        emailTextField.clear();
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
        return email.matches(emailRegex);
    }

    @FXML
    private void togglePasswordVisibility() {
        if (newPasswordField.isVisible()) {
            newPasswordField.setVisible(false);
            passwordTextField.setVisible(true);
            passwordToggleIcon.setImage(new Image(getClass().getResourceAsStream("/com/groupnine/travelbookingsystem/Assets/imgs/hide-password-logo.png")));
            passwordConfirmToggleIcon.setImage(new Image(getClass().getResourceAsStream("/com/groupnine/travelbookingsystem/Assets/imgs/hide-password-logo.png")));
        } else {
            newPasswordField.setVisible(true);
            passwordTextField.setVisible(false);
            passwordToggleIcon.setImage(new Image(getClass().getResourceAsStream("/com/groupnine/travelbookingsystem/Assets/imgs/show-password-logo.png")));
            passwordConfirmToggleIcon.setImage(new Image(getClass().getResourceAsStream("/com/groupnine/travelbookingsystem/Assets/imgs/show-password-logo.png")));
        }
    }
}