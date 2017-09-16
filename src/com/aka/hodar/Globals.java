package com.aka.hodar;

import com.aka.hodar.entities.Entities;
import javafx.scene.image.ImageView;

import java.util.*;

public class Globals {

    public static final double SCREEN_WIDTH = 1280;
    public static final double SCREEN_HEIGHT = 720;

    public static String chosenName;
    public static boolean isSelected;
    public static boolean isSkill;

    public static List<Entities> enemies;
    public static List<Entities> heroes;
    public static Entities selectedEntity;

    /*
    Should contain 3 different images, each of them is clickable.
     */
    public static ImageView skillset;

    static {
        enemies = new LinkedList<>();
        heroes = new LinkedList<>();
    }

    public static void addHero(Entities entity){
        heroes.add(entity);
    }
    public static void addEnemy(Entities entity){
        enemies.add(entity);
    }
}
