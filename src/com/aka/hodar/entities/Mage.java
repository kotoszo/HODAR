package com.aka.hodar;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Mage extends Entities {

    public Mage(Pane pane, double x, double y){
        super(pane, x, y, "mage");
        setImage(new Image("mage.png"));
    }

    @Override
    void printSelected() {
        System.out.println("Mage");
    }
}
