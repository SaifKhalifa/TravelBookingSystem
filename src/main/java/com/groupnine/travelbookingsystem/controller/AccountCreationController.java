package com.groupnine.travelbookingsystem.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class AccountCreationController {

    @FXML
    private TextField usernameTextField, emailTextField, phoneNumberTextField, addressTextField, passwordTextField;

    @FXML
    private ComboBox<String> userRoleComboBox;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel, statusLabel;

    @FXML
    private ImageView passwordToggleIcon;

    @FXML
    private Button passwordToggleButton;

    @FXML
    private void initialize() {
        statusLabel.setText("Error connecting to database");
        statusLabel.setStyle("-fx-text-fill: #FF6B6B;");

        errorLabel.setVisible(false);
        // Sync password fields
        passwordTextField.textProperty().bindBidirectional(passwordField.textProperty());

        // Set toggle button action
        /*passwordToggleButton.setOnMouseClicked(event -> togglePasswordVisibility());*/
        passwordToggleButton.setOnAction(event -> togglePasswordVisibility());
    }

    @FXML
    private void onCreateAccountButtonClick() {

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

        // Clear previous error messages
        errorLabel.setVisible(true);
        errorLabel.setText("");

        // Retrieve form values
        String name = usernameTextField.getText().trim();
        String email = emailTextField.getText().trim();
        String phone = phoneNumberTextField.getText().trim();
        String address = addressTextField.getText().trim();
        String role = userRoleComboBox.getValue();
        String password = passwordField.getText();

        // Validate the fields
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || role == null || password.isEmpty()) {
            errorLabel.setText("All fields are required!");
            errorLabel.setTextFill(Color.RED);
            return;
        }

        if (!isValidEmail(email)) {
            emailTextField.requestFocus();
            emailTextField.selectAll();
            errorLabel.setText("Invalid email address!");
            errorLabel.setTextFill(Color.RED);
            return;
        }

        if (!isValidPhone(phone)) {
            phoneNumberTextField.requestFocus();
            phoneNumberTextField.selectAll();
            errorLabel.setText("Invalid phone number!");
            errorLabel.setTextFill(Color.RED);
            return;
        }

        if (password.length() < 8) {
            passwordTextField.requestFocus();
            passwordTextField.selectAll();
            errorLabel.setText("Password must be at least 8 characters long!");
            errorLabel.setTextFill(Color.RED);
            return;
        }

        // If validation passes
        statusLabel.setText("Account created successfully!");
        statusLabel.setTextFill(Color.GREEN);
        clearForm();
    }

    private boolean isValidEmail(String email) {
        // Basic email validation regex
        String emailRegex = "^[\\w-\\._%+]+@[\\w-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

    private boolean isValidPhone(String phone) {
        // Check if phone number contains only digits and has a reasonable length
        return phone.matches("\\d{8,15}");
    }

    private void clearForm() {
        usernameTextField.clear();
        emailTextField.clear();
        phoneNumberTextField.clear();
        addressTextField.clear();
        userRoleComboBox.setValue(null);
        passwordField.clear();
        errorLabel.setText("");
    }

    private void togglePasswordVisibility() {
        if (passwordField.isVisible()) {
            passwordField.setVisible(false);
            passwordTextField.setVisible(true);
            passwordToggleIcon.setImage(new Image(getClass().getResourceAsStream("/com/groupnine/travelbookingsystem/Assets/imgs/hide-password-logo.png")));
        } else {
            passwordField.setVisible(true);
            passwordTextField.setVisible(false);
            passwordToggleIcon.setImage(new Image(getClass().getResourceAsStream("/com/groupnine/travelbookingsystem/Assets/imgs/show-password-logo.png")));
        }
    }
}