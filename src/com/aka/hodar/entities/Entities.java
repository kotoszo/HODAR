package com.aka.hodar.entities;

import com.aka.hodar.Globals;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;


public abstract class Entities extends ImageView {

    protected Pane pane;
    StackPane stack;


    // player entity
    Entities(Pane pane, double x, double y, String name, int health){
        this.pane = pane;
        stack = healthBar(x, y, Integer.toString(health));
        pane.getChildren().addAll(this, stack);
        setX(x);setY(y);
        setOnMouseClicked(event ->  {
            handleSelection(name);
        });
        Globals.addHero(this);
    }

    // Enemy entity
    Entities(Pane pane, double x, double y, int health){
        this.pane = pane;
        stack = healthBar(x, y, Integer.toString(health));
        pane.getChildren().addAll(this, stack);
        setX(x);setY(y);
        setOnMouseClicked(event -> {
            for (boolean skill: Globals.isSkillList) {
                System.out.println(skill);
            }
            if (Globals.isSelected){
                int extraDamage = 0;
                if (Globals.isSkill){
                    extraDamage = Globals.selectedEntity.withSkill();
                }
                setHealth(Globals.selectedEntity.getDamage()+extraDamage);
                printSelected();
                updateHealthBar();
                Globals.isSkill = false;

            } else {
                System.out.println("First, select one of your characters");
            }
        });
        Globals.addEnemy(this);
    }

    //Friendly selection for heal/buff
    private void handleSelection(String name){
        if (Globals.chosenName == null){
            setState(name);
            resetSkillStates();
            Globals.skill_1.setOnMouseClicked(event -> { updateSkillBooleanList(0); });

            Globals.skill_2.setOnMouseClicked(event -> { updateSkillBooleanList(1); });

            Globals.skill_3.setOnMouseClicked(event -> { updateSkillBooleanList(2); });

        } else {
            if (name == Globals.chosenName){
                setImage(new Image("images/classes/"+Globals.chosenName+"/"+Globals.chosenName+".png"));
                resetState();
            } else {
                setHealth(50);
                updateHealthBar();
            }
            Globals.isSkill = false;
        }
    }
    // init and update healthbar
    private StackPane healthBar(double x, double y, String healthString){
        stack = new StackPane();
        stack.setLayoutX(x+25); stack.setLayoutY(y-12);
        Text health = new Text(healthString);
        ImageView asd = new ImageView();
        asd.setImage(Globals.healthBar);
        stack.getChildren().addAll(asd, health);
        return stack;
    }

    // sets the state
    private void setState(String name){
        Globals.isSelected = true;
        Globals.selectedEntity = this;
        Globals.chosenName = name;
        setImage(new Image("p1.png"));
        setSkillSet();
    }

    //resets the state
    private void resetState(){
        Globals.chosenName = null;
        Globals.isSelected = false;
        Globals.selectedEntity = null;
        resetSkillImages();
        resetSkillStates();
    }

    // removes and the healthbar node (stackpane) and creates the new one
    private void updateHealthBar(){
        pane.getChildren().remove(pane.getChildren().get(pane.getChildren().indexOf(stack)));
        pane.getChildren().add(healthBar(getX(), getY(), getHealthString()));
    }

    private void setSkillSet(){
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
    }

    abstract int getHealth();
    abstract int getDamage();
    abstract int withSkill();
    abstract void printSelected();
    abstract String getHealthString();
    abstract void setHealth(int value);

    abstract int getSkill_1();
    abstract int getSkill_2();
    abstract int getSkill_3();
}
