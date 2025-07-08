package com.test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Application JavaFX démontrant l'utilisation d'un BorderPane pour organiser des éléments
 * dans une fenêtre avec des boutons aux différentes positions.
 */
public class App extends Application
{
     @Override
    public void start(Stage primaryStage) {
        // Création du layout principal (BorderPane)
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        
        // Création des boutons pour chaque position
        Button btnTop = new Button("TOP");
        Button btnLeft = new Button("LEFT");
        Button btnCenter = new Button("CENTER");
        Button btnRight = new Button("RIGHT");
        Button btnBottom = new Button("BOTTOM");
        
        // Configuration des boutons pour occuper toute la largeur dans leurs zones respectives
        btnTop.setMaxWidth(Double.MAX_VALUE);
        btnLeft.setMaxHeight(Double.MAX_VALUE);
        btnCenter.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnRight.setMaxHeight(Double.MAX_VALUE);
        btnBottom.setMaxWidth(Double.MAX_VALUE);
        
        // Ajout des boutons au BorderPane
        root.setTop(btnTop);
        root.setLeft(btnLeft);
        root.setCenter(btnCenter);
        root.setRight(btnRight);
        root.setBottom(btnBottom);
        
        // Création de la scène
        Scene scene = new Scene(root, 400, 300);
        
        // Configuration de la fenêtre principale
        primaryStage.setTitle("BorderPane Layout Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        launch(args);
    }
}
