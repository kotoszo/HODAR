package com.aka.hodar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Hodar extends Application{

    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*
        here comes the new Game();
        and the new Scene
         */
        Game game = new Game();
        primaryStage.setScene(new Scene(game, Globals.SCREEN_WIDTH, Globals.SCREEN_HEIGHT));

        primaryStage.show();
    }
}
