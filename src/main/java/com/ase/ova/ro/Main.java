package com.ase.ova.ro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

/**
 * @Author : Gabriel Goga & Diana Ciuca & Alina Mirt & Alexandra Cocu
 * @Created : 2018-04-28
 * @E-mail : goga.o.gabriel@gmail.com
 * @Version : 1.0
 */
public class Main extends Application {
	
	
    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/ova.fxml"));
        //FXMLLoader loader = new FXMLLoader(Main.class.getResource("/bootstrap3overview.fxml"));
        loader.load();

        primaryStage.setScene(new Scene(loader.<ScrollPane>getRoot(), 900, 700));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
