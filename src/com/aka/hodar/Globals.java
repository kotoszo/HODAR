package com.aka.hodar;

import com.aka.hodar.entities.Entities;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.*;

public class Globals {

    public static final double SCREEN_WIDTH = 1280;
    public static final double SCREEN_HEIGHT = 720;

    public static final double SKILLBAR_X = 25;
    public static final double SKILLBAR_Y = 12;

    public static String chosenName;
    public static boolean isSelected;
    public static boolean isSkill;
    public static boolean[] isSkillList = new boolean[3];

    public static List<Entities> entitiesList;
    public static Entities selectedEntity;
    public static Stage primaryStage;
    public static Tooltip skillInfo;

    public static final Image pirateImage = new Image("bot.png");
    public static final Image warriorImage = new Image("images/classes/warrior/warrior.png");
    public static final Image mageImage = new Image("images/classes/mage/mage.png");

    /*
    Should contain 3 different images, each of them is clickable.
     */
    public static ImageView[] skillImages = new ImageView[3];

    public static StackPane[] skillPaneList = new StackPane[3];//{skillPane_1, skillPane_2, skillPane_3};

    static {
        entitiesList = new LinkedList<>();
    }

    // Images
    public static Image healthBar = new Image("healthbar.png");

    public static void addEntitiy(Entities entity){
        entitiesList.add(entity);
    }
    public static void removeEntity(Entities entity){ entitiesList.remove(entity); }
}
