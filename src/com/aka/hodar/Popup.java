package com.aka.hodar;

import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;

public class Popup {

    public static void showSkillInfo(Event event, String info, double x, double y){
        Globals.skillInfo = new Tooltip();
        Globals.skillInfo.setText(info);
        Node node = (Node) event.getSource();
        Globals.skillInfo.show(node, Globals.primaryStage.getX()+Globals.SCREEN_WIDTH/2-140, Globals.primaryStage.getY()+Globals.SCREEN_HEIGHT-15);
    }

    public static void hideSkillInfo(){ Globals.skillInfo.hide(); }

}
