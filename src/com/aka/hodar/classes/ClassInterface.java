package com.aka.hodar.classes;

import javafx.scene.image.Image;

public interface ClassInterface {

    // All the getters
    Image getImage();
    String getStory();
    String getClassName();
    int getHealth();
    int getAgility();
    int getStrength();
    int getIntellect();

    // All the setters for levelup
    void setAgility(int points);
    void setIntellect(int points);
    void setStrength(int points);

    // All the setters for action (like fight/heal stb)
    void setHealth(int incoming);

    //Skills getSkills();
}
