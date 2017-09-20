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

        new Mage(this, 0, 340, 100);
        new Warrior(this, 180, 340, 100);
        new NPC(this, Globals.SCREEN_WIDTH - Globals.pirateImage.getWidth(), 340, 100);

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

    void setTableBackground(Image tableBackground){
        setBackground(new Background(new BackgroundImage(tableBackground,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }


}
