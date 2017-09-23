package com.aka.hodar.entities;

import com.aka.hodar.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;


public abstract class Entities extends ImageView {

    int health;
    int damage;
    StackPane stack;
    static int skillDamage;
    ClassTypes classType;
    protected Pane pane;

    public Entities(Pane pane, double x, double y, ClassTypes classToSet){
        setThingsUp(pane, x, y, classToSet);
        Globals.addEntitiy(this);
    }

    void setThingsUp(Pane pane, double x, double y, ClassTypes selectedClass){
        this.pane = pane;
        this.classType = selectedClass;
        this.health = selectedClass.getHealth();
        setImage(selectedClass.getImage());
        stack = setHealthBar(x, y, Integer.toString(selectedClass.getHealth()));
        pane.getChildren().addAll(this, stack);
        setX(x);setY(y);
    }

    // init and update healthbar
     StackPane setHealthBar(double x, double y, String healthString){
        stack = new StackPane();
        stack.setLayoutX(x+Globals.SKILLBAR_X); stack.setLayoutY(y-Globals.SKILLBAR_Y);
        Text health = new Text(healthString);
        ImageView tempImgView = new ImageView();
        tempImgView.setImage(Globals.healthBar);
        stack.getChildren().addAll(tempImgView, health);
        return stack;
    }

    // sets the state
     void setState(String name){
        Globals.isSelected = true;
        Globals.playerEntity = this;
        setScaleX(1.25);setScaleY(1.25);
        setSkillImages();
    }

    //resets the state
     void resetState(){
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

     void setSkillImages(){
        for (int i = 0; i < Globals.skillImages.length; i++) {
            Globals.skillImages[i].setImage(classType.getSkills().getSkillImages()[i]);
            Globals.skillImages[i].setId(Integer.toString(i));
        } }

     void resetSkillImages(){
        for (ImageView imageV: Globals.skillImages) {
            imageV.setImage(Images.EMPTY.getImage());
        } }

     void showSkillImages(){
        for (ImageView imageV: Globals.skillImages) {
            imageV.setOnMouseClicked(event -> { updateSkillBooleanList(imageV.getId()); setSkill(imageV.getId()); });
            imageV.setOnMouseEntered(event -> { Popup.showSkillInfo(event, classType.getSkillName(imageV.getId()),
                    imageV.getParent().getLayoutX()+imageV.getImage().getWidth(), Globals.SCREEN_HEIGHT-imageV.getImage().getHeight()); });
            imageV.setOnMouseExited(event -> { Popup.hideSkillInfo();});
        } }

     void resetSkillStates(){
        for (int i = 0; i < Globals.isSkillList.length; i++) {
            Globals.isSkillList[i] = false;
        } }

     void updateSkillBooleanList(String index){
        resetSkillStates();
        Globals.isSkillList[Integer.parseInt(index)] = true;
        Globals.isSkill = true;
    }

     void removeEntity(){
        Globals.removeEntity(this);
        pane.getChildren().remove(pane.getChildren().get(pane.getChildren().indexOf(stack)));
        setImage(Images.EMPTY.getImage());
    }

    public int getHealth() { return health; }
    public void setHealth(int damage) { this.health -= damage; }

    void setSkill(String skillNr){
        skillDamage = classType.getSkillDmg(Integer.parseInt(skillNr));
    }

    public ClassTypes getClassType() {
        return classType;
    }

    abstract void handleSelection();
}
