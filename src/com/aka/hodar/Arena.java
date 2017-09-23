package com.aka.hodar;

import com.aka.hodar.entities.Entities;

public class Arena {

    static double x = 0;
    static double forward = 100;
    static double backward = 10;

    public static void FIGHT(){
        int skillIndex = Globals.random.nextInt(3);
        Globals.playerEntity.setHealth(Globals.enemyEntity.getClassType().getSkillDmg(skillIndex));
        Globals.playerEntity.updateHealthBar();
    }

    public static void step(Entities entity){
        if (entity.equals(Globals.playerEntity)){
            x += forward;
            if (entity.getBoundsInParent().intersects(Globals.enemyEntity.getBoundsInParent())){
                Globals.isCharge = !Globals.isCharge;
            }
        } else {
            x -= forward;
            if (entity.getBoundsInParent().intersects(Globals.playerEntity.getBoundsInParent())){
                Globals.isCharge = !Globals.isCharge;
            }
        }
        entity.setTranslateX(x);
    }

    public static void stepBack(Entities entity){
        if (entity.equals(Globals.playerEntity)){
            if (entity.getBoundsInParent().getMinX() <= Globals.PLAYER_X){
                handleTurn();
                Arena.FIGHT();
            }
            x -= backward;

        } else {
            if (entity.getBoundsInParent().getMinX() == Globals.ENEMY_X){
                handleTurn();
                Globals.gameLoop.stop();
            }
            x += backward;
        }
        entity.setTranslateX(x);
    }

    private static void handleTurn(){
        Globals.isCharge = !Globals.isCharge;
        Globals.isMoving = !Globals.isMoving;
    }
}
