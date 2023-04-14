package com.example.tastytown.Model;

import java.io.Serializable;

public class Food implements Serializable {
    private String name;
    private int id;
    private int price;
    private String description;
    private String image;
    private int numberInCard;
    private String type;
    public int getNumberInCard() {
        return numberInCard;
    }

    public void setNumberInCard(int numberInCard) {
        this.numberInCard = numberInCard;
    }

    public Food(String image) {
        this.image = image;
    }
    public Food(String name, int price, String description, String image) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
