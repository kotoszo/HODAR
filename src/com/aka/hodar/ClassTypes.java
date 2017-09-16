package com.aka.hodar;

public enum ClassTypes {

    WARRIOR("warrior"), MAGE("mage"), ROGUE("rogue"), PALADIN("paladin"), PRIEST("priest"), WARLOCK("warlock");

    private String classType;

    ClassTypes(String classType) {
        this.classType = classType;
    }

    public String getClassType() {
        return classType;
    }
}
