package com.aka.hodar.entities;

import com.aka.hodar.ClassTypes;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Mage extends Entities {

    public Mage(Pane pane, double x, double y, ClassTypes classType){
        super(pane, x, y, classType);
        setImage(new Image("images/classes/mage/mage.png"));

    }

    @Override
    public void printSelected() {
        System.out.println("Mage");
    }
}
