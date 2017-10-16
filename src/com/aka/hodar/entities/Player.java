package com.aka.hodar.entities;

import com.aka.hodar.Globals;
import javafx.scene.layout.Pane;

public class Player extends Entities {
    String name;

    public Player(Pane pane, double x, double y, ClassTypes selectedClass){
        super(pane, x, y, selectedClass);
        setOnMouseClicked(event ->  { this.name=selectedClass.getClassName(); handleSelection(); });
        Globals.addEntity(this);
    }

    @Override
    void handleSelection() {
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
}
