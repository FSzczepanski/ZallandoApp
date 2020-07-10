package com.example.zalandoapp.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "offer_table")
public class Offer {
    @PrimaryKey
    @NonNull
    private String oid;

    @NonNull
    private String title;

    private String description;

    @NonNull
    private int price;

    private int images;

    private String color;

    public Offer(@NonNull String oid, @NonNull String title, String description, int price, int images, String color) {
        this.oid = oid;
        this.title = title;
        this.description = description;
        this.price = price;
        this.images = images;
        this.color = color;
    }

    @NonNull
    public String getOid() {
        return oid;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImages() {
        return images;
    }

    public int getPrice() {
        return price;
    }

    public void setOid(@NonNull String oid) {
        this.oid = oid;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setImages(int images) {
        this.images = images;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}