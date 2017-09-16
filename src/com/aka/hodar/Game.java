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

        new Mage(this, 0, 500);
        new Warrior(this, 100, 500, 100);
        new NPC(this, 1150, 500);

        StackPane asd = new StackPane();
        asd.setLayoutX(Globals.SCREEN_WIDTH/2-160);
        asd.setLayoutY(Globals.SCREEN_HEIGHT-107);
        Globals.skillset = new ImageView();
        //Globals.skillset.setImage(new Image("warrior_skills.png"));
        asd.getChildren().add(Globals.skillset);
        getChildren().add(asd);

        /*
        here comes all the instantiation
         */
    }


    void setTableBackground(Image tableBackground){
        setBackground(new Background(new BackgroundImage(tableBackground,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }


}
