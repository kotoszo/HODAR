package com.aka.hodar.entities;

import com.aka.hodar.Globals;
import javafx.scene.layout.Pane;

public class Enemy extends Entities {

    public Enemy(Pane pane, double x, double y){
        super(pane, x, y, Globals.enemyClass);
        setScaleX(-1);
        setOnMouseClicked(event -> { handleSelection(); });
    }

    @Override
    void handleSelection() {
        if (Globals.isSelected){
            if (Globals.isSkill){
                Globals.gameLoop.start();
                Globals.isCharge = true; Globals.isMoving = true;
                setHealth(skillDamage);
                updateHealthBar();
                Globals.isSkill = false;
                if (getHealth() <= 0){ removeEntity(); }
            }
        } else {
            System.out.println("First, select one of your characters");
        }
    }
}
