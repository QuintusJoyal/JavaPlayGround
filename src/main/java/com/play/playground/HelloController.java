package com.play.playground;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class HelloController {
    @FXML
    public Button helloBtn;
    @FXML
    public TextField textBox;
    @FXML
    public Label errorText;
    @FXML
    private Label helloText;

    @FXML
    protected void onHelloButtonClick() {
        helloText.setText("");
        String name = textBox.getText();
        if (name.isBlank()) {
            errorText.setText("Name not specified");
            return;
        }
        errorText.setText("");
        helloText.setText("Hello " + name + "!");
    }

    @FXML
    public void onTextFieldEnter(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            onHelloButtonClick();
        }
    }
}