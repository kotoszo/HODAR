package com.aka.hodar.entities;

import com.aka.hodar.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;


public class Entities extends ImageView {
    //public abstract class Entities extends ImageView implements EntitiesInterface{

    int health;
    int damage;
    StackPane stack;
    static int skillDamage;
    ClassTypes classType;
    protected Pane pane;

    // player entity
    public Entities(Pane pane, double x, double y, ClassTypes selectedClass){
        setThingsUp(pane, x, y, selectedClass);
        setOnMouseClicked(event ->  { handlePlayerSelection(selectedClass.getClassName()); });
        Globals.addEntitiy(this);
    }

    // Enemy entity
    public Entities(Pane pane, double x, double y){
        setScaleX(-1);
        setThingsUp(pane, x, y, Globals.enemyClass);
        setOnMouseClicked(event -> { handleEnemySelection(); });
        Globals.addEntitiy(this);
    }

    private void setThingsUp(Pane pane, double x, double y, ClassTypes selectedClass){
        this.pane = pane;
        this.classType = selectedClass;
        this.health = selectedClass.getHealth();
        setImage(selectedClass.getImage());
        stack = setHealthBar(x, y, Integer.toString(selectedClass.getHealth()));
        pane.getChildren().addAll(this, stack);
        setX(x);setY(y);
    }

    // self and friendly selection for heal/buff
    private void handlePlayerSelection(String name){
        if(Globals.playerEntity == null){
            setState(name);
            resetSkillStates();
            showSkillImages();
        } else {
            if (name.equals(Globals.playerEntity.getClassType().getClassName())){
                setScaleX(1);setScaleY(1);
                resetState();
            } else {
                Globals.playerEntity.setScaleX(1);Globals.playerEntity.setScaleY(1);
                Globals.playerEntity.setImage(Globals.playerEntity.getClassType().getImage());
                resetState();
                setState(name);
                showSkillImages();
            }
            Globals.isSkill = false;
        }
    }

    private void handleEnemySelection(){
        if (Globals.isSelected){
            if (Globals.isSkill){
                Globals.gameLoop.start();
                Globals.isCharge = true; Globals.isMoving = true;
                setHealth(skillDamage);
                updateHealthBar();
                Globals.isSkill = false;
                if (getHealth() <= 0){ removeEntity(); }
            }
        } else {
            System.out.println("First, select one of your characters");
        }
    }
    // init and update healthbar
    private StackPane setHealthBar(double x, double y, String healthString){
        stack = new StackPane();
        stack.setLayoutX(x+Globals.SKILLBAR_X); stack.setLayoutY(y-Globals.SKILLBAR_Y);
        Text health = new Text(healthString);
        ImageView tempImgView = new ImageView();
        tempImgView.setImage(Globals.healthBar);
        stack.getChildren().addAll(tempImgView, health);
        return stack;
    }

    // sets the state
    private void setState(String name){
        Globals.isSelected = true;
        Globals.playerEntity = this;
        setScaleX(1.25);setScaleY(1.25);
        setSkillImages();
    }

    //resets the state
    private void resetState(){
        Globals.isSelected = false;
        Globals.playerEntity = null;
        resetSkillImages();
        resetSkillStates();
    }

    // removes the healthbar node (stackpane) and creates the new one
    public void updateHealthBar(){
        pane.getChildren().remove(pane.getChildren().get(pane.getChildren().indexOf(stack)));
        pane.getChildren().add(setHealthBar(getX(), getY(), Integer.toString(getHealth())));
    }

    private void setSkillImages(){
        for (int i = 0; i < Globals.skillImages.length; i++) {
            Globals.skillImages[i].setImage(classType.getSkills().getSkillImages()[i]);
            Globals.skillImages[i].setId(Integer.toString(i));
        }
    }

    private void resetSkillImages(){
        for (ImageView imageV: Globals.skillImages) {
            imageV.setImage(Images.EMPTY.getImage());
        }
    }

    private void showSkillImages(){
        for (ImageView imageV: Globals.skillImages) {
            imageV.setOnMouseClicked(event -> { updateSkillBooleanList(imageV.getId()); setSkill(imageV.getId()); });
            imageV.setOnMouseEntered(event -> { Popup.showSkillInfo(event, classType.getSkillName(imageV.getId()),
                    Globals.SCREEN_WIDTH, Globals.SCREEN_HEIGHT-6);});
            imageV.setOnMouseExited(event -> { Popup.hideSkillInfo();});
        }
    }

    private void resetSkillStates(){
        for (int i = 0; i < Globals.isSkillList.length; i++) {
            Globals.isSkillList[i] = false;
        }
    }

    private void updateSkillBooleanList(String index){
        resetSkillStates();
        Globals.isSkillList[Integer.parseInt(index)] = true;
        Globals.isSkill = true;
    }

    private void removeEntity(){
        Globals.removeEntity(this);
        pane.getChildren().remove(pane.getChildren().get(pane.getChildren().indexOf(stack)));
        setImage(Images.EMPTY.getImage());
    }

    public int getHealth() { return health; }
    public void setHealth(int damage) { this.health -= damage; }

    public int getDamage() { return damage; }

    void setSkill(String skillNr){
        skillDamage = classType.getSkillDmg(Integer.parseInt(skillNr));
    }

    public ClassTypes getClassType() {
        return classType;
    }
}
