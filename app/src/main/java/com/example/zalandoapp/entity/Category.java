package com.example.zalandoapp.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "category_table")
public class Category {
    @PrimaryKey
    @NonNull
    private String categoryName;

    @NonNull
    private String[] subCategories;

    public Category(@NonNull String categoryName, @NonNull String[] subCategories) {
        this.categoryName = categoryName;
        this.subCategories = subCategories;
    }

    public void setCategoryName(@NonNull String categoryName) {
        this.categoryName = categoryName;
    }

    public void setSubCategories(@NonNull String[] subCategories) {
        this.subCategories = subCategories;
    }

    @NonNull
    public String getCategoryName() {
        return categoryName;
    }

    @NonNull
    public String[] getSubCategories() {
        return subCategories;
    }
}
