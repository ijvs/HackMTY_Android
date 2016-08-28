package com.hackmty.experience.controller.api;

import java.util.List;

public class FBProvider extends FBUser{

    public String phone;
    public String account_number;
    public List<Experience> experiences;
    public int zip_code;

    public FBProvider(int id, String name, String photo_url, String phone, String account_number, List<Experience> experiences, int zip_code) {
        super(id, name, photo_url);
        this.phone = phone;
        this.account_number = account_number;
        this.experiences = experiences;
        this.zip_code = zip_code;
    }

    public FBProvider(String name, String photo_url, String phone, String account_number, List<Experience> experiences, int zip_code) {
        super(name, photo_url);
        this.phone = phone;
        this.account_number = account_number;
        this.experiences = experiences;
        this.zip_code = zip_code;
    }
}
