package com.hackmty.experience.controller.api;

public class Experience {

    public String name;
    public String description;
    double cost;
    public String place_id;
    public double lat;
    public double lon;

    public Experience(String name, String description, double cost, String place_id, double lat, double lon) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.place_id = place_id;
        this.lat = lat;
        this.lon = lon;
    }
}
