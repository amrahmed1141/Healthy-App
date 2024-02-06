package com.example.healthyapp.Domain;

import java.io.Serializable;

public class BestDealDomain implements Serializable {
    private String imgpath;
    private String title;
    private double price;
    private String description;
    private double rate;

    public BestDealDomain(String imgpath, String title, double price, String description, double rate) {
        this.imgpath = imgpath;
        this.title = title;
        this.price = price;
        this.description = description;
        this.rate = rate;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
