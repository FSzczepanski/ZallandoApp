package com.example.zalandoapp.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.zalandoapp.entity.Offer;

import java.util.List;

@Dao
public interface FavouriteDao {

    @Insert
    void insert(Offer favourite);

    @Update
    void update(Offer favourite);

    @Delete
    void delete(Offer favourite);

    @Query("DELETE FROM offer_table")
    void deleteAllNotes();

    @Query("SELECT* FROM offer_table")
    LiveData<List<Offer>> getAllNotes();
}



