/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */

package com.wuma;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class RedisController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="textArea"
    private TextArea textArea; // Value injected by FXMLLoader

    @FXML // fx:id="comman"
    private JFXTextField comman; // Value injected by FXMLLoader

    @FXML // fx:id="sendCommanButton"
    private JFXButton sendCommanButton; // Value injected by FXMLLoader

    @FXML
    void sendComman(ActionEvent event) {

        System.out.println("点击");

        textArea.setText("小，明               " +
                "小红");
        textArea.appendText(comman.getText());

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert textArea != null : "fx:id=\"textArea\" was not injected: check your FXML file 'sample.fxml'.";
        assert comman != null : "fx:id=\"comman\" was not injected: check your FXML file 'sample.fxml'.";
        assert sendCommanButton != null : "fx:id=\"sendCommanButton\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
