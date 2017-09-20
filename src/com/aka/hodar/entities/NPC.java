package com.aka.hodar.entities;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class NPC extends Entities implements EntitiesInterface{


    public NPC(Pane pane, double x, double y){
        super(pane, x, y);
        setImage(new Image("bot.png"));

    }

    @Override
    public void printSelected() {
        System.out.println(getClass().getName());
    }
}
