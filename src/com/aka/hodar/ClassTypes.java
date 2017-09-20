package com.aka.hodar;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public enum ClassTypes {

    WARRIOR("Warrior", 3, 1, 5, 125, "Warriors are good in close-combat.\n9/10 warriors recommend it!", new Image("images/classes/warrior/warrior.png")),
    MAGE("Mage", 3, 5, 1, 150, "Mages are well known magic users.\nThey can deal big amount of damage.", new Image("images/classes/mage/mage.png"));

    private String className;
    private int agility;
    private int intellect;
    private int strength;
    private int health;
    private String story;
    private Image image;

    ClassTypes(String className, int agility ,int intellect,int strength,int health, String story, Image image) {
        this.className = className;
        this.agility = agility;
        this.intellect = intellect;
        this.strength = strength;
        this.health = health;
        this.story = story;
        this.image = image;
    }

    public String getClassName() {
        return className;
    }

    public int getAgility() { return agility; }

    public int getIntellect() { return intellect; }

    public int getStrength() { return strength; }

    public int getHealth() { return health; }

    public String getStory() { return story; }

    public Image getImage() { return image; }

    public Map<String, String> getMap(){
        Map<String, String> map = new HashMap();
        map.put("Classname", className);
        map.put("Agility", Integer.toString(agility));
        map.put("Intellect", Integer.toString(intellect));
        map.put("Strength", Integer.toString(strength));
        map.put("Health", Integer.toString(health));
        return map;
    }

    //, ROGUE("rogue"), PALADIN("paladin"), PRIEST("priest"), WARLOCK("warlock");

}
