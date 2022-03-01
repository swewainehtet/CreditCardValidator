package com.example.creditcard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CreditCardApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CreditCardApplication.class.getResource("creditCardView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Credit Card Validator by Swe Waine Htet");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}