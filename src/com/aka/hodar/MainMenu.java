package com.aka.hodar;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.Stack;

public class MainMenu extends Pane {

    public MainMenu(){
        setTableBackground(new Image("bgv2.jpg"));

        StackPane imageStack = new StackPane();
        imageStack.setLayoutX(100);imageStack.setLayoutY(100);
        ImageView imgV = new ImageView(new Image("images/classes/warrior/warrior.png"));
        imageStack.getChildren().add(imgV);

        StackPane nameStack = new StackPane();
        nameStack.setLayoutX(500);nameStack.setLayoutY(500);
        TextField nameField = new TextField();
        nameStack.getChildren().add(nameField);



        getChildren().addAll(nameStack, imageStack);
    }

    void setTableBackground(Image tableBackground){
        setBackground(new Background(new BackgroundImage(tableBackground,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }
}
