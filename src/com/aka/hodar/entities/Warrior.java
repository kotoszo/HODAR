package com.aka.hodar.entities;

import com.aka.hodar.Globals;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Warrior extends Entities implements EntitiesInterface{

    private int health = 100;
    private int damage = -50;
    private int withSkill = -2;

    public Warrior(Pane pane, double x, double y, int health){
        super(pane, x ,y, "warrior", health);
        setImage(new Image("images/classes/warrior/warrior.png"));
        this.health = health;

    }

    @Override
    public void printSelected() {
        System.out.println("Warrior");
    }

    public void setHealth(int value) { this.health += value; }

    @Override
    public int getHealth() { return this.health; }

    @Override
    public int getDamage() { return this.damage; }


    public int withSkill() { return withSkill; }

    @Override
    public String getHealthString() { return Integer.toString(this.health); }

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
