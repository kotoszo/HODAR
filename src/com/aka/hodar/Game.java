package com.aka.hodar;

import com.aka.hodar.Animator.GameLoop;
import com.aka.hodar.entities.ClassTypes;
import com.aka.hodar.entities.Enemy;
import com.aka.hodar.entities.Player;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class Game extends Pane{

    public Game(ClassTypes selectedClass){
        setTableBackground(Images.BG_BASIC.getImage());
        addHero(selectedClass);
        Globals.enemyClass =  ClassTypes.values()[Globals.random.nextInt(2)];
        Globals.enemyEntity = new Enemy(this, Globals.ENEMY_X, Globals.COMMON_Y);

        setSkillImages();
        Globals.gameLoop = new GameLoop();

    }
    void setSkillImages(){
        int index = 0; double skillWidth = 0;
        for (StackPane stackPane: Globals.skillPaneList) {
            stackPane = new StackPane();
            stackPane.setLayoutX(Globals.SCREEN_WIDTH/2-(Images.BASIC_ATTACK.getImage().getWidth()*1.5)+skillWidth);
            stackPane.setLayoutY(Globals.SCREEN_HEIGHT-Images.BASIC_ATTACK.getImage().getHeight());
            Globals.skillImages[index] = new ImageView();
            Globals.skillImages[index].setId(Integer.toString(index));
            stackPane.getChildren().add(Globals.skillImages[index]);

            getChildren().add(stackPane);
            index++; skillWidth += Images.BASIC_ATTACK.getImage().getWidth();
        }
    }

    void addHero(ClassTypes selectedClass){
        new Player(this, Globals.PLAYER_X, Globals.COMMON_Y, selectedClass);
    }

    void setTableBackground(Image tableBackground){
        setBackground(new Background(new BackgroundImage(tableBackground,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }
}
