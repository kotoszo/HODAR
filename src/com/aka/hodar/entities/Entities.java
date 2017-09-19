package com.aka.hodar.entities;

import com.aka.hodar.Globals;
import com.aka.hodar.Popup;
import com.sun.org.apache.bcel.internal.generic.POP;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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
        setOnMouseClicked(event ->  {
            handleSelection(name);
        });
        Globals.addEntitiy(this);
        //Globals.addHero(this);
    }

    // Enemy entity
    Entities(Pane pane, double x, double y, int health){
        setThingsUp(pane, x, y, health);
        setOnMouseClicked(event -> {
            if (Globals.isSelected){
                int extraDamage = 0;
                if (Globals.isSkill){
                    extraDamage = Globals.selectedEntity.withSkill();
                }
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
        //Globals.addEnemy(this);
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
            Globals.skill_1.setOnMouseClicked(event -> { updateSkillBooleanList(0); setSkill(getSkill_1());} );
            Globals.skill_1.setOnMouseEntered(event -> { Popup.showSkillInfo(event, "skill 01 és akkr igen látom szemeiimel igen", Globals.SCREEN_WIDTH, Globals.SCREEN_HEIGHT-6);});
            Globals.skill_1.setOnMouseExited(event -> { Popup.hideSkillInfo();});

            Globals.skill_2.setOnMouseClicked(event -> { updateSkillBooleanList(1); setSkill(getSkill_2()); });
            Globals.skill_2.setOnMouseEntered(event -> { Popup.showSkillInfo(event, "skill 02", 0, 0); });
            Globals.skill_2.setOnMouseExited(event -> { Popup.hideSkillInfo();});

            Globals.skill_3.setOnMouseClicked(event -> { updateSkillBooleanList(2); setSkill(getSkill_3()); });
            Globals.skill_3.setOnMouseEntered(event -> { Popup.showSkillInfo(event, "skill 03", Globals.skill_1.getX(), Globals.skill_1.getY()); });
            Globals.skill_3.setOnMouseExited(event -> { Popup.hideSkillInfo();});

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
        Globals.skill_1.setImage(new Image("images/classes/"+Globals.chosenName+"/skill_1.png"));
        Globals.skill_2.setImage(new Image("images/classes/"+Globals.chosenName+"/skill_2.png"));
        Globals.skill_3.setImage(new Image("images/classes/"+Globals.chosenName+"/skill_3.png"));
    }

    private void resetSkillStates(){
        for (int i = 0; i < Globals.isSkillList.length; i++) {
            Globals.isSkillList[i] = false;
        }
    }

    private void resetSkillImages(){
        Globals.skill_1.setImage(new Image("empty.png"));
        Globals.skill_2.setImage(new Image("empty.png"));
        Globals.skill_3.setImage(new Image("empty.png"));
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
