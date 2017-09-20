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
import javafx.stage.Stage;

public class MainMenu extends Pane {

    VBox vBox;
    boolean isClicked;
    ClassTypes selectedClass;

    public MainMenu(){
        setTableBackground(new Image("bgv2.jpg"));

        StackPane namePane = new StackPane();
        namePane.setLayoutX(Globals.SCREEN_WIDTH/2-100);namePane.setLayoutY(Globals.SCREEN_HEIGHT- Globals.SCREEN_HEIGHT/4);
        TextField nameField = new TextField();
        nameField.setText("Name of your character");
        namePane.getChildren().add(nameField);

        getChildren().addAll(namePane);

        double xCoordinates = 100;
        double yCoordinates = Globals.SCREEN_HEIGHT/2-Globals.warriorImage.getHeight()/2;
        for (ClassTypes classType: ClassTypes.values()) {
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

        Button btn = new Button();
        btn.setText("Play");
        btn.setOnMouseClicked(event -> {
            System.out.println(selectedClass);
            if (selectedClass != null){
                System.out.println(getChildren());
                Game game = new Game(selectedClass);
                Globals.primaryStage.setScene(new Scene(game, Globals.SCREEN_WIDTH, Globals.SCREEN_HEIGHT));
                Globals.primaryStage.show();
            }

        });
        btn.setLayoutX(Globals.SCREEN_WIDTH/2-nameField.getWidth());btn.setLayoutY(Globals.SCREEN_HEIGHT- Globals.SCREEN_HEIGHT/4+35);
        getChildren().add(btn);


    }

    private VBox setVbox(ClassTypes classType){
        String infoBuilder = String.format("Class: %s\n\n%s\n\nAgility: %s\nIntellect: %s\nStrength: %s\nHealth: %s",
                classType.getClassName(), classType.getStory(), classType.getAgility(),
                classType.getIntellect(), classType.getStrength(), classType.getHealth());
        vBox = new VBox();
        Text text = new Text(infoBuilder);
        text.getFont();
        vBox.getChildren().add(text);
        vBox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.setLayoutX(3*Globals.SCREEN_WIDTH/5+75);vBox.setLayoutY(Globals.SCREEN_HEIGHT/3);
        return vBox;
    }

    void setTableBackground(Image tableBackground){
        setBackground(new Background(new BackgroundImage(tableBackground,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }
}
