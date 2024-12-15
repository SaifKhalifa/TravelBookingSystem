package com.groupnine.travelbookingsystem.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class AccountCreationController {

    @FXML
    private TextField usernameTextField, emailTextField, phoneNumberTextField, addressTextField;

    @FXML
    private ComboBox<String> userRoleComboBox;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Text errorLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private void onLoginButtonClick() {
        // Clear previous error messages
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
            errorLabel.setFill(Color.RED);
            return;
        }

        if (!isValidEmail(email)) {
            errorLabel.setText("Invalid email address!");
            errorLabel.setFill(Color.RED);
            return;
        }

        if (!isValidPhone(phone)) {
            errorLabel.setText("Invalid phone number!");
            errorLabel.setFill(Color.RED);
            return;
        }

        if (password.length() < 8) {
            errorLabel.setText("Password must be at least 8 characters long!");
            errorLabel.setFill(Color.RED);
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
}