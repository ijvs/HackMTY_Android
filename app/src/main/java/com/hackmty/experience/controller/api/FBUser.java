package com.hackmty.experience.controller.api;

public class FBUser {

    public int id;
    public String name;
    public String photo_url;

    public FBUser(int id, String name, String photo_url) {
        this.id = id;
        this.name = name;
        this.photo_url = photo_url;
    }

    public FBUser(String name, String photo_url) {
        this.name = name;
        this.photo_url = photo_url;
    }

}
