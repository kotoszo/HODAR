package com.aka.hodar.entities;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Mage extends Entities {

    private int health = 100;
    private int damage = -7;
    private int withSkill = -25;

    public Mage(Pane pane, double x, double y, int health){
        super(pane, x, y, "mage", health);
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
