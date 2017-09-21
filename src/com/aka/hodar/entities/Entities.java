package com.aka.hodar.entities;

import com.aka.hodar.ClassTypes;
import com.aka.hodar.Globals;
import com.aka.hodar.Popup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;


public abstract class Entities extends ImageView implements EntitiesInterface{

    int health;
    int damage;
    StackPane stack;
    static int skillDamage;
    ClassTypes classType;
    protected Pane pane;

    // player entity
    Entities(Pane pane, double x, double y, ClassTypes classType){
        setThingsUp(pane, x, y, classType);
        setOnMouseClicked(event ->  { handleSelection(classType.getClassName()); });
        Globals.addEntitiy(this);
    }

    // Enemy entity
    Entities(Pane pane, double x, double y){
        setThingsUp(pane, x, y, ClassTypes.MAGE);
        setOnMouseClicked(event -> {
            if (Globals.isSelected){
                if (Globals.isSkill){
                    setHealth(skillDamage);
                    updateHealthBar();
                    Globals.isSkill = false;
                    if (getHealth() <= 0){ removeEntity(); }
                }
            } else {
                System.out.println("First, select one of your characters");
            }
        });
        Globals.addEntitiy(this);
    }

    private void setThingsUp(Pane pane, double x, double y, ClassTypes classType){
        this.pane = pane;
        this.classType = classType;
        this.health = classType.getHealth();
        stack = healthBar(x, y, Integer.toString(classType.getHealth()));
        pane.getChildren().addAll(this, stack);
        setX(x);setY(y);
    }

    // self and friendly selection for heal/buff
    private void handleSelection(String name){
        if (Globals.chosenEntity == null){
            setState(name);
            resetSkillStates();
            showSkillImages();
        } else {
            if (name.equals(Globals.chosenEntity.getClassName())){
                setScaleX(1);setScaleY(1);
                resetState();
            } else {
                Globals.selectedEntity.setScaleX(1);Globals.selectedEntity.setScaleY(1);
                Globals.selectedEntity.setImage(Globals.chosenEntity.getImage());
                resetState();
                setState(name);
                showSkillImages();
            }
            Globals.isSkill = false;
        }
    }
    // init and update healthbar
    private StackPane healthBar(double x, double y, String healthString){
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
        Globals.selectedEntity = this;
        Globals.chosenEntity = Globals.selectedEntity.getClassType();
        setScaleX(1.25);setScaleY(1.25);
        setSkillImages();
    }

    //resets the state
    private void resetState(){
        Globals.chosenEntity = null;
        Globals.isSelected = false;
        Globals.selectedEntity = null;
        Globals.chosenEntity = null;
        resetSkillImages();
        resetSkillStates();
    }

    // removes the healthbar node (stackpane) and creates the new one
    private void updateHealthBar(){
        pane.getChildren().remove(pane.getChildren().get(pane.getChildren().indexOf(stack)));
        pane.getChildren().add(healthBar(getX(), getY(), Integer.toString(getHealth())));
    }

    private void setSkillImages(){
        for (int i = 0; i < Globals.skillImages.length; i++) {
            Globals.skillImages[i].setImage(classType.getSkills().getSkillImages()[i]);
            Globals.skillImages[i].setId(Integer.toString(i));
        }
    }

    private void resetSkillImages(){
        for (ImageView imageV: Globals.skillImages) {
            imageV.setImage(new Image("empty.png"));
        }
    }

    private void showSkillImages(){
        for (ImageView imageV: Globals.skillImages) { // should do everything from one method and with the ID can decide what where how etc
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
        setImage(new Image("empty.png"));
    }

    private int getHealth() { return health; }
    public void setHealth(int damage) { this.health -= damage; }

    public int getDamage() { return damage; }

    void setSkill(String skillNr){
        skillDamage = classType.getSkillDmg(Integer.parseInt(skillNr));
    }

    public ClassTypes getClassType() {
        return classType;
    }
}
