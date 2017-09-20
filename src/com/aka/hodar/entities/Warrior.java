package com.aka.hodar.entities;

import com.aka.hodar.ClassTypes;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Warrior extends Entities implements EntitiesInterface{

    private int health = 100;

    public Warrior(Pane pane, double x, double y, ClassTypes classType){
        super(pane, x ,y, classType);
        setImage(new Image("images/classes/warrior/warrior.png"));
        this.health = health;
    }

    @Override
    public void printSelected() {
        System.out.println("Warrior");
    }

}
