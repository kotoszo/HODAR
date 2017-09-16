package com.aka.hodar.entities;

import com.aka.hodar.Globals;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Warrior extends Entities {

    private int health;
    private int damage = -50;

    public Warrior(Pane pane, double x, double y, int health){
        super(pane, x ,y, "warrior");
        setImage(new Image("images/classes/warrior/warrior.png"));
        this.health = health;
    }

    @Override
    void printSelected() {
        System.out.println("Warrior");
    }

    public void setHealth(int value) { this.health += value; }

    @Override
    public int getHealth() { return this.health; }

    @Override
    public int getDamage() { return this.damage; }
}
