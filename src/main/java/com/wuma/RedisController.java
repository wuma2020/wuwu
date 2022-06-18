/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */

package com.wuma;

import cn.hutool.core.util.StrUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.wuma.redis.RedisApplication;
import com.wuwu.base.client.WuwuApplication;
import com.wuwu.base.client.WuwuFutureClient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RedisController {

    private static final Logger LOGGER = LogManager.getLogger();

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
    private JFXListView<Object> listView; // Value injected by FXMLLoader

    /**
     * todo 发送命令，然后显示到右侧的showArea中，后续做成tabPane的添加
     * @param event
     */
    @FXML
    void sendComman(ActionEvent event) {

    // TODO 发送命令，然后显示到右侧的showArea中，后续做成tabPane的添加
        System.out.println("点击事件");

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

        initRedis();
        setListView();

    }

    private void setListView() {
        try {
            WuwuApplication wuwu = RedisApplication.getWuwu();
            WuwuFutureClient client = wuwu.getClient();
            List<String> keys = (List)client.keys();
            List<String> cleanBlankString = keys.stream().map(aa -> {
                String s = StrUtil.cleanBlank(aa);
                return s;
            }).collect(Collectors.toList());
            ObservableList<Object> observableList = FXCollections.observableArrayList(cleanBlankString);
            listView.setItems(observableList);
        }catch (Exception e){
            LOGGER.error("setListView 出错");
            throw  new RuntimeException(e);
        }


    }

    private void initRedis() {
        RedisApplication.initRedisContext();
    }
}
