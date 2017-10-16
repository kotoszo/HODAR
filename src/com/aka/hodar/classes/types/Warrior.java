package com.aka.hodar.classes.types;

import com.aka.hodar.Images;
import com.aka.hodar.classes.ClassAbstract;

public class Warrior extends ClassAbstract {

    public Warrior(){
        this.className = "WARRIOR";
        this.agility = 3;
        this.intellect = 1;
        this.strength = 5;
        this.health =  250;
        this.story = "Warriors are good in close-combat.\n9/10 warriors recommend it!";
        this.image = Images.WARRIOR.getImage();
        //Skills.WARRIOR);
    }


}
