package com.aka.hodar.entities;

import com.aka.hodar.Globals;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class NPC extends Entities {

    private int health = 100;
    private int damage = -10;

    public NPC(Pane pane, double x, double y){
        super(pane, x, y);
        setImage(new Image("bot.png"));

    }

    @Override
    void printSelected() {
        System.out.println(getClass().getName());
        System.out.println(getHealth());
    }

    public void setHealth(int value) { this.health += value; }

    @Override
    public int getHealth() { return health; }

    @Override
    int getDamage() { return this.damage; }
}
