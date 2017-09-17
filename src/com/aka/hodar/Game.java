package com.aka.hodar;

import com.aka.hodar.entities.Mage;
import com.aka.hodar.entities.NPC;
import com.aka.hodar.entities.Warrior;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class Game extends Pane{

    public Game(){
        setTableBackground(new Image("bgv2.jpg"));

        new Mage(this, 0, 500, 100);
        new Warrior(this, 100, 500, 100);
        new NPC(this, 1150, 500, 100);

        //Globals.skill_1 = new ImageView(); Globals.skill_2 = new ImageView(); Globals.skill_3 = new ImageView();
        int counter = 1; int skillWidth = 35;
        for (StackPane stackPane: Globals.skillPaneList) {
            stackPane = new StackPane();
            stackPane.setLayoutX(Globals.SCREEN_WIDTH/2-125+skillWidth);
            stackPane.setLayoutY(Globals.SCREEN_HEIGHT-85);
            switch (counter){
                case 1: stackPane.getChildren().add(Globals.skill_1);break;
                case 2: stackPane.getChildren().add(Globals.skill_2);break;
                case 3: stackPane.getChildren().add(Globals.skill_3);break;
            }
            getChildren().add(stackPane);
            counter++; skillWidth += 35;
        }
    }


    void setTableBackground(Image tableBackground){
        setBackground(new Background(new BackgroundImage(tableBackground,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }


}
