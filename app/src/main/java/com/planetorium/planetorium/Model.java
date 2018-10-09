package com.planetorium.planetorium;

public class Model {
    String name;
    String details;
    String description;
    String imageurl;
    Model(String name,String details, String description,String imageurl){
        this.name = name;
        this.details = details;
        this.description = description;
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public Model setName(String name) {
        this.name = name;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public Model setDetails(String details) {
        this.details = details;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Model setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageurl() {
        return imageurl;
    }

    public Model setImageurl(String imageurl) {
        this.imageurl = imageurl;
        return this;
    }
}
