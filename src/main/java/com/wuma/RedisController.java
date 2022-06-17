/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */

package com.wuma;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
    private JFXListView<Object> listView;

    @FXML // fx:id="mainPane"
    private BorderPane mainPane; // Value injected by FXMLLoader

    @FXML
    void sendComman(ActionEvent event) {

        ArrayList<String> strings1 = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            strings1.add("redis_key_" + i);
        }

        ObservableList<Object> strings = FXCollections.observableArrayList(strings1);
        listView.setItems(strings);

        System.out.println("点击");

        textArea.setText("小，明               " +
                "小红");
        textArea.appendText(comman.getText());

        Pane pane = new DialogPane();

        Stage stage = new Stage();
        stage.setScene(new Scene(pane,300,300));
        stage.setTitle("跳条");
        stage.show();

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert textArea != null : "fx:id=\"textArea\" was not injected: check your FXML file 'sample.fxml'.";
        assert comman != null : "fx:id=\"comman\" was not injected: check your FXML file 'sample.fxml'.";
        assert sendCommanButton != null : "fx:id=\"sendCommanButton\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
