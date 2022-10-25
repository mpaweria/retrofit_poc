package com.example.retrofit_poc.model;

public class ResponseModel {

    private String link;
    private String profile_image;
    private String display_name;
    private String reputation;
    private String location;
    private String account_id;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public ResponseModel(String link, String profile_image, String display_name,
                         String reputation, String location, String account_id){

        this.link = link;
        this.profile_image = profile_image;
        this.display_name = display_name;
        this.reputation = reputation;
        this.location = location;
        this.account_id = account_id;
    }
}
