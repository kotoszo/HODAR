package com.aka.hodar;

import javafx.scene.image.Image;

public enum Skills {
    WARRIOR("Basic Attack", 5 ,"Mortal Strike", 10, "Hundred Blades", 20, new Image("images/classes/warrior/skill_1.png"),
            new Image("images/classes/warrior/skill_2.png"), new Image("images/classes/warrior/skill_3.png")),
    MAGE("Basic Attack", 2, "Arcane Bolt", 15, "Arcane Cannon", 25, new Image("images/classes/mage/skill_1.png"),
            new Image("images/classes/mage/skill_2.png"), new Image("images/classes/mage/skill_3.png"));

    private int skill01Dmg;
    private int skill02Dmg;
    private int skill03Dmg;
    private String skill01Name;
    private String skill02Name;
    private String skill03Name;
    private Image skill01Img;
    private Image skill02Img;
    private Image skill03Img;

    Skills(String skill01Name, int skill01Dmg, String skill02Name, int skill02Dmg,
           String skill03Name, int skill03Dmg, Image skill01Img, Image skill02Img, Image skill03Img){
        this.skill01Img = skill01Img;
        this.skill01Dmg = skill01Dmg;
        this.skill01Name = skill01Name;

        this.skill02Img = skill02Img;
        this.skill02Dmg = skill02Dmg;
        this.skill02Name = skill02Name;

        this.skill03Img = skill03Img;
        this.skill03Dmg = skill03Dmg;
        this.skill03Name = skill03Name;
    }

    public String getSkill01Name() { return skill01Name; }

    public int getSkill01Dmg() { return skill01Dmg; }

    public String getSkill02Name() { return skill02Name; }

    public int getSkill02Dmg() { return skill02Dmg; }

    public String getSkill03Name() { return skill03Name; }

    public int getSkill03Dmg() { return skill03Dmg; }

    public Image[] getSkillImages(){
        return new Image[]{skill01Img, skill02Img, skill03Img};
    }

    public String[] getSkillNames(){
        return new String[]{skill01Name, skill02Name, skill03Name};
    }
}
