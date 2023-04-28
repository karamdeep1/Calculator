package com.example.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // loads fxml file
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        // creates a scene later to be put onto the stage
        Scene scene = new Scene(fxmlLoader.load(), 321, 290);
        // gets rid of resizing the stage
        stage.setResizable(false);
        // sets the title to calculator
        stage.setTitle("Calculator");
        // puts the scene onto the stage
        stage.setScene(scene);
        //shows the stage
        stage.show();
    }
    //main method to launch the application
    public static void main(String[] args) {
        launch();
    }
}