package com.aka.hodar.entities;

import com.aka.hodar.ClassTypes;
import com.aka.hodar.Images;
import javafx.scene.layout.Pane;

public class Warrior extends Entities implements EntitiesInterface{

    private int health = 100;

    public Warrior(Pane pane, double x, double y, ClassTypes classType){
        super(pane, x ,y, classType);
        setImage(Images.WARRIOR.getImage());
        this.health = health;
    }

    @Override
    public void printSelected() {
        System.out.println("Warrior");
    }

}
