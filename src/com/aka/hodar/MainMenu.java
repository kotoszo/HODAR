package com.aka.hodar;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Iterator;

public class MainMenu extends Pane {

    VBox vBox;
    boolean isClicked;
    ClassTypes selectedClass;
    private final static double VBOX_X = 3*Globals.SCREEN_WIDTH/5+75;
    private final static double VBOX_Y = Globals.SCREEN_HEIGHT/3;
    private final static double TEXT_THINGS_WIDTH = 250;

    public MainMenu(){
        setTableBackground(Images.BG_BASIC.getImage());
        setTextField();

        double xCoordinates = 100;
        double yCoordinates = Globals.SCREEN_HEIGHT/2-Globals.warriorImage.getHeight()/2;



        for (ClassTypes classType: ClassTypes.values()) {
            if (classType.equals(ClassTypes.PIRATE)) break;
            ImageView charImage = new ImageView();
            StackPane imageStack = new StackPane();

            charImage.setScaleX(0.75);charImage.setScaleY(0.75);
            imageStack.setLayoutX(xCoordinates);imageStack.setLayoutY(yCoordinates);

            charImage.setImage(classType.getImage());
            charImage.setOnMouseClicked(event -> {
                if (isClicked) getChildren().remove(vBox);
                setVbox(classType);
                selectedClass = classType;
                getChildren().add(vBox);
                isClicked = !isClicked;
            });
            xCoordinates += Globals.warriorImage.getWidth();
            imageStack.getChildren().addAll(charImage);
            getChildren().addAll(imageStack);
        }
        setButton();
    }

    private void setButton(){
        Button btn = new Button();
        btn.setText("Play");
        btn.setLayoutX(VBOX_X+TEXT_THINGS_WIDTH/2-25);
        btn.setLayoutY(Globals.SCREEN_HEIGHT- Globals.SCREEN_HEIGHT/3);
        btn.setOnMouseClicked(event -> {
            System.out.println(selectedClass);
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
