package com.aka.hodarOrigi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class HodarV2 extends Application{

    static final double SCREEN_WIDTH = 1280;
    static final double SCREEN_HEIGHT = 720;

    public static void main(String[] args){ launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(new Game(), SCREEN_WIDTH, SCREEN_HEIGHT));
        primaryStage.show();
    }
}
