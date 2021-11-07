/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Fareed Ally
 */

package baseline;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ToDoListApplication extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ListManager.fxml"));

        primaryStage.setTitle("To-do list");
        primaryStage.setScene(new Scene(root, 600, 500));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}