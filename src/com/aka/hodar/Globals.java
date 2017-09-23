package com.aka.hodar;

import com.aka.hodar.Animator.GameLoop;
import com.aka.hodar.entities.ClassTypes;
import com.aka.hodar.entities.Entities;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.*;

public class Globals {

    public static final double SCREEN_WIDTH = 1280;
    public static final double SCREEN_HEIGHT = 720;

    public static Game game;

    public static final double PLAYER_X = 0;
    public static final double ENEMY_X = Globals.SCREEN_WIDTH-350;
    public static final double COMMON_Y = 275;

    public static final double SKILLBAR_X = 25;
    public static final double SKILLBAR_Y = 12;

    public static boolean isMoving = true;
    public static boolean isCharge;
    public static boolean isSelected;
    public static boolean isSkill;
    public static boolean[] isSkillList = new boolean[3];

    public static List<Entities> entitiesList;
    public static Entities playerEntity;
    public static Entities enemyEntity;

    public static ClassTypes enemyClass;
    public static Stage primaryStage;
    public static Tooltip skillInfo;
    public static StackPane usedSkillPane;
    public static Text usedSkillText;
    public static String usedSkillString;

    public static Random random = new Random();

    public static ImageView[] skillImages = new ImageView[3];

    public static StackPane[] skillPaneList = new StackPane[3];

    public static GameLoop gameLoop;

    static {
        entitiesList = new LinkedList<>();
    }

    public static Image healthBar = Images.HEALTHBAR.getImage();

    public static void addEntitiy(Entities entity){
        entitiesList.add(entity);
    }
    public static void removeEntity(Entities entity){ entitiesList.remove(entity); }
}
