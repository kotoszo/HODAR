package com.aka.hodar.entities;

import com.aka.hodar.Globals;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class NPC extends Entities implements EntitiesInterface{

    private int health = 100;
    private int damage = -10;
    private int withSkill = 3;

    public NPC(Pane pane, double x, double y, int health){
        super(pane, x, y, health);
        setImage(new Image("bot.png"));

    }

    @Override
    public void printSelected() {
        System.out.println(getClass().getName());
        System.out.println(getHealth());
    }

    public void setHealth(int value) { this.health += value; }

    @Override
    public int getHealth() { return health; }

    @Override
    public int getDamage() { return damage; }

    public int withSkill() { return withSkill; }

    @Override
    public String getHealthString() { return Integer.toString(this.health); }

    @Override
    void setSkill(int skill) { this.withSkill = skill; }

    @Override
    int getSkill_1() {
        return 1;
    }

    @Override
    int getSkill_2() {
        return 2;
    }

    @Override
    int getSkill_3() {
        return 3;
    }
}
