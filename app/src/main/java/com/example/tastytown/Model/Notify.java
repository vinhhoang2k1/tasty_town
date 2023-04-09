package com.example.tastytown.Model;

public class Notify {
    private String shopName;
    public String time;
    public String message;
    private String thumbnail;

    public Notify(String shopName, String time, String message, String thumbnail) {
        this.shopName = shopName;
        this.time = time;
        this.message = message;
        this.thumbnail = thumbnail;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
