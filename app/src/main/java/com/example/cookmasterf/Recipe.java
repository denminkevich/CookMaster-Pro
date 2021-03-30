package com.example.cookmasterf;

public class Recipe {
    private String name;
    private String time;
    private String calorie;
    private int imageResource;
    private int imageFavRes;

    Recipe(String name, String time, String calorie, int imageResource, int imageFavRes){
        this.name = name;
        this.time=time;
        this.calorie = calorie;
        this.imageResource = imageResource;
        this.imageFavRes = imageFavRes;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getTime(){
        return time;
    }

    public void setTime(String time){
        this.time=time;
    }

    public String getCalorie(){
        return calorie;
    }

    public void setCalorie(String calorie){
        this.calorie=calorie;
    }

    public int getImageResource() {
        return this.imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getImageFavRes() {
        return this.imageFavRes;
    }

    public void setImageFavRes(int imageFavRes) {
        this.imageFavRes = imageFavRes;
    }
}

