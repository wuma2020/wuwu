package com.wuma;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField username;

    @FXML
    private TextField passwd;

    @FXML
    private Button login;

    public void loginIn(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();
        System.out.println(source);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("提示");
        alert.setHeaderText(username.getText() + " | " + passwd.getText());
        alert.showAndWait();

    }


}
