package com.example.zalandoapp.entity;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

public class SubCategory {
    @PrimaryKey
    @NonNull
    private String categoryName;

    public SubCategory(@NonNull String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryName(@NonNull String categoryName) {
        this.categoryName = categoryName;
    }


    @NonNull
    public String getCategoryName() {
        return categoryName;
    }


}
