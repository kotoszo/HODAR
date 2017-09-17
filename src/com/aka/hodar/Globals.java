package com.aka.hodar;

import com.aka.hodar.entities.Entities;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.*;

public class Globals {

    public static final double SCREEN_WIDTH = 1280;
    public static final double SCREEN_HEIGHT = 720;

    public static String chosenName;
    public static boolean isSelected;
    public static boolean isSkill;
    public static boolean[] isSkillList = new boolean[3];

    public static List<Entities> enemies;
    public static List<Entities> heroes;
    public static Entities selectedEntity;

    /*
    Should contain 3 different images, each of them is clickable.
     */
    public static ImageView skill_1 = new ImageView();
    public static ImageView skill_2 = new ImageView();
    public static ImageView skill_3 = new ImageView();
    public static ImageView[] skillImageList = new ImageView[]{skill_1, skill_2, skill_3};

    public static StackPane skillPane_1 = new StackPane();
    public static StackPane skillPane_2 = new StackPane();
    public static StackPane skillPane_3 = new StackPane();
    public static StackPane[] skillPaneList = new StackPane[]{skillPane_1, skillPane_2, skillPane_3};

    static {
        enemies = new LinkedList<>();
        heroes = new LinkedList<>();
    }

    // Images
    public static Image healthBar = new Image("healthbar.png");

    public static void addHero(Entities entity){
        heroes.add(entity);
    }
    public static void addEnemy(Entities entity){
        enemies.add(entity);
    }
}
