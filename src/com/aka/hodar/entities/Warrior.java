package com.aka.hodar;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Warrior extends Entities {

    public Warrior(Pane pane, double x, double y){
        super(pane, x ,y, "warrior");
        setImage(new Image("warrior.png"));
        pane.getChildren().add(this);
    }

    @Override
    void printSelected() {
        System.out.println("Warrior");
    }
}
