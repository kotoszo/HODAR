package com.aka.hodar.classes.types;

import com.aka.hodar.Images;
import com.aka.hodar.classes.ClassAbstract;

public class Mage extends ClassAbstract {

    public Mage(){
        this.className = "Mage";
        this.agility = 3;
        this.intellect = 5;
        this.strength = 1;
        this.health = 150;
        this.story = "Mages are well known magic users.\nThey can deal big amount of damage.";
        this.image = Images.MAGE.getImage();
    }
}
