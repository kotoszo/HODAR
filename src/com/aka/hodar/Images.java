package com.aka.hodar;

import javafx.scene.image.Image;

public enum Images {

    // MISC
    EMPTY(new Image("empty.png")),
    HEALTHBAR(new Image("healthbar.png")),
    //  Backgrounds 1280*720
    BG_BASIC(new Image("images/bg/basic.jpg")),

    // Good guys
    WARRIOR(new Image("images/classes/warrior/warrior.png")),
    MAGE(new Image("images/classes/mage/mage.png")),
    PIRATE(new Image("images/classes/pirate/pirate.png")),
    DRUID(new Image("images/classes/druid/druid.png")),
    PEASENT(new Image("images/classes/peasent/peasent.png")),
    WIZARD(new Image("images/classes/wizard/wizard.png")),
    THIEF(new Image("images/classes/thief/thief.png")),
    MARTIAL(new Image("images/classes/martial/martial.png")),

    // Bad guys
    ORC1(new Image("images/enemies/orc/1.png")),
    ORC2(new Image("images/enemies/orc/2.png")),
    ORC3(new Image("images/enemies/orc/3.png")),
    TROLL1(new Image("images/enemies/troll/1.png")),
    TROLL2(new Image("images/enemies/troll/2.png")),
    TROLL3(new Image("images/enemies/troll/3.png")),
    ZOOMBIE1(new Image("images/enemies/zombie/1.png")),
    ZOOMBIE2(new Image("images/enemies/zombie/2.png")),
    ZOOMBIE3(new Image("images/enemies/zombie/3.png")),

    // Skills
    BASIC_ATTACK(new Image("images/classes/warrior/skill_1.png")),
    MORTAL_STRIKE(new Image("images/classes/warrior/skill_2.png")),
    HUNDRED_BLADES(new Image("images/classes/warrior/skill_3.png")),
    ARCANE_BOLT(new Image("images/classes/mage/skill_2.png")),
    ARCANE_CANNON(new Image("images/classes/mage/skill_3.png")),
//    PRIZE_CUT(new Image("")),
   // JACKPOT(new Image("")),

    // MainMenu
    LEFT_ARROW(new Image("images/left_arrow.png")),
    RIGHT_ARROW(new Image("images/right_arrow.png"));

    private Image image;

    Images(Image image ){ this.image = image; }

    public Image getImage() { return image; }
}
