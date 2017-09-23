package com.aka.hodar.Animator;

import com.aka.hodar.Globals;
import com.aka.hodar.entities.Entities;

public class Arena {

    static double x = 0;
    static double forward = 100;
    static double backward = 10;

    public static void FIGHT(){
        int skillIndex = Globals.random.nextInt(3);
        Globals.playerEntity.setHealth(Globals.enemyEntity.getClassType().getSkillDmg(skillIndex));
        Globals.playerEntity.updateHealthBar();
        Globals.usedSkillString = Globals.enemyEntity.getClassType().getSkillName(skillIndex);
        Globals.game.showUsedSkill();
        Globals.gameLoop.start();
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
        //Globals.game.showUsedSkill();
        if (entity.equals(Globals.playerEntity)){
            if (entity.getBoundsInParent().getMinX() <= Globals.PLAYER_X){
                handleTurn();
                Globals.gameLoop.stop();
                Globals.game.hideUsedSkill();
                Arena.FIGHT();
            }
            x -= backward;

        } else {
            if (entity.getBoundsInParent().getMinX() == Globals.ENEMY_X){
                handleTurn();
                Globals.gameLoop.stop();
                Globals.game.hideUsedSkill();
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
