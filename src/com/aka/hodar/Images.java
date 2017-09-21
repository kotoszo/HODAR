package com.aka.hodar;

import javafx.scene.image.Image;

public enum Images {
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
    ZOOMBIE3(new Image("images/enemies/zombie/3.png"));

    private Image image;

    Images(Image image ){ this.image = image; }

    public Image getImage() { return image; }
}
