/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */

package com.wuma;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class RedisController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="mainPane"
    private BorderPane mainPane; // Value injected by FXMLLoader

    @FXML // fx:id="tabPane"
    private TabPane tabPane; // Value injected by FXMLLoader

    @FXML // fx:id="keyTab"
    private Tab keyTab; // Value injected by FXMLLoader

    @FXML // fx:id="showArea"
    private TextArea showArea; // Value injected by FXMLLoader

    @FXML // fx:id="comman"
    private JFXTextField comman; // Value injected by FXMLLoader

    @FXML // fx:id="sendCommanButton"
    private JFXButton sendCommanButton; // Value injected by FXMLLoader

    @FXML // fx:id="listView"
    private JFXListView<?> listView; // Value injected by FXMLLoader

    /**
     * todo 发送命令，然后显示到右侧的showArea中，后续做成tabPane的添加
     * @param event
     */
    @FXML
    void sendComman(ActionEvent event) {




    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert mainPane != null : "fx:id=\"mainPane\" was not injected: check your FXML file 'sample.fxml'.";
        assert tabPane != null : "fx:id=\"tabPane\" was not injected: check your FXML file 'sample.fxml'.";
        assert keyTab != null : "fx:id=\"keyTab\" was not injected: check your FXML file 'sample.fxml'.";
        assert showArea != null : "fx:id=\"showArea\" was not injected: check your FXML file 'sample.fxml'.";
        assert comman != null : "fx:id=\"comman\" was not injected: check your FXML file 'sample.fxml'.";
        assert sendCommanButton != null : "fx:id=\"sendCommanButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert listView != null : "fx:id=\"listView\" was not injected: check your FXML file 'sample.fxml'.";

        //todo 初始化的时候，获取所有的key 放到 listView中，并添加时间

    }
}
