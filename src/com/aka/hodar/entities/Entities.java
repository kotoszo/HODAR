package com.aka.hodar.entities;

import com.aka.hodar.Globals;
import com.aka.hodar.Popup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;


public abstract class Entities extends ImageView implements EntitiesInterface{

    protected Pane pane;
    StackPane stack;
    Tooltip toltip = new Tooltip();

    // player entity
    Entities(Pane pane, double x, double y, String name, int health){
        setThingsUp(pane, x, y, health);
        setOnMouseClicked(event ->  { handleSelection(name); });
        Globals.addEntitiy(this);
    }

    // Enemy entity
    Entities(Pane pane, double x, double y, int health){
        setThingsUp(pane, x, y, health);
        setOnMouseClicked(event -> {
            if (Globals.isSelected){
                int extraDamage = 0;
                if (Globals.isSkill) extraDamage = Globals.selectedEntity.withSkill();

                setHealth(Globals.selectedEntity.getDamage()+extraDamage);
                printSelected();
                updateHealthBar();
                Globals.isSkill = false;
                if (getHealth() <= 0){ removeEntity(); }
                System.out.println(Globals.entitiesList);

            } else {
                System.out.println("First, select one of your characters");
            }
        });
        Globals.addEntitiy(this);
    }

    private void setThingsUp(Pane pane, double x, double y, int health){
        this.pane = pane;
        stack = healthBar(x, y, Integer.toString(health));
        pane.getChildren().addAll(this, stack);
        setX(x);setY(y);
    }

    //Friendly selection for heal/buff
    private void handleSelection(String name){
        if (Globals.chosenName == null){
            setState(name);
            resetSkillStates();
            for (ImageView imageV: Globals.skillImages) { // should do everything from one method and with the ID can decide what where how etc
                imageV.setOnMouseClicked(event -> { updateSkillBooleanList(Integer.parseInt(imageV.getId())); setSkill(getSkill_1());});
                imageV.setOnMouseEntered(event -> { Popup.showSkillInfo(event, "skill 01 és akkr igen látom szemeiimel igen", Globals.SCREEN_WIDTH, Globals.SCREEN_HEIGHT-6);});
                imageV.setOnMouseExited(event -> { Popup.hideSkillInfo();});
            }
        } else {
            if (name.equals(Globals.chosenName)){
                setImage(new Image("images/classes/"+Globals.chosenName+"/"+Globals.chosenName+".png"));
                resetState();
            } else {
                Globals.selectedEntity.setImage(new Image("images/classes/"+Globals.chosenName+"/"+Globals.chosenName+".png"));
                resetState();
                setState(name);
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
        Globals.chosenName = name;
        setImage(new Image("p1.png"));
        setSkillImages();
    }

    //resets the state
    private void resetState(){
        Globals.chosenName = null;
        Globals.isSelected = false;
        Globals.selectedEntity = null;
        resetSkillImages();
        resetSkillStates();
    }

    // removes the healthbar node (stackpane) and creates the new one
    private void updateHealthBar(){
        pane.getChildren().remove(pane.getChildren().get(pane.getChildren().indexOf(stack)));
        pane.getChildren().add(healthBar(getX(), getY(), getHealthString()));
    }

    private void setSkillImages(){
        String path = "images/classes/";
        String skill = "/skill_";
        String png = ".png";
        for (int i = 0; i < Globals.skillImages.length; i++) {
            Globals.skillImages[i].setImage(new Image(path + Globals.chosenName + skill + (i+1) + png));
        }
    }

    private void resetSkillStates(){
        for (int i = 0; i < Globals.isSkillList.length; i++) {
            Globals.isSkillList[i] = false;
        }
    }

    private void resetSkillImages(){
        for (ImageView imageV: Globals.skillImages) {
            imageV.setImage(new Image("empty.png"));
        }
    }

    private void updateSkillBooleanList(int index){
        resetSkillStates();
        Globals.isSkillList[index] = true;
        Globals.isSkill = true;
    }

    private void removeEntity(){
        Globals.removeEntity(this);
        pane.getChildren().remove(pane.getChildren().get(pane.getChildren().indexOf(stack)));
        setImage(new Image("empty.png"));
    }

    abstract void setSkill(int skillNr);

    abstract int getSkill_1();
    abstract int getSkill_2();
    abstract int getSkill_3();
}
