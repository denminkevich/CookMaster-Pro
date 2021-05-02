package com.example.cookmasterf;

public class Ingridients {
    private String name;
    private boolean inFridge;

    Ingridients(String name, boolean inFridge) {
        this.name = name;
        this.inFridge = inFridge;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public boolean getInFridge(){
        return inFridge;
    }

    public void setInFridge(boolean fridge){
        this.inFridge=fridge;
    }
}
