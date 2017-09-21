package com.aka.hodar;

import javafx.scene.image.Image;

public enum ClassTypes {

    WARRIOR("WARRIOR", 3, 1, 5, 250, "Warriors are good in close-combat.\n9/10 warriors recommend it!", Images.WARRIOR.getImage(), Skills.WARRIOR),
    MAGE("MAGE", 3, 5, 1, 150, "Mages are well known magic users.\nThey can deal big amount of damage.", Images.MAGE.getImage(), Skills.MAGE),
    PIRATE("Pirate", 4, 1, 4, 200, null, Images.PIRATE.getImage(), null),
    DRUID("Druid", 4, 3, 2, 225, "Druids are friends of mother nature.\nasd", Images.DRUID.getImage(), null),
    PEASENT("Peasent", 4, 1, 4, 200, "Peasent are well known for nothing.\n But, they can achive something.", Images.PEASENT.getImage(), null),
    WIZARD("Wizard", 1, 7, 1, 175, "Wizards are rare, just like a bubblegum\n... in the middle ages.", Images.WIZARD.getImage(), null),
    THIEF("Thief", 6, 2, 1, 0,"Thieves are weaks in mid-ranged combat.\n But deadly in close-combat.", Images.THIEF.getImage(), null),
    MARTIAL("Martial Artist", 4, 2, 3, 0, "Martial artists are using first weapons\n..or barehanded.", Images.MARTIAL.getImage(), null);

    private int health;
    private Image image;
    private int agility;
    private String story;
    private int strength;
    private int intellect;
    private String className;
    private Skills skills;

    ClassTypes(String className, int agility ,int intellect,int strength,int health, String story, Image image, Skills skills) {
        this.story = story;
        this.image = image;
        this.health = health;
        this.skills = skills;
        this.agility = agility;
        this.strength = strength;
        this.intellect = intellect;
        this.className = className;
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

    public Skills getSkills() { return skills; }

    public int getSkillDmg(int index) {
        int dmg = 0;
        switch (index){
            case 0:
                dmg = skills.getSkill01Dmg();break;
            case 1:
                dmg = skills.getSkill02Dmg();break;
            case 2:
                dmg = skills.getSkill03Dmg();break;
        }
        System.out.println(dmg);
        return dmg;
    }
    public String getSkillName(String index){
        return getSkillName(Integer.parseInt(index));
    }

    public String getSkillName(int index) {
        String name = "";
        switch (index){
            case 0:
                name = skills.getSkill01Name();break;
            case 1:
                name = skills.getSkill02Name();break;
            case 2:
                name = skills.getSkill03Name();break;
        }
        return name;
    }

}
