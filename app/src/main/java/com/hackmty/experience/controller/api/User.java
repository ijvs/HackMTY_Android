package com.hackmty.experience.controller.api;


public class User {

    public String name;
    public int image;
    public String date;
    public int stars;

    public User(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public User(String name, int image, String date, int stars) {
        this.name = name;
        this.image = image;
        this.date = date;
        this.stars = stars;
    }
}
