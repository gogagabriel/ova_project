package com.ase.ova.ro;

import com.ase.ova.dao.ro.Person;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;




/**
 * @Author : Gabriel Goga & Diana Ciuca & Alina Mirt & Alexandra Cocu
 * @Created : 2018-04-28
 * @E-mail : goga.o.gabriel@gmail.com
 * @Version : 1.0
 */
public class Main extends Application {
	@FXML
    private ImageView imageView;
	TableColumn<Person, Person> unfriendCol = new TableColumn<>("Anti-social");
	
    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/ova.fxml"));
        //FXMLLoader loader = new FXMLLoader(Main.class.getResource("/bootstrap3overview.fxml"));
        loader.load();
        
        
        
        
        
      
        
        

        primaryStage.setScene(new Scene(loader.<ScrollPane>getRoot(), 900, 700));

        primaryStage.show(); 
    }

	
//	 @Override
//	    public void start(Stage primaryStage) {
//	        primaryStage.setTitle("Hello World!");
//	        Button btn = new Button();
//	        btn.setText("Say 'Hello World'");
//	        btn.setOnAction(new EventHandler<ActionEvent>() {
//	            public void handle(ActionEvent event) {
//	                System.out.println("Hello World!");
//	            }
//	        });
//	        
//	        StackPane root = new StackPane();
//	        root.getChildren().add(btn);
//	        primaryStage.setScene(new Scene(root, 300, 250));
//	        primaryStage.show();
//	    }
	
    public static void main(String[] args) {
        launch(args);
    }

}
