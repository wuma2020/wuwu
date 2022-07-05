package com.wuma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/mainWindow1.fxml"));
        primaryStage.setTitle("wuma redis 客户端");
        primaryStage.setScene(new Scene(root, 600, 400));
        Image image = new Image(getClass().getResource("/image/redis.png").toString());
        primaryStage.getIcons().add(image);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
