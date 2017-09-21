package com.aka.hodar;

import com.aka.hodar.entities.Entities;
import com.aka.hodar.entities.Mage;
import com.aka.hodar.entities.NPC;
import com.aka.hodar.entities.Warrior;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class Game extends Pane{

    public Game(ClassTypes selectedClass){
        setTableBackground(Images.BG_BASIC.getImage());
        addHero(selectedClass);

        new NPC(this, Globals.SCREEN_WIDTH - Globals.pirateImage.getWidth(), Globals.COMMON_Y);

        setSkillImages();

    }
    void setSkillImages(){
        int index = 0; int skillWidth = 35;
        for (StackPane stackPane: Globals.skillPaneList) {
            stackPane = new StackPane();
            stackPane.setLayoutX(Globals.SCREEN_WIDTH/2-125+skillWidth);
            stackPane.setLayoutY(Globals.SCREEN_HEIGHT-85);
            Globals.skillImages[index] = new ImageView();
            Globals.skillImages[index].setId(Integer.toString(index));
            stackPane.getChildren().add(Globals.skillImages[index]);

            getChildren().add(stackPane);
            index++; skillWidth += 35;
        }
    }

    void addHero(ClassTypes selectedClass){
        switch (selectedClass){
            case MAGE:
                new Mage(this, Globals.PLAYER_X, Globals.COMMON_Y, selectedClass);break;
            case WARRIOR:
                new Warrior(this,  Globals.PLAYER_X, Globals.COMMON_Y, selectedClass);break;
        }
    }

    void setTableBackground(Image tableBackground){
        setBackground(new Background(new BackgroundImage(tableBackground,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }


}
