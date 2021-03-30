package com.example.cookmasterf;

public class Recipe {
    private String name;
    private String time;
    private int calorie;

    Recipe(String name, String time, int calorie){
        this.name = name;
        this.time=time;
        this.calorie = 0;
    }

    public String getName(){
        return name;
    }

    public void setName(){
        this.name=name;
    }

    public String getTime(){
        return time;
    }

    public void setTime(){
        this.time=time;
    }

    public int getCalorie(){
        return calorie;
    }

    public void setCalorie(){
        this.calorie=calorie;
    }
}

