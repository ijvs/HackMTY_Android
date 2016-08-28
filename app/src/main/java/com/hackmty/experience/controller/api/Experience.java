package com.hackmty.experience.controller.api;

public class Experience {

    public String name;
    public String description;
    public double cost;
    public int image;
    public String filePath;

    public Experience(String name, String description, double cost, int image) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.image = image;
    }
    public Experience(String name, String description, double cost, String filePath) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.filePath = filePath;
    }
}
