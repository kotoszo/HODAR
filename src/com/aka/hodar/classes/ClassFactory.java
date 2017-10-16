package com.aka.hodar.classes;

import com.aka.hodar.classes.types.Mage;
import com.aka.hodar.classes.types.Warrior;

public class ClassFactory {

    public Warrior createWarrior(){ return new Warrior(); }

    public Mage createMage(){ return new Mage(); }
}
