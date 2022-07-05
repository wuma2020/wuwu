package com.wuma;


import cn.hutool.core.util.StrUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.wuma.redis.RedisApplication;
import com.wuwu.base.client.WuwuApplication;
import com.wuwu.base.client.WuwuFutureClient;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Copyright (C), 2022-2022, wuma2020
 * Author: wuma2020
 * Date: 2022/7/5 10:40 下午
 * FileName: MainController
 * Description:
 */
public class MainController {

    private static final Logger LOGGER = LogManager.getLogger();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="command"
    private TextField command; // Value injected by FXMLLoader

    @FXML // fx:id="sendCommand"
    private JFXButton sendCommand; // Value injected by FXMLLoader

    @FXML // fx:id="listView"
    private ListView<Object> listView; // Value injected by FXMLLoader

    @FXML // fx:id="tabPanel"
    private TabPane tabPanel; // Value injected by FXMLLoader

    @FXML // fx:id="tabInfo"
    private Tab tabInfo; // Value injected by FXMLLoader

    @FXML // fx:id="tabInfoArea"
    private JFXTextArea tabInfoArea; // Value injected by FXMLLoader

    @FXML
    void sendCommandMethod(MouseDragEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert command != null : "fx:id=\"command\" was not injected: check your FXML file 'mainWindow1.fxml'.";
        assert sendCommand != null : "fx:id=\"sendCommand\" was not injected: check your FXML file 'mainWindow1.fxml'.";
        assert listView != null : "fx:id=\"listView\" was not injected: check your FXML file 'mainWindow1.fxml'.";
        assert tabPanel != null : "fx:id=\"tabPanel\" was not injected: check your FXML file 'mainWindow1.fxml'.";
        assert tabInfo != null : "fx:id=\"tabInfo\" was not injected: check your FXML file 'mainWindow1.fxml'.";
        assert tabInfoArea != null : "fx:id=\"tabInfoArea\" was not injected: check your FXML file 'mainWindow1.fxml'.";

        initRedis();
        setListViewItem();
        addListViewMouseClick();

    }



    /**
     * 点击鼠标的监听事件
     */
    private void addListViewMouseClick() {

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                //newValue 为每次点击是当前选中的对象的值，oldValue为上一次选中的值
                WuwuFutureClient client = RedisApplication.getWuwu().getClient();
                String s = client.get(String.valueOf(newValue).substring(1,String.valueOf(newValue).length()-1));
                client.recycleSocket();
                tabInfoArea.setText(s);
            }catch (Exception e){
                LOGGER.error("获取key:{}失败",newValue);
                throw new RuntimeException(e);
            }
        });

    }

    /**
     * 设置key的值
     * todo 添加点击的监听事件
     */
    private void setListViewItem() {
        try {
            WuwuApplication wuwu = RedisApplication.getWuwu();
            WuwuFutureClient client = wuwu.getClient();
            List<String> keys = (List)client.keys();
            client.recycleSocket();
            List<String> cleanBlankString = keys.stream().map(aa -> {
                String s = StrUtil.cleanBlank(aa);
                return s;
            }).collect(Collectors.toList());
            ObservableList<Object> observableList = FXCollections.observableArrayList(cleanBlankString);
            setKeyListener(observableList);
            listView.setItems(observableList);
        }catch (Exception e){
            LOGGER.error("setListView 出错");
            throw  new RuntimeException(e);
        }


    }

    /**
     *
     * @param observableList
     */
    private void setKeyListener(ObservableList<Object> observableList) {

        observableList.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println("bnbb");
            }
        });
        observableList.addListener(new ListChangeListener<Object>() {
            @Override
            public void onChanged(Change<?> c) {
                System.out.println("是啊金");
            }
        });

    }

    private void initRedis() {
        RedisApplication.initRedisContext();
    }


}
