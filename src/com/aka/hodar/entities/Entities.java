package com.aka.hodar;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class Entities extends ImageView {

    protected Pane pane;

    protected Entities(Pane pane, double x, double y, String name){
        this.pane = pane;
        pane.getChildren().add(this);
        setX(x);setY(y);
        setOnMouseClicked(event ->  {
            if (Globals.chosenName == null){
                printSelected();
                Globals.isSelected = true;
                Globals.chosenName = name;
                setImage(new Image("p1.png"));
            } else {
                if (name == Globals.chosenName){
                    setImage(new Image(name+".png"));
                    Globals.chosenName = null;
                    Globals.isSelected = false;
                }
            }
        });
    }

    protected Entities(Pane pane, double x, double y){
        this.pane = pane;
        pane.getChildren().add(this);
        setX(x);setY(y);
    }

    abstract void printSelected();
}
