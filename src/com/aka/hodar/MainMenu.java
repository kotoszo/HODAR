package com.aka.hodar;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainMenu extends Pane {

    VBox vBox;
    boolean isClicked;
    ClassTypes selectedClass;
    private final static double VBOX_X = 3*Globals.SCREEN_WIDTH/5+75;
    private final static double VBOX_Y = Globals.SCREEN_HEIGHT/3;
    private final static double TEXT_THINGS_WIDTH = 250;
    private static int index = 0;
    private static double xCoordinates = Globals.SCREEN_WIDTH/2-ClassTypes.values()[index].getImage().getWidth();
    private static double yCoordinates = Globals.SCREEN_HEIGHT/2-ClassTypes.values()[index].getImage().getWidth()/2;

    ImageView charImage = new ImageView();

    public MainMenu(){
        setTableBackground(Images.BG_BASIC.getImage());
        setTextField();

        ImageView previousChar = arrowMaker(Images.LEFT_ARROW);
        previousChar.setOnMouseClicked(event -> {
            System.out.println("BALRA");
            getChildren().remove(ClassTypes.values()[index]);
            if (MainMenu.index-1 < 0) MainMenu.index = ClassTypes.values().length;
            selectionScreen(MainMenu.index-=1);
        });
        getChildren().add(previousChar);

        ImageView nextChar = arrowMaker(Images.RIGHT_ARROW);
        nextChar.setOnMouseClicked(event -> {
            System.out.println("JOBBRA");
            getChildren().remove(ClassTypes.values()[index]);
            if (MainMenu.index+1 == ClassTypes.values().length) MainMenu.index = -1;
            selectionScreen(MainMenu.index+=1);
        });
        getChildren().add(nextChar);

        selectionScreen(index);
        setButton();
    }

    private ImageView arrowMaker(Images arrow){
        ImageView nextChar = new ImageView();
        nextChar.setImage(arrow.getImage());
        if (arrow.equals(Images.RIGHT_ARROW)) nextChar.setLayoutX(xCoordinates+ClassTypes.values()[index].getImage().getWidth());
        else nextChar.setLayoutX(xCoordinates-arrow.getImage().getWidth());
        nextChar.setLayoutY(Globals.SCREEN_HEIGHT/2-arrow.getImage().getWidth()/2);
        return nextChar;
    }

    private void selectionScreen(int index){
        System.out.println(index);
        StackPane imageStack = new StackPane();

        charImage.setScaleX(0.75);charImage.setScaleY(0.75);
        imageStack.setLayoutX(xCoordinates);imageStack.setLayoutY(yCoordinates);

        charImage.setImage(ClassTypes.values()[index].getImage());
        setVbox(ClassTypes.values()[index]);
        selectedClass = ClassTypes.values()[index];
        getChildren().add(vBox);
        imageStack.getChildren().addAll(charImage);
        getChildren().addAll(imageStack);
    }

    private void setButton(){
        Button btn = new Button();
        btn.setText("Play");
        btn.setLayoutX(VBOX_X+TEXT_THINGS_WIDTH/2-25);
        btn.setLayoutY(Globals.SCREEN_HEIGHT- Globals.SCREEN_HEIGHT/3);
        btn.setOnMouseClicked(event -> {
            if (selectedClass != null){
                Game game = new Game(selectedClass);
                Globals.primaryStage.setScene(new Scene(game, Globals.SCREEN_WIDTH, Globals.SCREEN_HEIGHT));
                Globals.primaryStage.show();
            }
        });
        getChildren().add(btn);
    }

    private void setTextField(){
        StackPane namePane = new StackPane();
        namePane.setPrefWidth(TEXT_THINGS_WIDTH);
        namePane.setLayoutX(VBOX_X);namePane.setLayoutY(Globals.SCREEN_HEIGHT- Globals.SCREEN_HEIGHT/3-50);
        TextField nameField = new TextField();
        nameField.setText("Name of your character");
        namePane.getChildren().add(nameField);

        getChildren().addAll(namePane);
    }

    private VBox setVbox(ClassTypes classType){
        String infoBuilder = String.format("Class: %s\n\n%s\n\nAgility: %s\nIntellect: %s\nStrength: %s\nHealth: %s",
                classType.getClassName(), classType.getStory(), classType.getAgility(),
                classType.getIntellect(), classType.getStrength(), classType.getHealth());
        vBox = new VBox();
        vBox.setPrefWidth(TEXT_THINGS_WIDTH);
        Text text = new Text(infoBuilder);
        vBox.getChildren().add(text);
        vBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.setLayoutX(VBOX_X);vBox.setLayoutY(VBOX_Y);
        return vBox;
    }

    void setTableBackground(Image tableBackground){
        setBackground(new Background(new BackgroundImage(tableBackground,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }
}
