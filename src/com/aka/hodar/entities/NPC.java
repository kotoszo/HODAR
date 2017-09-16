package com.aka.hodar;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class NPC extends Entities{

    public NPC(Pane pane, double x, double y){
        super(pane, x, y);
        setImage(new Image("bot.png"));
        setOnMouseClicked(event -> {
            if (Globals.isSelected){
                printSelected();
            } else {
                System.out.println("First, select one of your characters");
            }
        });

    }

    @Override
    void printSelected() {
        System.out.println(getClass().getName());
    }
}
