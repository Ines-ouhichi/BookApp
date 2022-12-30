package com.example.ktebi.ui.Models;

public class MainModel {
    String id;
    int image;
    String name,description,rating;

    public MainModel(int image, String name, String description,String rating) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.rating=rating;

    }

    public MainModel(String id, int image, String name, String description, String rating) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public MainModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
