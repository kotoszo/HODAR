package com.aka.hodar;

import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {

    @Override
    public void handle(long now) {
        if (Globals.isMoving){
            if (Globals.isCharge){
                Arena.step(Globals.playerEntity);
            } else {
                Arena.stepBack(Globals.playerEntity);
            }
        } else {
            if (Globals.isCharge){
                Arena.step(Globals.enemyEntity);
            } else {
                Arena.stepBack(Globals.enemyEntity);
            }
        }
    }
}
