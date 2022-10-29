package com.jdreamer.studybox.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StudyBox extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();

        BorderPane root = (BorderPane) loader.load(
                getClass().getClassLoader().getResourceAsStream("StudyBox.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Quran Study");
        stage.setScene(scene);
        stage.show();
    }
}
