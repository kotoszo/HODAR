package com.aka.hodar.classes;

import javafx.scene.image.Image;

public abstract class ClassAbstract implements ClassInterface {

    protected String story;
    protected String className;
    protected int health;
    protected int agility;
    protected int strength;
    protected int intellect;
    protected Image image;

    //protected ClassAbstract(){

    //}

    @Override
    public Image getImage() { return image; }

    @Override
    public int getAgility() { return agility; }

    @Override
    public int getHealth() { return health; }

    @Override
    public int getIntellect() { return intellect; }

    @Override
    public int getStrength() { return strength; }

    @Override
    public String getClassName() { return className; }

    @Override
    public String getStory() { return story; }

    @Override
    public void setHealth(int healthPoints) { this.health += healthPoints; }

    @Override
    public void setAgility(int agilityPoints) { this.agility += agilityPoints; }

    @Override
    public void setIntellect(int intellectPoints) { this.intellect += intellectPoints; }

    @Override
    public void setStrength(int strengthPoints) { this.strength += strengthPoints; }
}
