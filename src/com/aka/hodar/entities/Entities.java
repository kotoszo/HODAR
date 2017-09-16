package com.aka.hodar.entities;

import com.aka.hodar.Globals;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public abstract class Entities extends ImageView {

    protected Pane pane;

    Entities(Pane pane, double x, double y, String name){
        this.pane = pane;
        StackPane stack = setHealthBar(x, y);
        pane.getChildren().addAll(this, stack);

        setX(x);setY(y);
        setOnMouseClicked(event ->  {
            handleSelection(name);
        });
        Globals.addHero(this);
    }

    Entities(Pane pane, double x, double y){
        this.pane = pane;
        StackPane stack = setHealthBar(x, y);
        pane.getChildren().addAll(this, stack);
        setX(x);setY(y);
        setOnMouseClicked(event -> {
            if (Globals.isSelected){
                setHealth(Globals.selectedEntity.getDamage());
                printSelected();
                pane.getChildren().remove(pane.getChildren().get(pane.getChildren().indexOf(this)+1));
                pane.getChildren().add(changeHealth(getX(), getY()));

            } else {
                System.out.println("First, select one of your characters");
            }
        });
        Globals.addEnemy(this);
    }

    abstract void printSelected();

    abstract int getHealth();
    abstract void setHealth(int value);

    abstract int getDamage();

    private void handleSelection(String name){
        if (Globals.chosenName == null){
            printSelected();
            Globals.isSelected = true;
            Globals.selectedEntity = this;
            Globals.chosenName = name;
            setImage(new Image("p1.png"));
            Globals.skillset.setImage(new Image("images/classes/"+Globals.chosenName+"/"+Globals.chosenName+"_skills.png"));
        } else {
            if (name == Globals.chosenName){
                setImage(new Image("images/classes/"+Globals.chosenName+"/"+Globals.chosenName+".png"));
                Globals.chosenName = null;
                Globals.isSelected = false;
                Globals.selectedEntity = null;
                Globals.skillset.setImage(new Image("empty.png"));
            } else {
                setHealth(50);
                pane.getChildren().remove(pane.getChildren().get(pane.getChildren().indexOf(this)+1));
                pane.getChildren().add(changeHealth(getX(), getY()));

            }
        }
    }

    private StackPane setHealthBar(double x, double y){
        StackPane stack = new StackPane();
        stack.setLayoutX(x+25); stack.setLayoutY(y-12);
        Text health = new Text("100");
        ImageView asd = new ImageView();
        asd.setImage(new Image("healthbar.png"));
        stack.getChildren().addAll(asd, health);
        return stack;
    }

    private StackPane changeHealth(double x, double y){
        StackPane stack = new StackPane();
        stack.setLayoutX(x+25); stack.setLayoutY(y-12);
        Text health = new Text(Integer.toString(getHealth()));
        ImageView asd = new ImageView();
        asd.setImage(new Image("healthbar.png"));
        stack.getChildren().addAll(asd, health);
        return stack;
    }
}
