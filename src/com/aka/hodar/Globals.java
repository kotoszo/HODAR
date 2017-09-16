package com.aka.hodar;

import com.aka.hodar.entities.Entities;
import javafx.scene.image.ImageView;

import java.util.LinkedList;
import java.util.List;

public class Globals {

    public static final double SCREEN_WIDTH = 1280;
    public static final double SCREEN_HEIGHT = 720;

    public static String chosenName;
    public static boolean isSelected;

    public static List<Entities> enemies;
    public static List<Entities> heroes;
    public static Entities selectedEntity;

    public static ImageView skillset;

    public static List<Entities> entitiesList;

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
