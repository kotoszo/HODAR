package com.aka.hodar.entities;

import com.aka.hodar.Images;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class NPC extends Entities implements EntitiesInterface{


    public NPC(Pane pane, double x, double y){
        super(pane, x, y);
        setImage(Images.ORC1.getImage());
        setScaleX(-1);

    }

    @Override
    public void printSelected() {
        System.out.println(getClass().getName());
    }
}
