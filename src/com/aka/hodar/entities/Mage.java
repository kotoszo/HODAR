package com.aka.hodar.entities;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Mage extends Entities {

    private int health = 100;
    private int damage = -7;
    private int withSkill = -25;

    public Mage(Pane pane, double x, double y){
        super(pane, x, y, "mage");
        setImage(new Image("images/classes/mage/mage.png"));

    }

    @Override
    void printSelected() {
        System.out.println("Mage");
    }

    public void setHealth(int value) { this.health += value; }

    @Override
    public int getHealth() { return health; }

    @Override
    int getDamage() { return this.damage; }

    @Override
    int withSkill() {
        return withSkill;
    }

    @Override
    String getHealthString() {
        return Integer.toString(this.health);
    }
}
